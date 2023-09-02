package com.example.cja_inventario.controlers;
import com.example.cja_inventario.domain.EmailDTO;
import com.example.cja_inventario.domain.EmailFileDTO;
import com.example.cja_inventario.interfaceServices.I_emailServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping()
public class MailController {

    @Autowired
    private I_emailServices emailServices;

    @PostMapping("/sendMassage")
    public ResponseEntity<?> receveRequestEmail( @RequestBody EmailDTO emailDTO){

        System.out.println("Mensaje recibido"+ emailDTO);
        emailServices.sendEmail(emailDTO.getToUser(),emailDTO.getSubject(),emailDTO.getMassage());
        Map<String,String> response = new HashMap<>();
        response.put("estado","Enviado");
        return  ResponseEntity.ok(response);
    }

    @PostMapping("/sendMassageFile")
    public ResponseEntity<?> receveRequestEmailwithFile(@ModelAttribute EmailFileDTO emailFileDTO) {

        try {
            String nameFile = emailFileDTO.file().getOriginalFilename();
            // Path path= Paths.get("src/mail/resources/Files"+ nameFile);
            Path path = Paths.get("src/resources/Files" + nameFile);
            Files.createDirectories(path.getParent());
            Files.copy(emailFileDTO.file().getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            File file = path.toFile();
            emailServices.sendEmailWithFile(emailFileDTO.toUser(), emailFileDTO.subject(), emailFileDTO.massage(), file);
            Map<String, String> response = new HashMap<>();
            response.put("estado", "Enviado");
            response.put("archivo", "Enviado");
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            throw new RuntimeException("Error al enviar el correo con un archivo" + e.getMessage());
        }

    }

    }
