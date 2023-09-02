package com.example.cja_inventario.services;

import com.example.cja_inventario.interfaceServices.I_usuarioServices;
import com.example.cja_inventario.interfaces.I_usuario;
import com.example.cja_inventario.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServices implements I_usuarioServices {

    @Autowired
    private I_usuario date;

    @Override
    public List<Usuario> listar() {
        return (List<Usuario>) date.findAll();
    }

    @Override
    public List<Usuario> listarAdmin(){
        List<Usuario>us=listar();
        List<Usuario> usuarios=new ArrayList<>();
        for (Usuario user:us) {
            if(user.getRoles().getId()==1){
                usuarios.add(user);
            }

        }
        return usuarios;
    }

    @Override
    public Optional<Usuario> listarId(int id) {

        return date.findById(id);
    }

    @Override
    public int save(Usuario user) {
        int res=0;
        Usuario us=date.save(user);
        if(!us.equals(null)){
            res=1;

        }
        return res;
    }

    @Override
    public void delete(int id) {
        date.deleteById(id);

    }



    @Override
    public Usuario buscarUsuarioActivo() {
        List<Usuario>listaUsuarios=listar();
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getEstado()) {
                return usuario;
            }
        }
        return null;
    }
    @Override
    public void CerrarSesionAdmin(){
        List<Usuario>listaUsuarios=listar();
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getEstado() && usuario.getRoles().getId()==1) {
                usuario.setEstado(Boolean.FALSE);
                save(usuario);
            }
        }
    }
    @Override
    public void CerrarSesionCliente(){
        List<Usuario>listaUsuarios=listar();
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getEstado() && usuario.getRoles().getId()==2) {
                usuario.setEstado(Boolean.FALSE);
                save(usuario);
            }
        }
    }
    @Override
    public Usuario ValidarSesionAdmin(){
        List<Usuario>listaUsuarios=listar();
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getEstado() && usuario.getRoles().getId()==1) {
                return usuario;
            }
        }
        return null;
    }

    @Override
    public Usuario ValidarSesionCliente(){
        List<Usuario>listaUsuarios=listar();
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getEstado() && usuario.getRoles().getId()==2) {
                return usuario;
            }
        }
        return null;
    }

    @Override
    public Boolean validarDuplicados(Usuario user){

        List<Usuario>us=listar();
        for (Usuario usuario:us) {
            if(usuario.getNombre().equalsIgnoreCase(user.getNombre()) && (usuario.getApellido().equalsIgnoreCase(user.getApellido()))
            && (usuario.getUserName().equalsIgnoreCase(user.getUserName()))&&(usuario.getEmail().equalsIgnoreCase(user.getEmail()))
             && (usuario.getRoles().getId().equals(user.getRoles().getId()))){
                return true;
            }

        }

        return false;
    }
}
