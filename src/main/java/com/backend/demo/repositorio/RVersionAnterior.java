package com.backend.demo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.backend.demo.modelo.VersionAnterior;

public interface RVersionAnterior extends CrudRepository<VersionAnterior, Integer> {
	@Query("SELECT r from VersionAnterior r WHERE r.id_requerimiento = :id_requerimiento")
	List<VersionAnterior> findAllById_requerimiento(Integer id_requerimiento);
}
