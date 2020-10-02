package com.roa.demo.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Glosario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_glosario;
	private String palabra;
	private String significado;
	private int id_proyecto;
	
	public Glosario() {
		
	}

	public Glosario(int id_glosario, String palabra, String significado, int id_proyecto) {
		super();
		this.id_glosario = id_glosario;
		this.palabra = palabra;
		this.significado = significado;
		this.id_proyecto = id_proyecto;
	}

	public int getId_glosario() {
		return id_glosario;
	}

	public void setId_glosario(int id_glosario) {
		this.id_glosario = id_glosario;
	}

	public String getPalabra() {
		return palabra;
	}

	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}

	public String getSignificado() {
		return significado;
	}

	public void setSignificado(String significado) {
		this.significado = significado;
	}

	public int getId_proyecto() {
		return id_proyecto;
	}

	public void setId_proyecto(int id_proyecto) {
		this.id_proyecto = id_proyecto;
	}
	
	
}
