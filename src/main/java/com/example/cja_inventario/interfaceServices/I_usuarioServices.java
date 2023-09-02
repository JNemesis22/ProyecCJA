package com.example.cja_inventario.interfaceServices;

import com.example.cja_inventario.models.Proveedor;
import com.example.cja_inventario.models.Usuario;

import java.util.List;
import java.util.Optional;

public interface I_usuarioServices {
    public List<Usuario> listar();

    List<Usuario> listarAdmin();

    public Optional<Usuario> listarId(int id);
    public int save(Usuario user);
    public void delete(int id);

    public Usuario buscarUsuarioActivo();

    void CerrarSesionAdmin();

    void CerrarSesionCliente();

    Usuario ValidarSesionAdmin();

    Usuario ValidarSesionCliente();

    Boolean validarDuplicados(Usuario user);
}
