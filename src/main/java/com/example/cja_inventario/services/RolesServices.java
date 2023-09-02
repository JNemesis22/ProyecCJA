package com.example.cja_inventario.services;

import com.example.cja_inventario.interfaceServices.I_rolesServices;
import com.example.cja_inventario.interfaces.I_orden;
import com.example.cja_inventario.interfaces.I_roles;
import com.example.cja_inventario.models.Orden;
import com.example.cja_inventario.models.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.List;
import java.util.Optional;

@Service
public class RolesServices implements I_rolesServices {
    @Autowired
    private I_roles date;

    @Override
    public List<Roles> listar() {

        return (List<Roles>) date.findAll();

    }

    @Override
    public Optional<Roles> listarId(int id) {

        return date.findById(id);
    }

    @Override
    public int save(Roles rol) {
        int res=0;
        Roles role=date.save(rol);
        if(!role.equals(null)){
            res=1;

        }
        return res;
    }

    @Override
    public void delete(int id) {
        date.deleteById(id);

    }
}
