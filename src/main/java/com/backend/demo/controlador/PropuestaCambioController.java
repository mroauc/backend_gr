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

import com.backend.demo.modelo.PropuestaCambio;
import com.backend.demo.repositorio.RPropuestaCambio;

@RestController
@RequestMapping("api/propuestacambio")
@CrossOrigin("*")
public class PropuestaCambioController {

	@Autowired
	private RPropuestaCambio data;
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/")
	public List<PropuestaCambio> index(){
		return (List<PropuestaCambio>) data.findAll();
	}
	
	@GetMapping("/obtener/{id_subproyecto}")
	public List<PropuestaCambio> obtener(@PathVariable Integer id_subproyecto){
		return (List<PropuestaCambio>) data.findByid_subproyecto(id_subproyecto);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/{id}")
	public Optional<PropuestaCambio> get(@PathVariable Integer id){
		return data.findById(id);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/guardar")
	public PropuestaCambio guardar(@RequestBody PropuestaCambio propuestaCambio) {
		return data.save(propuestaCambio);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/eliminar/{id}")
	public Integer eliminar(@PathVariable Integer id) {
		data.deleteById(id);
		return id;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/editar")
	public PropuestaCambio editar(@RequestBody PropuestaCambio propuestaCambio) {
		return data.save(propuestaCambio);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/id_proyecto/{id_proyecto}")
	public List<PropuestaCambio> getByIdProyecto(@PathVariable Integer id_proyecto){
		return data.findByid_proyecto(id_proyecto);
	}
}