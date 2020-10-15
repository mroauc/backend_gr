package com.backend.demo.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Template {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_template;
	private String prefijo;
	private String nombre;
	private String tipo;
	private String template;
	//private Date fecha;
	private String fecha;
	
	public Template() {
		
	}

	public Template(int id_template, String prefijo, String nombre, String tipo, String template, String fecha) {
		super();
		this.id_template = id_template;
		this.prefijo = prefijo;
		this.nombre = nombre;
		this.tipo = tipo;
		this.template = template;
		this.fecha = fecha;
	}

	public int getId_template() {
		return id_template;
	}

	public void setId_template(int id_template) {
		this.id_template = id_template;
	}

	public String getPrefijo() {
		return prefijo;
	}

	public void setPrefijo(String prefijo) {
		this.prefijo = prefijo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
}
