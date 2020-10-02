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

import com.backend.demo.modelo.Proyecto;
import com.backend.demo.repositorio.RProyecto;

@RestController
@RequestMapping("api/proyecto")
@CrossOrigin("*")
public class ProyectoController {
	
	@Autowired
	private RProyecto data;
	
	@GetMapping("/")
	public List<Proyecto> index(){
		return (List<Proyecto>) data.findAll();
	}
	
	@GetMapping("/{id_proyecto}")
	public Optional<Proyecto> get(@PathVariable Integer id_proyecto){
		return data.findById(id_proyecto);
	}
	
	@PostMapping("/guardar")
	public Proyecto guardar(@RequestBody Proyecto proyecto) {
		return data.save(proyecto);
	}
	
	@DeleteMapping("/eliminar/{id_proyecto}")
	public Integer eliminar(@PathVariable Integer id_proyecto) {
		data.deleteById(id_proyecto);
		return id_proyecto;
	}
	
	@PostMapping("/editar")
	public Proyecto editar(@RequestBody Proyecto proyecto) {
		return data.save(proyecto);
	}
}