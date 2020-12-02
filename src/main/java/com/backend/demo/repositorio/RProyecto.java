package com.backend.demo.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.backend.demo.modelo.EncargadoSubProyecto;
import com.backend.demo.modelo.Proyecto;
import com.backend.demo.modelo.SubProyecto;

public interface RProyecto extends CrudRepository<Proyecto, Integer>{
	Optional<Proyecto> findByNombre(String nombre);
	@Query("SELECT p FROM Proyecto p WHERE p.id_usuario = :id_usuario")
	List<Proyecto> findProyectosByid_usuario(Integer id_usuario);
	@Query("SELECT p FROM EncargadoSubProyecto p WHERE p.id_usuario = :id_usuario")
	List<EncargadoSubProyecto> findAllByid_usuario(Integer id_usuario);
}
