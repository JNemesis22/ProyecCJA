package com.example.cja_inventario.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "agendamiento")
public class Agendamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String confirmarDomi;
    private LocalDate fechaServicio;
    private LocalTime horaServicio;

    @OneToOne
    private Diagnostico diagnostico;

    public Agendamiento() {
    }

    public Agendamiento(String confirmarDomi, LocalDate fechaServicio, LocalTime horaServicio) {
        this.confirmarDomi = confirmarDomi;
        this.fechaServicio = fechaServicio;
        this.horaServicio = horaServicio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConfirmarDomi() {
        return confirmarDomi;
    }

    public void setConfirmarDomi(String confirmarDomi) {
        this.confirmarDomi = confirmarDomi;
    }

    public LocalDate getFechaServicio() {
        return fechaServicio;
    }

    public void setFechaServicio(LocalDate fechaServicio) {
        this.fechaServicio = fechaServicio;
    }

    public LocalTime getHoraServicio() {
        return horaServicio;
    }

    public void setHoraServicio(LocalTime horaServicio) {
        this.horaServicio = horaServicio;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }
}
