package com.example.cja_inventario.repository;

import com.example.cja_inventario.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface productoRepository  extends JpaRepository<Producto, Long> {

}
