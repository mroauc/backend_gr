package com.backend.demo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.backend.demo.modelo.ProyectoEmpresa;

public interface RProyectoEmpresa extends CrudRepository<ProyectoEmpresa, Integer> {
	@Query("SELECT p from ProyectoEmpresa p WHERE p.id_proyecto = :id_proyecto")
	List<ProyectoEmpresa> findAllByid_proyecto(Integer id_proyecto);
}
