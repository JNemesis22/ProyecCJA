package com.example.cja_inventario.interfaces;

import com.example.cja_inventario.models.Agendamiento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface IAgendamiento extends CrudRepository<Agendamiento,Integer> {
}
