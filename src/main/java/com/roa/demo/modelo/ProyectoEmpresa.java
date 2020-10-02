package com.roa.demo.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProyectoEmpresa {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_proyecto_empresa;
	private int id_proyecto;
	private int id_empresa;
	
	public ProyectoEmpresa() {
		
	}

	public ProyectoEmpresa(int id_proyecto_empresa, int id_proyecto, int id_empresa) {
		super();
		this.id_proyecto_empresa = id_proyecto_empresa;
		this.id_proyecto = id_proyecto;
		this.id_empresa = id_empresa;
	}

	public int getId_proyecto_empresa() {
		return id_proyecto_empresa;
	}

	public void setId_proyecto_empresa(int id_proyecto_empresa) {
		this.id_proyecto_empresa = id_proyecto_empresa;
	}

	public int getId_proyecto() {
		return id_proyecto;
	}

	public void setId_proyecto(int id_proyecto) {
		this.id_proyecto = id_proyecto;
	}

	public int getId_empresa() {
		return id_empresa;
	}

	public void setId_empresa(int id_empresa) {
		this.id_empresa = id_empresa;
	}
	
	
}
