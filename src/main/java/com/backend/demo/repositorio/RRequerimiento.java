package com.backend.demo.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.backend.demo.modelo.Requerimiento;

public interface RRequerimiento extends CrudRepository<Requerimiento, Integer>{
	@Query("SELECT r from Requerimiento r WHERE r.id_subProyecto = :id_subProyecto")
	List<Requerimiento> findAllByid_subProyecto(Integer id_subProyecto);	
	
	Optional<Requerimiento> findByNombre(String nombre);
	
	@Query("SELECT r from Requerimiento r WHERE r.id_template = :id_template")
	List<Requerimiento> findAllByid_template(Integer id_template);
}
