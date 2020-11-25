package com.backend.demo.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RelacionRequerimientos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_relacionRequerimientos;
	private int id_requerimiento_a;
	private int id_requerimiento_b;
	
	public RelacionRequerimientos() {
		
	}

	public RelacionRequerimientos(int id_relacionRequerimientos, int id_requerimiento_a, int id_requerimiento_b) {
		super();
		this.id_relacionRequerimientos = id_relacionRequerimientos;
		this.id_requerimiento_a = id_requerimiento_a;
		this.id_requerimiento_b = id_requerimiento_b;
	}

	public int getId_relacionRequerimientos() {
		return id_relacionRequerimientos;
	}

	public void setId_relacionRequerimientos(int id_relacionRequerimientos) {
		this.id_relacionRequerimientos = id_relacionRequerimientos;
	}

	public int getId_requerimiento_a() {
		return id_requerimiento_a;
	}

	public void setId_requerimiento_a(int id_requerimiento_a) {
		this.id_requerimiento_a = id_requerimiento_a;
	}

	public int getId_requerimiento_b() {
		return id_requerimiento_b;
	}

	public void setId_requerimiento_b(int id_requerimiento_b) {
		this.id_requerimiento_b = id_requerimiento_b;
	}
}
