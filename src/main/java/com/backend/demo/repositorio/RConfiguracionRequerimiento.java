package com.backend.demo.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.backend.demo.modelo.ConfiguracionRequerimiento;

public interface RConfiguracionRequerimiento extends CrudRepository<ConfiguracionRequerimiento, Integer>{
	@Query("SELECT c FROM ConfiguracionRequerimiento c WHERE c.id_usuario = :id_usuario")
	public Optional<ConfiguracionRequerimiento> getConfigUsuario(@Param("id_usuario") int id_usuario);

}
