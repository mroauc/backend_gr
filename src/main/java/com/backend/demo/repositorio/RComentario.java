package com.backend.demo.repositorio;

import org.springframework.data.repository.CrudRepository;

import com.backend.demo.modelo.Comentario;

public interface RComentario extends CrudRepository<Comentario, Integer>{

}