package com.example.cja_inventario.controlers;

import com.example.cja_inventario.interfaceServices.IDiagnosticoService;
import com.example.cja_inventario.interfaceServices.IEquipoService;
import com.example.cja_inventario.models.Diagnostico;
import com.example.cja_inventario.models.Equipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping
public class ControladorPruebaExel {

    @Autowired
    private IDiagnosticoService service;

    @Autowired
    private IEquipoService serviceEq;

    @GetMapping("/listarDiagEX")
    public String listar(Model model) {
        List<Diagnostico> diagnosticos = service.listar();
        List<Equipo> equipos = serviceEq.Listar();
        model.addAttribute("diagnosticos", diagnosticos);
        model.addAttribute("equipos", equipos);

        return "DiagnosticoExel";
    }


}