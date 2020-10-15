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

import com.backend.demo.modelo.Usuario;
import com.backend.demo.repositorio.RUsuario;

@RestController
@RequestMapping("/api/usuario")
@CrossOrigin("*")
public class UsuarioController {
	
	@Autowired
	private RUsuario data;
	
	@GetMapping("/")
	public List<Usuario> index(){
		return (List<Usuario>) data.findAll();
	}
	
	@GetMapping("/{id_usuario")
	public Optional<Usuario> getUsuario(@PathVariable Integer id_usuario){
		return data.findById(id_usuario);
	}
	
	@PostMapping("/guardar")
	public Usuario guardarUsuario(@RequestBody Usuario usuario) {
		return data.save(usuario);
	}
	
	@DeleteMapping("/eliminar/{id_usuario}")
	public Integer eliminarUsuario(@PathVariable Integer id_usuario) {
		data.deleteById(id_usuario);
		return id_usuario;
	}
	
	@PostMapping("/editar")
	public Usuario editarUsuario(@RequestBody Usuario usuario) {
		return data.save(usuario);
	}
	
}
