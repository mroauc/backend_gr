package com.backend.demo.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ImpactoDirecto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_impacto_directo;
	private int id_propuesta_cambio;
	private int id_relacion_requerimiento;
	
	public ImpactoDirecto() {
		
	}

	public ImpactoDirecto(int id_impacto_directo, int id_propuesta_cambio, int id_relacion_requerimiento) {
		super();
		this.id_impacto_directo = id_impacto_directo;
		this.id_propuesta_cambio = id_propuesta_cambio;
		this.id_relacion_requerimiento = id_relacion_requerimiento;
	}

	public int getId_impacto_directo() {
		return id_impacto_directo;
	}

	public void setId_impacto_directo(int id_impacto_directo) {
		this.id_impacto_directo = id_impacto_directo;
	}

	public int getId_propuesta_cambio() {
		return id_propuesta_cambio;
	}

	public void setId_propuesta_cambio(int id_propuesta_cambio) {
		this.id_propuesta_cambio = id_propuesta_cambio;
	}

	public int getId_relacion_requerimiento() {
		return id_relacion_requerimiento;
	}

	public void setId_relacion_requerimiento(int id_relacion_requerimiento) {
		this.id_relacion_requerimiento = id_relacion_requerimiento;
	}
	
	
}
