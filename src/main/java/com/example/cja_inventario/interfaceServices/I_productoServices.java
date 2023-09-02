package com.example.cja_inventario.interfaceServices;

import com.example.cja_inventario.models.Producto;
import net.sf.jasperreports.engine.JRException;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

public interface I_productoServices {
    public List<Producto> listar();
    public Optional<Producto> listarId(int id);
    public int save(Producto prod);
    public void delete(int id);


    public Boolean ValidarDuplicados(Producto producto);


}
