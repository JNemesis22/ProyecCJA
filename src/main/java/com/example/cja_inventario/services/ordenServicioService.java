package com.example.cja_inventario.services;

import com.example.cja_inventario.interfaceServices.IOrdenServicioService;
import com.example.cja_inventario.interfaces.IOrdenServicio;
import com.example.cja_inventario.models.OrdenServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ordenServicioService implements IOrdenServicioService {
    @Autowired
    private IOrdenServicio data;
    @Override
    public List<OrdenServicio> Listar() {
        return (List<OrdenServicio>) data.findAll();
    }

    @Override
    public Optional<OrdenServicio> ListarID(int id) {
        return data.findById(id);

    }

    @Override
    public int save(OrdenServicio o) {
        int res=0;
        OrdenServicio OrdenServicio=data.save(o);
        if(!OrdenServicio.equals(null)){
            res=1;
        }
        return 0;
    }


    @Override
    public void delete(int id) {
    data.deleteById(id);
    }
}
