package com.example.cja_inventario.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "equipo")
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String marca;
    private String modelo;
    private String color;
    @ManyToOne
    private Usuario usuario;

    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL)
    private List<OrdenServicio> ordenServicio;
    @OneToMany(mappedBy = "equipo")
    private List<Diagnostico> diagnosticos;


    public Equipo() {
    }

    public Equipo(int id, String nombre, String marca, String modelo, String color) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<OrdenServicio> getOrdenServicio() {
        return ordenServicio;
    }

    public void setOrdenServicio(List<OrdenServicio> ordenServicio) {
        this.ordenServicio = ordenServicio;
    }

    public List<Diagnostico> getDiagnosticos() {
        return diagnosticos;
    }

    public void setDiagnosticos(List<Diagnostico> diagnosticos) {
        this.diagnosticos = diagnosticos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", color='" + color + '\'' +
                ", usuario=" + usuario +
                ", ordenServicio=" + ordenServicio +
                ", diagnosticos=" + diagnosticos +
                '}';
    }
}