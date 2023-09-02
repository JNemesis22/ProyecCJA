package com.example.cja_inventario.interfaces;

import com.example.cja_inventario.models.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface I_Producto extends CrudRepository<Producto,Integer> {
}
