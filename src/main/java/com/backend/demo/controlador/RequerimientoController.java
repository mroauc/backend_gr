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

import com.backend.demo.modelo.Requerimiento;
import com.backend.demo.repositorio.RRequerimiento;

@RestController
@RequestMapping("api/requerimiento")
@CrossOrigin("*")
public class RequerimientoController {
	
	@Autowired
	private RRequerimiento data;
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/")
	public List<Requerimiento> index(){
		return (List<Requerimiento>) data.findAll();
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/{id_requerimiento}")
	public Optional<Requerimiento> get(@PathVariable Integer id_requerimiento){
		return data.findById(id_requerimiento);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/obtener/{id_subproyecto}")
	public List<Requerimiento> obtener(@PathVariable Integer id_subproyecto){
		return data.findAllByid_subProyecto(id_subproyecto);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/guardar")
	public Requerimiento guardar(@RequestBody Requerimiento requerimiento) {
		return data.save(requerimiento);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/eliminar/{id_requerimiento}")
	public Integer eliminar(@PathVariable Integer id_requerimiento) {
		data.deleteById(id_requerimiento);
		return id_requerimiento;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/editar")
	public Requerimiento editar(@RequestBody Requerimiento requerimiento) {
		return data.save(requerimiento);
	}
}
