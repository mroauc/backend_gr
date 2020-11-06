package com.backend.demo.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.demo.modelo.Cliente;
import com.backend.demo.repositorio.RCliente;

@RestController
@RequestMapping("/api/cliente")
@CrossOrigin("*")
public class ClienteController {
	
	@Autowired
	private RCliente data;

	@GetMapping("/")
	public List<Cliente> listar(){
		return (List<Cliente>)data.findAll();
	}
	
	@GetMapping("/{id_cliente}")
	public Optional<Cliente> obtenerCliente(@PathVariable int id_cliente){
		return data.findById(id_cliente);
	}
	
	@PostMapping("/guardar")
	public Cliente guardarCliente(@RequestBody Cliente cliente) {
		return data.save(cliente);
	}
	
	@DeleteMapping("/eliminar/{id_cliente}")
	public int eliminarCliente(@PathVariable int id_cliente) {
		data.deleteById(id_cliente);
		return id_cliente;
	}
	
	@PostMapping("/editar")
	public Cliente editarCliente(@RequestBody Cliente cliente) {
		return data.save(cliente);
	}
	
	@GetMapping("id_usuario/{id_usuario}")
	public Optional<Cliente> ClienteByIdUsuario(@PathVariable int id_usuario){
		return data.getClienteByIdUsuario(id_usuario);
	}
	
	
}
