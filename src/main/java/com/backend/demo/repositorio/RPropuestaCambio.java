package com.backend.demo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.backend.demo.modelo.PropuestaCambio;

public interface RPropuestaCambio extends CrudRepository<PropuestaCambio, Integer>{
	@Query("SELECT p FROM PropuestaCambio p WHERE p.id_subproyecto = :id_subproyecto")
	List<PropuestaCambio> findByid_subproyecto(Integer id_subproyecto);
}
