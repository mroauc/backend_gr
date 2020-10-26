package com.backend.demo.repositorio;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.backend.demo.modelo.Proyecto;

public interface RProyecto extends CrudRepository<Proyecto, Integer>{
	Optional<Proyecto> findByNombre(String nombre);
}
