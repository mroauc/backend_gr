package com.backend.demo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.backend.demo.modelo.Palabra;

public interface RPalabra extends CrudRepository<Palabra, Integer> {
	
	@Query("SELECT p FROM Palabra p WHERE p.id_glosario = :id_glosario")
	public List<Palabra> getPalabrasByGLosario(@Param("id_glosario") int id_glosario);
}
