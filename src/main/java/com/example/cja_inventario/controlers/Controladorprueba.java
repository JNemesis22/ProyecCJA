package com.example.cja_inventario.controlers;

import com.example.cja_inventario.interfaceServices.IAgendamientoService;
import com.example.cja_inventario.interfaceServices.IDiagnosticoService;
import com.example.cja_inventario.interfaceServices.IEquipoService;
import com.example.cja_inventario.models.Agendamiento;
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
public class Controladorprueba {
    @Autowired
    public IAgendamientoService service;
    @Autowired
    public IDiagnosticoService servicedi;
    @Autowired
    public IEquipoService serviceeq;

    @GetMapping("/listarAgen2")
    public String listar(Model model){
        List<Agendamiento> agendamientos = service.listar();
        List<Equipo> equipos = serviceeq.Listar();
        List<Diagnostico>diagnosticos=servicedi.listar();
        model.addAttribute("diagnosticos", diagnosticos);
        model.addAttribute("agendamientos", agendamientos);
        model.addAttribute("equipos", equipos);
        return "PruebaExel";
    }
}
