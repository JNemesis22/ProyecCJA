package com.example.cja_inventario.interfaceServices;

import com.example.cja_inventario.models.Producto;
import com.example.cja_inventario.models.Proveedor;

import java.util.List;
import java.util.Optional;

public interface I_proveedorServices {
    public List<Proveedor> listar();
    public Optional<Proveedor> listarId(int id);
    public int save(Proveedor prov);
    public void delete(int id);

    Boolean ValidarDuplicados(Proveedor prov);
}
