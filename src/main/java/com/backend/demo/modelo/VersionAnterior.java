package com.backend.demo.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class VersionAnterior {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_version_anterior;
	private int id_requerimiento;
	private String nombre_descriptivo;
	@Column(length = 2000)
	private String descripcion;
	private String prioridad;
	private String estado;
	private int id_usuario;
	private String fecha;
	private String cambios_realizados;
	
	public VersionAnterior() {
		
	}

	public VersionAnterior(int id_version_anterior, int id_requerimiento, String descripcion, String nombre_descriptivo, String prioridad,
			String estado, int id_usuario, String fecha, String cambios_realizados) {
		super();
		this.id_version_anterior = id_version_anterior;
		this.id_requerimiento = id_requerimiento;
		this.descripcion = descripcion;
		this.nombre_descriptivo = nombre_descriptivo;
		this.prioridad = prioridad;
		this.estado = estado;
		this.id_usuario = id_usuario;
		this.fecha = fecha;
		this.cambios_realizados = cambios_realizados;
	}

	public int getId_version_anterior() {
		return id_version_anterior;
	}

	public void setId_version_anterior(int id_version_anterior) {
		this.id_version_anterior = id_version_anterior;
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

	public String getNombre_descriptivo() {
		return nombre_descriptivo;
	}

	public void setNombre_descriptivo(String nombre_descriptivo) {
		this.nombre_descriptivo = nombre_descriptivo;
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
	
	public String getCambios_realizados() {
		return cambios_realizados;
	}
	
	public void setCambios_realizados(String cambios_realizados) {
		this.cambios_realizados = cambios_realizados;
	}
}