package com.backend.demo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.backend.demo.modelo.Errores;

public interface RErrores extends CrudRepository<Errores, Integer>{
	@Query("SELECT p FROM Errores p WHERE p.id_proyecto =:id_proyecto")
	List<Errores> findAllByid_proyecto(Integer id_proyecto);
}
