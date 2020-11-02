package com.backend.demo.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.backend.demo.modelo.Cliente;


public interface RCliente extends CrudRepository<Cliente, Integer>{
	@Query("SELECT c FROM Cliente c WHERE c.id_user = :id_usuario")
	public Optional<Cliente> getClienteByIdUsuario(@Param("id_usuario") int id_usuario);
}
