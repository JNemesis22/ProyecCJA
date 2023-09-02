package com.example.cja_inventario.controlers;

import com.example.cja_inventario.interfaceServices.IEquipoService;
import com.example.cja_inventario.interfaceServices.IOrdenServicioService;
import com.example.cja_inventario.models.Equipo;
import com.example.cja_inventario.models.OrdenServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping
public class ControlerOrdenExel {
    @Autowired
    private IOrdenServicioService service;

    @Autowired
    private IEquipoService serviceEq;
    @GetMapping("/listarEX")
    public String listar(Model model) {
        List<OrdenServicio> ordenServicios = service.Listar();
        List<Equipo> equipos = serviceEq.Listar();

        model.addAttribute("ordenServicios", ordenServicios);
        model.addAttribute("equipos", equipos);

        return "OrdenExel";
    }
}
