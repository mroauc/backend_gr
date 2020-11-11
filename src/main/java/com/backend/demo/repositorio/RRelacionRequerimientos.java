package com.backend.demo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.backend.demo.modelo.RelacionRequerimientos;

public interface RRelacionRequerimientos extends CrudRepository<RelacionRequerimientos, Integer>{
	@Query("SELECT r  from RelacionRequerimientos r WHERE r.id_requerimiento_a = :id_requerimiento_a")
	List<RelacionRequerimientos> findAllByid_requerimiento_a(Integer id_requerimiento_a);
}
