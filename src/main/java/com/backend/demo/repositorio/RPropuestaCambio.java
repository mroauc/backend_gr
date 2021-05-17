package com.backend.demo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.backend.demo.modelo.PropuestaCambio;

public interface RPropuestaCambio extends CrudRepository<PropuestaCambio, Integer>{
	@Query("SELECT p FROM PropuestaCambio p WHERE p.id_subproyecto = :id_subproyecto")
	List<PropuestaCambio> findByid_subproyecto(Integer id_subproyecto);
	@Query("SELECT p FROM PropuestaCambio p WHERE p.id_usuario = :id_usuario")
	List<PropuestaCambio> findByid_usuario(Integer id_usuario);
	@Query("SELECT p FROM PropuestaCambio p WHERE p.id_proyecto = :id_proyecto")
	List<PropuestaCambio> findByid_proyecto(Integer id_proyecto);
}
