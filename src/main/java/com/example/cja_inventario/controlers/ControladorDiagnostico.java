package com.example.cja_inventario.controlers;

import com.example.cja_inventario.interfaceServices.IDiagnosticoService;
import com.example.cja_inventario.interfaceServices.IEquipoService;
import com.example.cja_inventario.interfaceServices.I_usuarioServices;
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
public class ControladorDiagnostico {

    @Autowired
    private IDiagnosticoService service;

    @Autowired
    private IEquipoService serviceEq;

    @Autowired
    private I_usuarioServices serviceUser;

    @GetMapping("/listarDiag")
    public String listar(Model model) {
        List<Diagnostico> diagnosticos = service.listar();
        List<Equipo> equipos = serviceEq.Listar();
        if (serviceUser.ValidarSesionCliente()==null){
            return "redirect:/IniciarSesion";
        }
        model.addAttribute("user", serviceUser.ValidarSesionCliente());
        model.addAttribute("diagnosticos", diagnosticos);
        model.addAttribute("equipos", equipos);
        return "indexDiag";
    }

    @GetMapping("/newDiag/{id}")
    public String agregar(@PathVariable int id, Model model) {
        Diagnostico diagnostico = new Diagnostico();
        Optional<Equipo> equipo = serviceEq.ListarID(id);
        Equipo eq = equipo.orElse(null);
        diagnostico.setEquipo(eq);
        if (serviceUser.ValidarSesionAdmin()==null){
            return "redirect:/IniciarSesion";
        }
        model.addAttribute("user", serviceUser.ValidarSesionAdmin());
        model.addAttribute("diagnostico", diagnostico);
        model.addAttribute("equipo", eq); // Agrega el equipo al modelo
        return "formDiag";
    }

    @PostMapping("/saveDiag")
    public String save(@Validated Diagnostico d, Model model) {
        service.save(d);
        //return "redirect:/listarDiag";
        return  "redirect:/listarAgenAdmin";
    }

    @GetMapping("/editarDiag/{id}")
    public String editar(@PathVariable int id, Model model) {
        Optional<Diagnostico> diagnostico = service.listarID(id);
        model.addAttribute("diagnostico", diagnostico);
        return "formDiag";
    }

    @GetMapping("/eliminarDiag/{id}")
    public String delete(@PathVariable int id) {
        service.delete(id);
        return "redirect:/listarDiag";
    }
}