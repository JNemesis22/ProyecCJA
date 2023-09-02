package com.example.cja_inventario.interfaces;

import com.example.cja_inventario.models.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface I_usuario extends CrudRepository<Usuario, Integer > {
}
