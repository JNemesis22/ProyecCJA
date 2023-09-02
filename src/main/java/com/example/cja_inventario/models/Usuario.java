package com.example.cja_inventario.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="usuario")
public class  Usuario {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nombre;

	private String apellido;
	
	private String userName;
	
	private String email;
	
	private String direccion;
	
	private String telefono;

	private String password;

	private String passwordConfirm;

	private Boolean estado;

	@ManyToOne
	private Roles roles;

	@OneToMany(mappedBy = "usuario")
	private List<Equipo> equipo;

	
	/*@OneToMany(mappedBy = "usuario")
	private List<Orden> orden;
*/
	public Usuario() {
		
	}

	public Usuario(Integer id, String nombre, String apellido, String userName, String email, String direccion, String telefono, String password, String passwordConfirm, Boolean estado, Roles roles) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.userName = userName;
		this.email = email;
		this.direccion = direccion;
		this.telefono = telefono;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
		this.estado = estado;
		this.roles = roles;
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
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Roles getRoles() {
		return roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	public List<Equipo> getEquipo() {
		return equipo;
	}

	public void setEquipo(List<Equipo> equipo) {
		this.equipo = equipo;
	}

	@Override
	public String toString() {
		return "Usuario{" +
				"id=" + id +
				", nombre='" + nombre + '\'' +
				", apellido='" + apellido + '\'' +
				", userName='" + userName + '\'' +
				", email='" + email + '\'' +
				", direccion='" + direccion + '\'' +
				", telefono='" + telefono + '\'' +
				", password='" + password + '\'' +
				", passwordConfirm='" + passwordConfirm + '\'' +
				", estado=" + estado +
				", roles=" + roles +
				", equipo=" + equipo +
				'}';
	}
}
