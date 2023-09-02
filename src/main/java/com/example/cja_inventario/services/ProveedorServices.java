package com.example.cja_inventario.services;

import com.example.cja_inventario.interfaceServices.I_proveedorServices;
import com.example.cja_inventario.interfaces.I_proveedores;
import com.example.cja_inventario.models.Proveedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorServices implements I_proveedorServices {
    @Autowired
    private I_proveedores date;
    @Override
    public List<Proveedor> listar() {
        return (List<Proveedor>) date.findAll();
    }

    @Override
    public Optional<Proveedor> listarId(int id) {
        return date.findById(id);
    }

    @Override
    public int save(Proveedor prov) {
        int res = 0;
        Proveedor proveedor = date.save(prov);
        if (!proveedor.equals(null)) {
            res = 1;

        }
        return res;
    }
    @Override
    public void delete(int id) {
        date.deleteById(id);

    }
    @Override
    public Boolean ValidarDuplicados(Proveedor prov) {
        List<Proveedor> proveedor = listar();
        for (Proveedor provee : proveedor) {
            if(prov.getNombre().equalsIgnoreCase(provee.getNombre()) && prov.getApellido().equalsIgnoreCase(provee.getApellido())&&
                    prov.getCedula().equalsIgnoreCase(provee.getCedula())){


                return true;
            }
        }
        return false;
    }
}
