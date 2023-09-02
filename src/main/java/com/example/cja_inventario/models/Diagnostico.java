package com.example.cja_inventario.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "diagnostico")
public class Diagnostico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fechaDiagnostico;
    private String procedimiento;
    private String diagnosticoEquipo;
    private int precio;
    @ManyToOne
    private Equipo equipo;
    @OneToOne
    private Agendamiento agendamiento;

    public Diagnostico() {
        this.fechaDiagnostico = LocalDateTime.now(); // Establecer la fecha actual en el constructor
    }

    public Diagnostico(int id, LocalDateTime fechaDiagnostico, String procedimiento, String diagnosticoEquipo, int precio) {
        this.id = id;
        this.fechaDiagnostico = fechaDiagnostico;
        this.procedimiento = procedimiento;
        this.diagnosticoEquipo = diagnosticoEquipo;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getFechaDiagnostico() {
        return fechaDiagnostico;
    }

    public void setFechaDiagnostico(LocalDateTime fechaDiagnostico) {
        this.fechaDiagnostico = fechaDiagnostico;
    }

    public String getProcedimiento() {
        return procedimiento;
    }

    public void setProcedimiento(String procedimiento) {
        this.procedimiento = procedimiento;
    }

    public String getDiagnosticoEquipo() {
        return diagnosticoEquipo;
    }

    public void setDiagnosticoEquipo(String diagnosticoEquipo) {
        this.diagnosticoEquipo = diagnosticoEquipo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Agendamiento getAgendamiento() {
        return agendamiento;
    }

    public void setAgendamiento(Agendamiento agendamiento) {
        this.agendamiento = agendamiento;
    }

}
