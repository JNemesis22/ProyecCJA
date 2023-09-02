package com.example.cja_inventario.services;

import com.example.cja_inventario.interfaceServices.IDiagnosticoService;
import com.example.cja_inventario.interfaces.IDiagnostico;
import com.example.cja_inventario.models.Diagnostico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DiagnosticoService implements IDiagnosticoService {
    @Autowired
    private IDiagnostico data;
    @Override
    public List<Diagnostico> listar() {
        return (List<Diagnostico>) data.findAll();
    }

    @Override
    public Optional<Diagnostico> listarID(int id) {

        return data.findById(id);
    }

    @Override
    public int save(Diagnostico d) {
        int res=0;
        Diagnostico diagnostico=data.save(d);
        if (!diagnostico.equals(null)){
            res=1;
        }
        return 0;
    }

    @Override
    public void delete(int id) {
        data.deleteById(id);
    }

    @Override
    public Optional<Diagnostico> ListarID(int id) {
        return Optional.empty();
    }
}
