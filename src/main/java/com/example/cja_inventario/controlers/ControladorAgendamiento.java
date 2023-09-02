package com.example.cja_inventario.controlers;

import com.example.cja_inventario.interfaceServices.IAgendamientoService;
import com.example.cja_inventario.interfaceServices.IDiagnosticoService;
import com.example.cja_inventario.interfaceServices.IEquipoService;
import com.example.cja_inventario.interfaceServices.I_usuarioServices;
import com.example.cja_inventario.models.Agendamiento;
import com.example.cja_inventario.models.Diagnostico;
import com.example.cja_inventario.models.Equipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class ControladorAgendamiento {
    @Autowired
    public IAgendamientoService service;
    @Autowired
    public IDiagnosticoService servicedi;
    @Autowired
    public IEquipoService serviceeq;

    @Autowired
    public I_usuarioServices serviceUser;

    @GetMapping("/listarAgen")
    public String listar(Model model){
        List<Agendamiento> agendamientos = service.listar();
        List<Equipo> equipos = serviceeq.Listar();
        List<Diagnostico>diagnosticos=servicedi.listar();
        if (serviceUser.ValidarSesionCliente()==null){
            return "redirect:/IniciarSesion";
        }
        model.addAttribute("user", serviceUser.ValidarSesionCliente());
        model.addAttribute("diagnosticos", diagnosticos);
        model.addAttribute("agendamientos", agendamientos);
        model.addAttribute("equipos", equipos);
        return "indexAgen";
        //return "administrador/AgendamientoServicio";
    }

    @GetMapping("/listarAgenAdmin")
    public String listarAdmin(Model model){
        List<Agendamiento> agendamientos = service.listar();
        List<Equipo> equipos = serviceeq.Listar();
        List<Diagnostico>diagnosticos=servicedi.listar();
        if (serviceUser.ValidarSesionAdmin()==null){
            return "redirect:/IniciarSesion";
        }
        model.addAttribute("user", serviceUser.ValidarSesionAdmin());
        model.addAttribute("diagnosticos", diagnosticos);
        model.addAttribute("agendamientos", agendamientos);
        model.addAttribute("equipos", equipos);
        //return "indexAgen";
        return "administrador/AgendamientoServicio";
    }



    @GetMapping("/newAgendamiento/{id}")
    public String agregar(@PathVariable int id, Model model){
        Agendamiento agendamiento = new Agendamiento();
        Optional<Diagnostico> diagnostico = servicedi.listarID(id);
        Diagnostico di = diagnostico.orElse(null);
        agendamiento.setDiagnostico(di);
        if (serviceUser.ValidarSesionCliente()==null){
            return "redirect:/IniciarSesion";
        }

        model.addAttribute("user", serviceUser.ValidarSesionCliente());
        model.addAttribute("diagnostico", di);
        model.addAttribute("agendamiento", agendamiento);
        return "formAgen";
    }

    @PostMapping("/saveAgendamiento")
    public String save(@Validated Agendamiento a, Model model){
        service.save(a);
        return "redirect:/listarAgen";
    }
}
