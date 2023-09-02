package com.example.cja_inventario.interfaces;

import com.example.cja_inventario.models.Producto;
import com.example.cja_inventario.models.Proveedor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface I_proveedores  extends CrudRepository<Proveedor,Integer> {
}
