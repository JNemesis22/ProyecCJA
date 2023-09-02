package com.example.cja_inventario.controlers;


import com.example.cja_inventario.interfaceServices.I_categoriaServices;
import com.example.cja_inventario.interfaceServices.I_productoServices;
import com.example.cja_inventario.interfaceServices.I_usuarioServices;
import com.example.cja_inventario.models.Categoria;
import com.example.cja_inventario.models.Producto;
import com.example.cja_inventario.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.model.IAttribute;

import javax.management.InvalidAttributeValueException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("")
public class CategoriaController {

    @Autowired

    private I_categoriaServices service;
    @Autowired

    private I_productoServices servicesProd;

    @Autowired
    private I_usuarioServices serviceUser;


    @GetMapping("/categoria")
    public String listar(Model model){
       List<Categoria>categoria=service.listar();
        if (serviceUser.ValidarSesionAdmin()==null){
            return "redirect:/IniciarSesion";
        }
        model.addAttribute("user", serviceUser.ValidarSesionAdmin());

       model.addAttribute("categoria",categoria);

        return "administrador/CategoriasIndex";
    }

    @GetMapping("/newCategoria")
    public String create(Model model){
        if (serviceUser.ValidarSesionAdmin()==null){
            return "redirect:/IniciarSesion";
        }
        model.addAttribute("user", serviceUser.ValidarSesionAdmin());
        model.addAttribute("categoria", new Categoria());

        return "administrador/CreateCategoria";
    }
    @PostMapping("/new")
    public String save(@Validated Categoria cat,Model model){

        if (cat.getId() == null || cat.getId() == 0) {

            if( service.validarDuplicados(cat)){
                return "redirect:/categoria";            }

        }

            service.save(cat);

        return "redirect:/categoria";
    }


    @GetMapping("/edit/{id}")
    public String editar(@PathVariable int id, Model model){
        if (serviceUser.ValidarSesionAdmin()==null){
            return "redirect:/IniciarSesion";
        }
        model.addAttribute("user", serviceUser.ValidarSesionAdmin());
        Optional<Categoria>categoria =service.listarId(id);
        model.addAttribute("categoria",categoria);

        return "administrador/CreateCategoria";

    }
    /*public String editar(@PathVariable int id, Model model){
        Optional<Categoria> optionalCategoria = service.listarId(id);
        if (optionalCategoria.isPresent()) {
            Categoria categoria = optionalCategoria.get();
            model.addAttribute("categoria", categoria);
        }

        return "administrador/CreateCategoria";
    }

*/
    @GetMapping("/eliminarCategoria/{id}")
public String delete(Model model, @PathVariable int id){

        List<Producto> productos=servicesProd.listar();
        int cont=0;
        for ( Producto producto:productos) {
            if(producto.getCategoria().getId()==id){
                cont++;
            }

        }
        if (cont==0){
            service.delete(id);
        }


    return "redirect:/categoria";
}

}
