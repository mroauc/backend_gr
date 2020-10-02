package com.backend.demo.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EncargadoSubProyecto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_encargadoSubProyecto;
	private int id_subProyecto;
	private int id_usuario;
	
	public EncargadoSubProyecto() {
		
	}

	public EncargadoSubProyecto(int id_encargadoSubProyecto, int id_subProyecto, int id_usuario) {
		super();
		this.id_encargadoSubProyecto = id_encargadoSubProyecto;
		this.id_subProyecto = id_subProyecto;
		this.id_usuario = id_usuario;
	}

	public int getId_encargadoSubProyecto() {
		return id_encargadoSubProyecto;
	}

	public void setId_encargadoSubProyecto(int id_encargadoSubProyecto) {
		this.id_encargadoSubProyecto = id_encargadoSubProyecto;
	}

	public int getId_subProyecto() {
		return id_subProyecto;
	}

	public void setId_subProyecto(int id_subProyecto) {
		this.id_subProyecto = id_subProyecto;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	
}
