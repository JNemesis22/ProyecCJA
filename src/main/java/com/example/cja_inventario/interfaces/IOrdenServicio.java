package com.example.cja_inventario.interfaces;

import com.example.cja_inventario.models.OrdenServicio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IOrdenServicio extends CrudRepository<OrdenServicio,Integer> {

    Optional<OrdenServicio> findById(int id);
}
