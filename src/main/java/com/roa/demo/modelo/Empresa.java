package com.roa.demo.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Empresa {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_empresa;
	private String razon_social;
	private String rut_empresa;
	private String representante;


	public Empresa() {
	}


	public Empresa(int id_empresa, String razon_social, String rut_empresa, String representante) {
		super();
		this.id_empresa = id_empresa;
		this.razon_social = razon_social;
		this.rut_empresa = rut_empresa;
		this.representante = representante;
	}


	public int getId_empresa() {
		return id_empresa;
	}


	public void setId_empresa(int id_empresa) {
		this.id_empresa = id_empresa;
	}


	public String getRazon_social() {
		return razon_social;
	}


	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}


	public String getRut_empresa() {
		return rut_empresa;
	}


	public void setRut_empresa(String rut_empresa) {
		this.rut_empresa = rut_empresa;
	}


	public String getRepresentante() {
		return representante;
	}


	public void setRepresentante(String representante) {
		this.representante = representante;
	}	

	
}


