package com.backend.demo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.backend.demo.modelo.Seccion;

public interface RSeccion extends CrudRepository<Seccion, Integer>{
	@Query("SELECT p FROM Seccion p WHERE p.id_proyecto= :id_proyecto")
	List<Seccion> findAllByid_proyecto(Integer id_proyecto);
}
