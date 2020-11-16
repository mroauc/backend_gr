package com.backend.demo.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Error")
public class Errores {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_error;
	@Column(length = 1000)
	private String contenido;
	private int id_usuario;
	private String fecha;
	
	public Errores() {
		
	}

	public Errores(int id_error, String contenido, int id_usuario, String fecha) {
		super();
		this.id_error = id_error;
		this.contenido = contenido;
		this.id_usuario = id_usuario;
		this.fecha = fecha;
	}

	public int getId_error() {
		return id_error;
	}

	public void setId_error(int id_error) {
		this.id_error = id_error;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
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
		this.fecha=fecha;
	}
}
