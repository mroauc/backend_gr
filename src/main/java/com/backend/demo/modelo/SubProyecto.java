package com.backend.demo.modelo;

import java.util.Date;

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
	private Date fecha_inicio;
	private Date fecha_fin;
	private String tipo_subProyecto;
	private int id_usuario;
	
	public SubProyecto() {
		
	}

	public SubProyecto(int id_subProyecto, String nombre_subProyecto, Date fecha_inicio, Date fecha_fin,
			String tipo_subProyecto, int id_usuario) {
		super();
		this.id_subProyecto = id_subProyecto;
		this.nombre_subProyecto = nombre_subProyecto;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
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

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
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
