package com.backend.demo.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_usuario;
	private String nombre;
	private String rol;
	private String estado;
	private String password;
	private String email;
	
	public Usuario() {
		
	}

	public Usuario(int id_usuario, String nombre, String rol, String estado, String password, String email) {
		super();
		this.id_usuario = id_usuario;
		this.nombre = nombre;
		this.rol = rol;
		this.estado = estado;
		this.password = password;
		this.email = email;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email=email;
	}
}
