package com.example.cja_inventario.controlers;

import com.example.cja_inventario.domain.EmailDTO;
import com.example.cja_inventario.interfaceServices.I_usuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("")
public class LoginController {

    @Autowired
    private I_usuarioServices serviceUser;

    @Autowired
    private MailController emailCon;



    @GetMapping("/IniciarSesion")
    public String login(){

        return "administrador/login";
    }
    @GetMapping("/menu")
    public String menu(Model model){

        model.addAttribute("user",serviceUser.ValidarSesionCliente());

        return "administrador/MenuCJA";
    }


    @GetMapping("/recuperarPassword")
    public String recuperarContraseña(){

        return "administrador/RecuperarContraseña";
    }

    @PostMapping("/emailRecuperacion")
    public String enviarEmail(@RequestParam("Correo") String correo, Model model){
         String[] emails={correo};
         String sub="Recuperacion de Contraseña";
         String mensaje="Tu contraseña es  *******";
         EmailDTO emailDTO= new EmailDTO(emails,sub,mensaje);
         emailCon.receveRequestEmail(emailDTO);
        return "redirect:/IniciarSesion";
    }
}
