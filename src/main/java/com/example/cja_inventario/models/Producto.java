package com.example.cja_inventario.models;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

	@Entity
	@Table(name="productos")

	public class Producto {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		private String nombre;

		private String imagen;
		private String estado;

		private String novedades;
		private String disenho;

		private String talla_capacidad;
		private String genero_modelo;

		private String garantia;
		private double precio;
		private int cantidad;

		@ManyToOne
		private Categoria categoria;

		@OneToMany(mappedBy = "productos")
		private List<DetalleOrden> detalle;

		public Producto() {
		}

		public Producto(Integer id, String nombre, String imagen, String estado, String novedades, String disenho, String talla_capacidad, String genero_modelo, String garantia, double precio, int cantidad, Categoria categoria, List<DetalleOrden> detalle) {
			this.id = id;
			this.nombre = nombre;
			this.imagen = imagen;
			this.estado = estado;
			this.novedades = novedades;
			this.disenho = disenho;
			this.talla_capacidad = talla_capacidad;
			this.genero_modelo = genero_modelo;
			this.garantia = garantia;
			this.precio = precio;
			this.cantidad = cantidad;
			this.categoria = categoria;
			this.detalle = detalle;
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

		public String getImagen() {
			return imagen;
		}

		public void setImagen(String imagen) {
			this.imagen = imagen;
		}

		public String getEstado() {
			return estado;
		}

		public void setEstado(String estado) {
			this.estado = estado.toLowerCase();
		}

		public String getNovedades() {
			return novedades;
		}

		public void setNovedades(String novedades) {
			this.novedades = novedades.toLowerCase();
		}

		public String getDisenho() {
			return disenho;
		}

		public void setDisenho(String disenho) {
			this.disenho = disenho.toLowerCase();
		}

		public String getTalla_capacidad() {
			return talla_capacidad;
		}

		public void setTalla_capacidad(String talla_capacidad) {
			this.talla_capacidad = talla_capacidad.toLowerCase();
		}

		public String getGenero_modelo() {
			return genero_modelo;
		}

		public void setGenero_modelo(String genero_modelo) {
			this.genero_modelo = genero_modelo.toLowerCase();
		}

		public String getGarantia() {
			return garantia;
		}

		public void setGarantia(String garantia) {
			this.garantia = garantia;
		}

		public double getPrecio() {
			return precio;
		}

		public void setPrecio(double precio) {
			this.precio = precio;
		}

		public int getCantidad() {
			return cantidad;
		}

		public void setCantidad(int cantidad) {
			this.cantidad = cantidad;
		}

		public Categoria getCategoria() {
			return categoria;
		}

		public void setCategoria(Categoria categoria) {
			this.categoria = categoria;
		}

		public List<DetalleOrden> getDetalle() {
			return detalle;
		}

		public void setDetalle(List<DetalleOrden> detalle) {
			this.detalle = detalle;
		}

		@Override
		public String toString() {
			return "Producto{" +
					"id=" + id +
					", nombre='" + nombre + '\'' +
					", imagen='" + imagen + '\'' +
					", estado='" + estado + '\'' +
					", novedades='" + novedades + '\'' +
					", disenho='" + disenho + '\'' +
					", talla_capacidad='" + talla_capacidad + '\'' +
					", genero_modelo='" + genero_modelo + '\'' +
					", garantia='" + garantia + '\'' +
					", precio=" + precio +
					", cantidad=" + cantidad +
					", categoria=" + categoria +
					", detalle=" + detalle +
					'}';
		}
	}
