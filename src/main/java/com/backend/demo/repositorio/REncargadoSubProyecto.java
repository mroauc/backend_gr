package com.backend.demo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.backend.demo.modelo.EncargadoSubProyecto;

public interface REncargadoSubProyecto extends CrudRepository<EncargadoSubProyecto, Integer>{
	@Query("SELECT p FROM EncargadoSubProyecto p WHERE p.id_subProyecto = :id_subProyecto")
	List<EncargadoSubProyecto> findAllByid_subProyecto(Integer id_subProyecto);
	@Query("SELECT p FROM EncargadoSubProyecto p WHERE p.id_usuario = :id_usuario")
	List<EncargadoSubProyecto> findAllByid_usuario(Integer id_usuario);
}
