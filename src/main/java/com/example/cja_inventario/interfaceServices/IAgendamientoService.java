package com.example.cja_inventario.interfaceServices;


import com.example.cja_inventario.models.Agendamiento;

import java.util.List;
import java.util.Optional;

public interface IAgendamientoService {
    public List<Agendamiento>listar();
    public Optional<Agendamiento>ListarID(int id);
    public int save(Agendamiento a);
    public void delete(int id);
}
