package com.example.cja_inventario.interfaceServices;


import com.example.cja_inventario.models.Equipo;
import com.example.cja_inventario.interfaceServices.IEquipoService;
import java.util.List;
import java.util.Optional;

public interface IEquipoService {
    public List<Equipo>Listar();
    public Optional<Equipo>ListarID(int id);
    public int save(Equipo e);
    public void delete(int id);

}
