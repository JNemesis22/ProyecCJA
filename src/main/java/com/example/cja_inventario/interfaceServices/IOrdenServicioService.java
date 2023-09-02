package com.example.cja_inventario.interfaceServices;


import com.example.cja_inventario.models.OrdenServicio;

import java.util.List;
import java.util.Optional;

public interface IOrdenServicioService {
    public List<OrdenServicio>Listar();
    public Optional<OrdenServicio>ListarID(int id);
    public int save (OrdenServicio o);
    public void delete(int id);

}
