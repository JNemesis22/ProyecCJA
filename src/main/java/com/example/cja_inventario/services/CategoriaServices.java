package com.example.cja_inventario.services;

import com.example.cja_inventario.interfaceServices.I_categoriaServices;
import com.example.cja_inventario.interfaces.I_categoria;
import com.example.cja_inventario.models.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServices implements I_categoriaServices {

    @Autowired
    private I_categoria date;
    @Override
    public List<Categoria> listar() {
        return (List<Categoria>) date.findAll();
    }

    @Override
    public Optional<Categoria> listarId(int id) {

        return date.findById(id);
    }

    @Override
    public int save(Categoria cat) {
        int res=0;
        Categoria categoria=date.save(cat);
        if(!categoria.equals(null)){
            res=1;

        }
        return res;
    }

    @Override
    public void delete(int id) {
        date.deleteById(id);

    }

    @Override
    public Boolean validarDuplicados(Categoria cat){

        List<Categoria> cate = listar();
        for (Categoria categoria : cate) {

            if (categoria.getNombre().equalsIgnoreCase(cat.getNombre())) {
                return true;
            }
        }
        return false;

    }
}
