package com.example.cja_inventario.services;

import com.example.cja_inventario.interfaceServices.I_detalleServices;
import com.example.cja_inventario.interfaces.I_detalle;
import com.example.cja_inventario.models.DetalleOrden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DetalleServices implements I_detalleServices {
    @Autowired
    private I_detalle date;

    @Override
    public List<DetalleOrden> listar() {

        return (List<DetalleOrden>) date.findAll();

    }

    @Override
    public List<DetalleOrden> listarIdOrden(int id) {
        List<DetalleOrden> dt = listar();
        List<DetalleOrden> dta = new ArrayList<>();

        for (DetalleOrden detalle : dt) {
            if (detalle.getOrden().getId() == id) {
                dta.add(detalle);
            }
        }

        return dta;
    }

    @Override
    public Optional<DetalleOrden> listarId(int id) {

        return date.findById(id);
    }

    @Override
    public int save(DetalleOrden dt) {
        int res=0;
        DetalleOrden detalle=date.save(dt);
        if(!detalle.equals(null)){
            res=1;

        }
        return res;
    }

    @Override
    public void delete(int id) {
        date.deleteById(id);

    }
}
