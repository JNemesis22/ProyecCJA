package com.example.cja_inventario.models;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="roles")
public class Roles {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    @OneToMany(mappedBy = "roles")
    private List<Usuario> usuario;

    public Roles() {
    }

    public Roles(Integer id, String nombre, List<Usuario> usuario) {
        this.id = id;
        this.nombre = nombre;
        this.usuario = usuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre.toLowerCase();
    }

    public List<Usuario> getUsuario() {
        return usuario;
    }

    public void setUsuario(List<Usuario> usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Roles{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", usuario=" + usuario +
                '}';
    }
}
