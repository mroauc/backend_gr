package com.roa.demo.repositorio;

import org.springframework.data.repository.CrudRepository;

import com.roa.demo.modelo.Comentario;

public interface RComentario extends CrudRepository<Comentario, Integer>{

}
