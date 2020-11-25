package com.backend.demo.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Glosario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_glosario;
	private int id_proyecto;
	
	public Glosario() {
		
	}

	public Glosario(int id_glosario, int id_proyecto) {
		super();
		this.id_glosario = id_glosario;
		this.id_proyecto = id_proyecto;
	}

	public int getId_glosario() {
		return id_glosario;
	}

	public void setId_glosario(int id_glosario) {
		this.id_glosario = id_glosario;
	}

	public int getId_proyecto() {
		return id_proyecto;
	}

	public void setId_proyecto(int id_proyecto) {
		this.id_proyecto = id_proyecto;
	}

	
	
	
}
