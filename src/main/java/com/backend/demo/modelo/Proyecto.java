package com.backend.demo.modelo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Proyecto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_proyecto;
	private String nombre;
	private String fecha_inicio;
	private String fecha_fin;
	private int id_usuario;
	private String fecha_creacion;

	
	public Proyecto() {
		
	}

	public Proyecto(int id_proyecto, String nombre, String fecha_inicio, String fecha_fin, int id_usuario,
			String fecha_creacion) {
		super();
		this.id_proyecto = id_proyecto;
		this.nombre = nombre;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.id_usuario = id_usuario;
		this.fecha_creacion = fecha_creacion;
	}

	public int getId_proyecto() {
		return id_proyecto;
	}

	public void setId_proyecto(int id_proyecto) {
		this.id_proyecto = id_proyecto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(String fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public String getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(String fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}


	public String getCreated_at() {
		return fecha_creacion;
	}

	public void setCreated_at(String fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public String getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(String fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
}
