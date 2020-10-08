package com.backend.demo.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Palabra {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id_palabra;
	private String palabra;
	private String significado;
	private int id_glosario;
	
	public Palabra() {
		
	}

	public Palabra(int id_palabra, String palabra, String significado, int id_glosario) {
		super();
		this.id_palabra = id_palabra;
		this.palabra = palabra;
		this.significado = significado;
		this.id_glosario = id_glosario;
	}

	public int getId_palabra() {
		return id_palabra;
	}

	public void setId_palabra(int id_palabra) {
		this.id_palabra = id_palabra;
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

	public int getId_glosario() {
		return id_glosario;
	}

	public void setId_glosario(int id_glosario) {
		this.id_glosario = id_glosario;
	}
	
	
	
}
