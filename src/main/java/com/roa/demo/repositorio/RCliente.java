package com.roa.demo.repositorio;

import org.springframework.data.repository.CrudRepository;

import com.roa.demo.modelo.Cliente;

public interface RCliente extends CrudRepository<Cliente, Integer>{

}
