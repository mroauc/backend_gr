package com.backend.demo.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PropuestaCambio {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_propuestaCambio;
	private String nombre;
	private int id_subproyecto;
	private String fecha_peticion;
	private int id_usuario;
	private String descripcion;
	private String justificacion;
	private String alternativas;
	private String consecuencias_rechazo;
	private String fecha_resolucion;
	private String comentarios;
	private String estado;
	
	public PropuestaCambio() {
		
	}

	public PropuestaCambio(int id_propuestaCambio, String nombre, int id_subproyecto, String fecha_peticion, int id_usuario,
			String descripcion, String justificacion, String alternativas, String consecuencias_rechazo,
			String fecha_resolucion, String comentarios, String estado) {
		super();
		this.id_propuestaCambio = id_propuestaCambio;
		this.nombre = nombre;
		this.id_subproyecto = id_subproyecto;
		this.fecha_peticion = fecha_peticion;
		this.id_usuario = id_usuario;
		this.descripcion = descripcion;
		this.justificacion = justificacion;
		this.alternativas = alternativas;
		this.consecuencias_rechazo = consecuencias_rechazo;
		this.fecha_resolucion = fecha_resolucion;
		this.comentarios = comentarios;
		this.estado = estado;
	}

	public int getId_propuestaCambio() {
		return id_propuestaCambio;
	}

	public void setId_propuestaCambio(int id_propuestaCambio) {
		this.id_propuestaCambio = id_propuestaCambio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId_subproyecto() {
		return id_subproyecto;
	}

	public void setId_subproyecto(int id_subproyecto) {
		this.id_subproyecto = id_subproyecto;
	}

	public String getFecha_peticion() {
		return fecha_peticion;
	}

	public void setFecha_peticion(String fecha_peticion) {
		this.fecha_peticion = fecha_peticion;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getJustificacion() {
		return justificacion;
	}

	public void setJustificacion(String justificacion) {
		this.justificacion = justificacion;
	}

	public String getAlternativas() {
		return alternativas;
	}

	public void setAlternativas(String alternativas) {
		this.alternativas = alternativas;
	}

	public String getConsecuencias_rechazo() {
		return consecuencias_rechazo;
	}

	public void setConsecuencias_rechazo(String consecuencias_rechazo) {
		this.consecuencias_rechazo = consecuencias_rechazo;
	}

	public String getFecha_resolucion() {
		return fecha_resolucion;
	}

	public void setFecha_resolucion(String fecha_resolucion) {
		this.fecha_resolucion = fecha_resolucion;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
