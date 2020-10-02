package com.backend.demo.repositorio;

import org.springframework.data.repository.CrudRepository;

import com.backend.demo.modelo.Cliente;

public interface RCliente extends CrudRepository<Cliente, Integer>{

}
