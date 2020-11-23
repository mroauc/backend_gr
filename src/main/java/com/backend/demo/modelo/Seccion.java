package com.backend.demo.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Seccion {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_seccion;
	private String nombre_seccion;
	@Column(length = 2000)
	private String contenido_seccion;
	private int id_proyecto;
	
	public Seccion(){
	}

	public Seccion(int id_seccion, String nombre_seccion, String contenido_seccion, int id_proyecto) {
		super();
		this.id_seccion = id_seccion;
		this.nombre_seccion = nombre_seccion;
		this.contenido_seccion = contenido_seccion;
		this.id_proyecto = id_proyecto;
	}

	public int getId_seccion() {
		return id_seccion;
	}

	public void setId_seccion(int id_seccion) {
		this.id_seccion = id_seccion;
	}

	public String getNombre_seccion() {
		return nombre_seccion;
	}

	public void setNombre_seccion(String nombre_seccion) {
		this.nombre_seccion = nombre_seccion;
	}

	public String getContenido_seccion() {
		return contenido_seccion;
	}

	public void setContenido_seccion(String contenido_seccion) {
		this.contenido_seccion = contenido_seccion;
	}

	public int getId_proyecto() {
		return id_proyecto;
	}

	public void setId_proyecto(int id_proyecto) {
		this.id_proyecto = id_proyecto;
	}
	
	
	
	
}
