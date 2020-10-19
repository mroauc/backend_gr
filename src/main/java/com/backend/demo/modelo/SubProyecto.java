package com.backend.demo.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class SubProyecto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_subProyecto;
	private String nombre_subProyecto;
	private String fecha_inicio;
	private String fecha_fin;
	private int id_proyecto;
	private String tipo_subProyecto;
	private int id_usuario;
	
	public SubProyecto() {
		
	}

	public SubProyecto(int id_subProyecto, String nombre_subProyecto, String fecha_inicio, String fecha_fin,
			int id_proyecto, String tipo_subProyecto, int id_usuario) {
		super();
		this.id_subProyecto = id_subProyecto;
		this.nombre_subProyecto = nombre_subProyecto;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.id_proyecto = id_proyecto;
		this.tipo_subProyecto = tipo_subProyecto;
		this.id_usuario = id_usuario;
	}

	public int getId_subProyecto() {
		return id_subProyecto;
	}

	public void setId_subProyecto(int id_subProyecto) {
		this.id_subProyecto = id_subProyecto;
	}

	public String getNombre_subProyecto() {
		return nombre_subProyecto;
	}

	public void setNombre_subProyecto(String nombre_subProyecto) {
		this.nombre_subProyecto = nombre_subProyecto;
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

	public int getId_proyecto() {
		return id_proyecto;
	}

	public void setId_proyecto(int id_proyecto) {
		this.id_proyecto = id_proyecto;
	}

	public String getTipo_subProyecto() {
		return tipo_subProyecto;
	}

	public void setTipo_subProyecto(String tipo_subProyecto) {
		this.tipo_subProyecto = tipo_subProyecto;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	
	
	
}
