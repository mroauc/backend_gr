package com.backend.demo.repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.backend.demo.modelo.UsuarioActividad;

public interface RUsuarioActividad extends CrudRepository<UsuarioActividad, Integer>{
	@Query("SELECT c from UsuarioActividad c WHERE c.id_requerimiento= :id_requerimiento")
	UsuarioActividad findAllByIdRequerimiento(Integer id_requerimiento);
}
