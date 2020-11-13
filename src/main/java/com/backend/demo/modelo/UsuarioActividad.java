package com.backend.demo.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UsuarioActividad {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_usuarioActividad;
	private int id_requerimiento;
	private int id_usuario;
	private String fecha;
	
	public UsuarioActividad() {
		
	}

	public UsuarioActividad(int id_usuarioActividad, int id_requerimiento, int id_usuario, String fecha) {
		super();
		this.id_usuarioActividad = id_usuarioActividad;
		this.id_requerimiento = id_requerimiento;
		this.id_usuario = id_usuario;
		this.fecha = fecha;
	}

	public int getId_usuarioActividad() {
		return id_usuarioActividad;
	}

	public void setId_usuarioActividad(int id_usuarioActividad) {
		this.id_usuarioActividad = id_usuarioActividad;
	}

	public int getId_requerimiento() {
		return id_requerimiento;
	}

	public void setId_requerimiento(int id_requerimiento) {
		this.id_requerimiento = id_requerimiento;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
}
