package com.example.cja_inventario.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="proveedor")
public class Proveedor {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    private String apellido;

    private String cedula;
    private String correo;

    private String celular;
    private String direccion;

    @OneToMany(mappedBy = "proveedor")
    private List<Orden> orden;

    public Proveedor() {

    }

    public Proveedor(Integer id, String nombre, String apellido, String cedula, String correo, String celular, String direccion, List<Orden> orden) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.correo = correo;
        this.celular = celular;
        this.direccion = direccion;
        this.orden = orden;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido.toLowerCase();
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula.toLowerCase();
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo.toLowerCase();
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular.toLowerCase();
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion.toLowerCase();
    }

    public List<Orden> getOrden() {
        return orden;
    }

    public void setOrden(List<Orden> orden) {
        this.orden = orden;
    }

    @Override
    public String toString() {
        return "Proveedor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", cedula='" + cedula + '\'' +
                ", correo='" + correo + '\'' +
                ", celular='" + celular + '\'' +
                ", direccion='" + direccion + '\'' +
                ", orden=" + orden +
                '}';
    }
}
