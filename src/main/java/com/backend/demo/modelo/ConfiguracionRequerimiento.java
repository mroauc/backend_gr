package com.backend.demo.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ConfiguracionRequerimiento")
public class ConfiguracionRequerimiento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_config;
	private int id_usuario;
	private String categoria;
	private String prioridad;
	private int id_template;
	
	public ConfiguracionRequerimiento() {
		
	}
	
	public ConfiguracionRequerimiento(int id_config, int id_usuario, String categoria, String prioridad, int id_template) {
		super();
		this.id_config = id_config;
		this.id_usuario = id_usuario;
		this.categoria = categoria;
		this.prioridad = prioridad;
		this.id_template = id_template;
	}

	public int getId_config() {
		return id_config;
	}

	public void setId_config(int id_config) {
		this.id_config = id_config;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}

	public int getId_template() {
		return id_template;
	}

	public void setId_template(int id_template) {
		this.id_template = id_template;
	}	
}