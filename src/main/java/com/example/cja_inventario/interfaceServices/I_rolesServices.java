package com.example.cja_inventario.interfaceServices;

import com.example.cja_inventario.models.Proveedor;
import com.example.cja_inventario.models.Roles;

import javax.management.relation.Role;
import java.util.List;
import java.util.Optional;

public interface I_rolesServices {

    public List<Roles> listar();
    public Optional<Roles> listarId(int id);
    public int save(Roles rol);
    public void delete(int id);
}
