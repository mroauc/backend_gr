package com.backend.demo.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.demo.modelo.Errores;
import com.backend.demo.repositorio.RErrores;

@RestController
@RequestMapping("api/errores")
@CrossOrigin("*")
public class ErroresController {

	@Autowired
	private RErrores data;
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/")
	public List<Errores> index(){
		return (List<Errores>) data.findAll();
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/{id}")
	public Optional<Errores> get(@PathVariable Integer id){
		return data.findById(id);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/guardar")
	public Errores guardar(@RequestBody Errores error) {
		return data.save(error);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/eliminar/{id}")
	public Integer eliminar(@PathVariable Integer id) {
		data.deleteById(id);
		return id;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/editar")
	public Errores editar(@RequestBody Errores error) {
		return data.save(error);
	}
}