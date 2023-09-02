package com.example.cja_inventario.interfaceServices;

import com.example.cja_inventario.models.DetalleOrden;
import com.example.cja_inventario.models.Orden;

import java.util.List;
import java.util.Optional;

public interface I_detalleServices {

    public List<DetalleOrden> listar();

    List<DetalleOrden> listarIdOrden(int id);

    public Optional<DetalleOrden> listarId(int id);
    public int save(DetalleOrden dt);
    public void delete(int id);
}
