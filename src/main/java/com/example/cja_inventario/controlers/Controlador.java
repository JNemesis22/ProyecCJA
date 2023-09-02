package com.example.cja_inventario.controlers;

import com.example.cja_inventario.interfaceServices.IEquipoService;
import com.example.cja_inventario.interfaceServices.IOrdenServicioService;
import com.example.cja_inventario.interfaceServices.I_usuarioServices;
import com.example.cja_inventario.models.Equipo;
import com.example.cja_inventario.models.OrdenServicio;
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
public class Controlador {
    @Autowired
    private IOrdenServicioService service;

    @Autowired
    private I_usuarioServices serviceUser;

    @Autowired
    private IEquipoService serviceEq;
    @GetMapping("/listar")
    public String listar(Model model) {
        List<OrdenServicio> ordenServicios = service.Listar();
        List<Equipo> equipos = serviceEq.Listar();
        if (serviceUser.ValidarSesionCliente()==null){
            return "redirect:/IniciarSesion";
        }
        model.addAttribute("user", serviceUser.ValidarSesionCliente());

        model.addAttribute("ordenServicios", ordenServicios);
        model.addAttribute("equipos", equipos);

        return "index";
        //return "administrador/OrdenServicio";
    }
    @GetMapping("/listarOrdenService")
    public String listarOrdenAdmin(Model model) {
        List<OrdenServicio> ordenServicios = service.Listar();
        List<Equipo> equipos = serviceEq.Listar();
        if (serviceUser.ValidarSesionAdmin()==null){
            return "redirect:/IniciarSesion";
        }
        model.addAttribute("user", serviceUser.ValidarSesionAdmin());

        model.addAttribute("ordenServicios", ordenServicios);
        model.addAttribute("equipos", equipos);

        //return "index";
        return "administrador/OrdenServicio";
    }
    @GetMapping("/new/{id}")
    public String agregar(Model model, @PathVariable int id){
        OrdenServicio orden = new OrdenServicio();
        Optional<Equipo> equipo = serviceEq.ListarID(id);
        Equipo eq=equipo.orElse(null);
        orden.setEquipo(eq);
        if (serviceUser.ValidarSesionCliente()==null){
            return "redirect:/IniciarSesion";
        }
        model.addAttribute("user", serviceUser.ValidarSesionCliente());
        model.addAttribute("equipo",eq);
        model.addAttribute("OrdenServicio", orden);
        return "form";
    }
    @PostMapping("/save")
    public String save (@Validated OrdenServicio o, Model model){
        if (serviceUser.ValidarSesionCliente()==null){
            return "redirect:/IniciarSesion";
        }
        model.addAttribute("user", serviceUser.ValidarSesionCliente());
        service.save(o);
        return "administrador/registroOrden";
    }
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model){
        Optional<OrdenServicio>Ordenservicio=service.ListarID(id);
        if (serviceUser.ValidarSesionCliente()==null){
            return "redirect:/IniciarSesion";
        }
        model.addAttribute("user", serviceUser.ValidarSesionCliente());
        model.addAttribute("OrdenServicio",Ordenservicio);
        return "form";
    }
    @GetMapping("/eliminar/{id}")
    public String delete(Model model,@PathVariable int id){
        service.delete(id);
        return "redirect:/listar";
    }


}

