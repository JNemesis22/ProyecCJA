package com.example.cja_inventario.interfaces;

import com.example.cja_inventario.models.Roles;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface I_roles extends CrudRepository<Roles,Integer> {
}
