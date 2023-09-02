package com.example.cja_inventario.services;

import com.example.cja_inventario.interfaceServices.I_productoServices;
import com.example.cja_inventario.interfaces.I_Producto;
import com.example.cja_inventario.models.Producto;
import com.example.cja_inventario.repository.productoRepository;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
 public class ProductoServices implements I_productoServices{

    @Autowired
    private I_Producto data;


    @Override
    public List<Producto> listar() {

        return (List<Producto>) data.findAll();
    }

    @Override
    public Optional<Producto> listarId(int id) {

         return data.findById(id);
    }

    @Override
    public int save(Producto prod) {
        int res=0;
        Producto producto=data.save(prod);
        if(!producto.equals(null)){
            res=1;

        }
        return res;
    }

    @Override
    public void delete(int id) {
        data.deleteById(id);
    }

    @Override
    public Boolean ValidarDuplicados(Producto prod) {
        List<Producto> productos = listar();
        for (Producto producto : productos) {
            if (prod.getNombre().equalsIgnoreCase(producto.getNombre()) &&
                    prod.getDisenho().equalsIgnoreCase(producto.getDisenho()) &&
                    prod.getGenero_modelo().equalsIgnoreCase(producto.getGenero_modelo()) &&
                    prod.getTalla_capacidad().equalsIgnoreCase(producto.getTalla_capacidad()) &&
                    prod.getCategoria().getId().equals(producto.getCategoria().getId()) &&
                    prod.getEstado().equalsIgnoreCase(producto.getEstado())) {
                return true;
            }
        }
        return false;
    }
}
