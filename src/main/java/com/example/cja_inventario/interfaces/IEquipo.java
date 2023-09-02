package com.example.cja_inventario.interfaces;

import com.example.cja_inventario.models.Equipo;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface IEquipo extends CrudRepository<Equipo,Integer> {
    Optional<Equipo> findById(int id);

    void deleteById(int id);
}
