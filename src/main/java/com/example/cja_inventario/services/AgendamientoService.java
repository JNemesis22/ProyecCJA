package com.example.cja_inventario.services;

import com.example.cja_inventario.interfaceServices.IAgendamientoService;
import com.example.cja_inventario.interfaces.IAgendamiento;
import com.example.cja_inventario.models.Agendamiento;
import com.example.cja_inventario.services.AgendamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AgendamientoService implements IAgendamientoService {
    @Autowired
    private IAgendamiento data;
    @Override
    public List<Agendamiento> listar() {
        return (List<Agendamiento>)data.findAll();
    }

    @Override
    public Optional<Agendamiento> ListarID(int id) {
        return Optional.empty();
    }

    @Override
    public int save(Agendamiento a) {
        int res=0;
        Agendamiento agendamiento=data.save(a);
        if (!agendamiento.equals(null)){
            res=1;
        }
        return res;
    }

    @Override
    public void delete(int id) {

    }
}
