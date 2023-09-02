package com.example.cja_inventario.interfaceServices;

import com.example.cja_inventario.models.Categoria;

import java.util.List;
import java.util.Optional;

public interface I_categoriaServices{
    public List<Categoria> listar();
    public Optional<Categoria>listarId(int id);
    public int save(Categoria cat);
    public void delete(int id);

    Boolean validarDuplicados(Categoria cat);
}
