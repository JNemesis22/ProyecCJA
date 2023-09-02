package com.example.cja_inventario.controlers;


import com.example.cja_inventario.interfaceServices.I_detalleServices;
import com.example.cja_inventario.interfaceServices.I_ordenServices;
import com.example.cja_inventario.interfaceServices.I_productoServices;
import com.example.cja_inventario.interfaceServices.I_usuarioServices;
import com.example.cja_inventario.interfaces.I_proveedores;
import com.example.cja_inventario.models.DetalleOrden;
import com.example.cja_inventario.models.Orden;
import com.example.cja_inventario.models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("")
public class DetalleController {
    @Autowired

    private I_detalleServices service;

    @Autowired
    private I_productoServices serviceProd;

    @Autowired

    private I_ordenServices serviceOrd;
    private I_proveedores serveceProv;
    @Autowired
    private I_usuarioServices serviceUser;


    @GetMapping ("/newOrdenDetalle")
    public String create(@ModelAttribute("orden") Orden ord, Model model){
        if (serviceUser.ValidarSesionAdmin()==null){
            return "redirect:/IniciarSesion";
        }
        model.addAttribute("user", serviceUser.ValidarSesionAdmin());
        DetalleOrden detalle= new DetalleOrden();
        List<Producto> producto = serviceProd.listar();
        List<DetalleOrden> dt=service.listarIdOrden(ord.getId());
        detalle.setOrden(ord);
        model.addAttribute("producto",producto);
        model.addAttribute("detalle", detalle);
        model.addAttribute("dt",dt);
        model.addAttribute("orden",ord);
        return "administrador/CrearDetalle";
    }

    @PostMapping("/newDetalle")
    public String save(@Validated DetalleOrden dt, Model model, Orden ord, RedirectAttributes redirect){
        Optional<Producto> producto = serviceProd.listarId(dt.getProductos().getId());
        Producto prod = producto.orElse(null);

        Optional<Orden> orden = serviceOrd.listarId(dt.getOrden().getId());
        Orden or = orden.isPresent() ? orden.get() : null;

        if (prod != null && or != null) {
            // Realizar las operaciones necesarias con el producto
            double total = prod.getPrecio() * dt.getCantidad();
            or.setTotal(or.getTotal()+total);
            serviceOrd.save(or);

            // Resto del código
        }
        service.save(dt);
        redirect.addAttribute("orden",or);
        return "redirect:/newOrdenDetalle";
    }

    /*
    @GetMapping("/editDetalle")

    public String editar(@ModelAttribute("id") int id,Model model){
       List<DetalleOrden>dt=service.listarIdOrden(id);
        Optional<Orden> ord=serviceOrd.listarId(id);
        Orden orden=ord.orElse(null);
        model.addAttribute("detalle", dt);
        model.addAttribute("orden", orden);
        List<Producto> producto= serviceProd.listar();
        model.addAttribute("producto",producto);

         return "administrador/CrearDetalle";
    }
*/
    @GetMapping("/elimProdDet/{id}")
    public String eliminarProducto(@PathVariable int id,RedirectAttributes redirect){
        Optional<DetalleOrden>detalleOrden =service.listarId(id);
        DetalleOrden dt=detalleOrden.orElse(null);
        Optional<Producto> producto = serviceProd.listarId(dt.getProductos().getId());
        Producto prod = producto.orElse(null);
        Optional<Orden> orden = serviceOrd.listarId(dt.getOrden().getId());
        Orden or = orden.isPresent() ? orden.get() : null;
        if (prod != null && or != null) {
            // Realizar las operaciones necesarias con el producto
            double total = prod.getPrecio() * dt.getCantidad();
            or.setTotal(or.getTotal()-total);
            serviceOrd.save(or);

            // Resto del código
        }
        service.delete(dt.getId());
        redirect.addAttribute("orden",or);
        return "redirect:/newOrdenDetalle";
    }

}
