package com.example.cja_inventario.models;

import jakarta.persistence.*;

@Entity
@Table(name = "ordenServicio")
public class OrdenServicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tipoServicio;
    private String descripcion;

    @ManyToOne
    private Equipo equipo;

    public OrdenServicio() {
    }

    public OrdenServicio(int id, String tipoServicio, String descripcion) {
        this.id = id;
        this.tipoServicio = tipoServicio;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
}

