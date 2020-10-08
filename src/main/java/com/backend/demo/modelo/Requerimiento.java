package com.backend.demo.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Requerimiento {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_requerimiento;
	private String descripcion;
	private int id_usuario;
	private int id_subProyecto;
	private Date created_at;
	private String prioridad;
	private String estado;
	private String categoria;
	private int id_template;
	
	public Requerimiento() {
		
	}

	public Requerimiento(int id_requerimiento, String descripcion, int id_usuario, int id_subProyecto, Date created_at,
			String prioridad, String estado, String categoria, int id_template) {
		super();
		this.id_requerimiento = id_requerimiento;
		this.descripcion = descripcion;
		this.id_usuario = id_usuario;
		this.id_subProyecto = id_subProyecto;
		this.created_at = created_at;
		this.prioridad = prioridad;
		this.estado = estado;
		this.categoria = categoria;
		this.id_template = id_template;
	}

	public int getId_requerimiento() {
		return id_requerimiento;
	}

	public void setId_requerimiento(int id_requerimiento) {
		this.id_requerimiento = id_requerimiento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public int getId_subProyecto() {
		return id_subProyecto;
	}

	public void setId_subProyecto(int id_subProyecto) {
		this.id_subProyecto = id_subProyecto;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public String getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getId_template() {
		return id_template;
	}

	public void setId_template(int id_template) {
		this.id_template = id_template;
	}
}
