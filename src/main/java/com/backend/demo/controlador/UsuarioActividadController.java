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

import com.backend.demo.modelo.UsuarioActividad;
import com.backend.demo.repositorio.RUsuarioActividad;

@RestController
@RequestMapping("api/usuarioactividad")
@CrossOrigin("*")
public class UsuarioActividadController {

	@Autowired
	private RUsuarioActividad data;
	
	@GetMapping("/")
	public List<UsuarioActividad> index(){
		return (List<UsuarioActividad>) data.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<UsuarioActividad> get(@PathVariable Integer id){
		return data.findById(id);
	}
	
	@PostMapping("/guardar")
	public UsuarioActividad guardar(@RequestBody UsuarioActividad usuarioactividad) {
		return data.save(usuarioactividad);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public Integer eliminar(@PathVariable Integer id) {
		data.deleteById(id);
		return id;
	}
	
	@PostMapping("/editar")
	public UsuarioActividad editar(@RequestBody UsuarioActividad usuarioactividad) {
		return data.save(usuarioactividad);
	}
}
