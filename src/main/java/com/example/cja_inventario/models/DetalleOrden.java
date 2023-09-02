package com.example.cja_inventario.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="detalle")
public class DetalleOrden {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer cantidad;
	@ManyToOne
	private Orden orden;
	@ManyToOne
	private Producto productos;

	public DetalleOrden() {

	}

	public DetalleOrden(Integer id, Integer cantidad, Orden orden, Producto productos) {
		this.id = id;
		this.cantidad = cantidad;
		this.orden = orden;
		this.productos = productos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Orden getOrden() {
		return orden;
	}

	public void setOrden(Orden orden) {
		this.orden = orden;
	}

	public Producto getProductos() {
		return productos;
	}

	public void setProductos(Producto productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "DetalleOrden{" +
				"id=" + id +
				", cantidad=" + cantidad +
				", orden=" + orden +
				", productos=" + productos +
				'}';
	}
}

