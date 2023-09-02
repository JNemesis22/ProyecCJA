package com.example.cja_inventario.interfaces;

import com.example.cja_inventario.models.Diagnostico;
import org.springframework.data.repository.CrudRepository;

public interface IDiagnostico extends CrudRepository<Diagnostico, Integer> {
}
