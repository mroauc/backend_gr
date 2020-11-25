package com.backend.demo.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Comentario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_comentario;
	private String texto;
	private int id_requerimiento;
	private String fecha_ingreso;
	private int id_usuario;
	
	public Comentario() {
		
	}

	public Comentario(int id_comentario, String texto, int id_requerimiento, String fecha_ingreso, int id_usuario) {
		super();
		this.id_comentario = id_comentario;
		this.texto = texto;
		this.id_requerimiento = id_requerimiento;
		this.fecha_ingreso = fecha_ingreso;
		this.id_usuario = id_usuario;
	}

	public int getId_comentario() {
		return id_comentario;
	}

	public void setId_comentario(int id_comentario) {
		this.id_comentario = id_comentario;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public int getId_requerimiento() {
		return id_requerimiento;
	}

	public void setId_requerimiento(int id_requerimiento) {
		this.id_requerimiento = id_requerimiento;
	}

	public String getFecha_ingreso() {
		return fecha_ingreso;
	}

	public void setFecha_ingreso(String fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	
}