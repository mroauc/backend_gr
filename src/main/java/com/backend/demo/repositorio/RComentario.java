package com.backend.demo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.backend.demo.modelo.Comentario;

public interface RComentario extends CrudRepository<Comentario, Integer>{
	@Query("SELECT c from Comentario c WHERE c.id_requerimiento = :id_requerimiento")
	List<Comentario> findAllByRequerimiento(Integer id_requerimiento);
	@Query("SELECT c from Comentario c WHERE c.id_usuario = :id_usuario")
	List<Comentario> findAllByUsuario(Integer id_usuario);
}
