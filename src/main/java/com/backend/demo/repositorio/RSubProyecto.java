package com.backend.demo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.backend.demo.modelo.SubProyecto;

public interface RSubProyecto extends CrudRepository<SubProyecto, Integer> {
	@Query("SELECT s FROM SubProyecto s WHERE s.id_proyecto = :id_proyecto")
	List<SubProyecto> findByid_proyecto(Integer id_proyecto);
}
