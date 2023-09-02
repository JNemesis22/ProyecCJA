package com.example.cja_inventario.controlers;

import com.example.cja_inventario.interfaceServices.I_usuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class serviciotecControler {

    @Autowired
    private I_usuarioServices serviceUser;
    @GetMapping("/menuST")
    public String menuST(Model model){

        if (serviceUser.ValidarSesionCliente()==null){
            return "redirect:/IniciarSesion";
        }
        model.addAttribute("user", serviceUser.ValidarSesionCliente());
        return "administrador/MenuST";}

    @GetMapping("/opcionesST")
    public String opciones(){return "administrador/ServicioTec1";}


    @GetMapping("/servicioEquipo")
    public String correctivo(){return "administrador/ServicioCor";}


    @GetMapping("/ordenST")
    public String orden(){return "administrador/ordenServicio";}
    @GetMapping("/menuAdmin")
    public String menuadmind(){
        return "administrador/MenuCJAUser";
    }
}
