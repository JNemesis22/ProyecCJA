package com.example.cja_inventario.controlers;

import com.example.cja_inventario.interfaceServices.IEquipoService;
import com.example.cja_inventario.interfaceServices.I_usuarioServices;
import com.example.cja_inventario.models.Equipo;
import com.example.cja_inventario.models.Usuario;
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
public class Controlador2 {
    @Autowired
    private IEquipoService service;

    @Autowired
    private I_usuarioServices serviceUser;



    @GetMapping("/listar2")
    public String listar(Model model) {
        List<Equipo> equipos = service.Listar();
        if (serviceUser.ValidarSesionCliente()==null){
            return "redirect:/IniciarSesion";
        }
        model.addAttribute("user", serviceUser.ValidarSesionCliente());
        model.addAttribute("equipos", equipos);
        return "index2";
    }

    @GetMapping("/new2")
    public String agregar(Model model) {
        Equipo equipo= new Equipo();
        if (serviceUser.ValidarSesionCliente()==null){
            return "redirect:/IniciarSesion";
        }
        model.addAttribute("user", serviceUser.ValidarSesionCliente());

        equipo.setUsuario(serviceUser.ValidarSesionCliente());


        model.addAttribute("equipo", equipo);
        return "form2";
    }

    @PostMapping("/save2")
    public String save(@Validated Equipo equipo, Model model) {
        service.save(equipo);
        return "redirect:/listar2";
    }
    @GetMapping("/editar2/{id}")
    public String editar(@PathVariable int id, Model model){
        Optional<Equipo>equipo=service.ListarID(id);
        if (serviceUser.ValidarSesionCliente()==null){
            return "redirect:/IniciarSesion";
        }

        model.addAttribute("user", serviceUser.ValidarSesionCliente());
        model.addAttribute("equipo",equipo);
        return "form2";
    }
    @GetMapping ("/eliminar2/{id}")
    public String delete(Model model,@PathVariable int id){
        service.delete(id);
        return "redirect:/listar2";
    }
}
