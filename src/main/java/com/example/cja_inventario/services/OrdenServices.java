package com.example.cja_inventario.services;

import com.example.cja_inventario.interfaceServices.I_ordenServices;
import com.example.cja_inventario.interfaces.I_orden;
import com.example.cja_inventario.models.Categoria;
import com.example.cja_inventario.models.Orden;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

@Service
public class OrdenServices implements I_ordenServices {

    @Autowired
    private I_orden date;

    @Override
    public List<Orden> listar() {

        return (List<Orden>) date.findAll();

    }

    @Override
    public Optional<Orden> listarId(int id) {

        return date.findById(id);
    }

    @Override
    public int save(Orden ord) {
        int res=0;
        Orden orden=date.save(ord);
        if(!orden.equals(null)){
            res=1;

        }
        return res;
    }

    @Override
    public void delete(int id) {
        date.deleteById(id);

    }
}
