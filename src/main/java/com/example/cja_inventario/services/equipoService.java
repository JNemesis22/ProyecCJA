package com.example.cja_inventario.services;

import com.example.cja_inventario.interfaceServices.IEquipoService;
import com.example.cja_inventario.interfaces.IEquipo;
import com.example.cja_inventario.models.Equipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class equipoService implements IEquipoService {
    @Autowired
    private IEquipo data;
    @Override
    public List<Equipo> Listar() {
        return  (List<Equipo>)data.findAll();
    }

    @Override
    public Optional<Equipo> ListarID(int id) {

        return data.findById(id);
    }

    @Override
    public int save(Equipo e) {
        int res=0;
        Equipo equipo=data.save(e);
        if (!equipo.equals(null)){
            res=1;
        }
        return 0;
    }

    @Override
    public void delete(int id) {
        data.deleteById(id);
    }
}
