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

import com.backend.demo.modelo.EncargadoSubProyecto;
import com.backend.demo.repositorio.REncargadoSubProyecto;

@RestController
@RequestMapping("api/encargadosubproyecto")
@CrossOrigin("*")
public class EncargadoSubProyectoController {
	
	@Autowired
	private REncargadoSubProyecto data;
	
	@GetMapping("/")
	public List<EncargadoSubProyecto> index(){
		return (List<EncargadoSubProyecto>) data.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<EncargadoSubProyecto> get(@PathVariable Integer id){
		return data.findById(id);
	}
	
	@PostMapping("/guardar")
	public EncargadoSubProyecto guardar(@RequestBody EncargadoSubProyecto esp) {
		return data.save(esp);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public Integer eliminar(@PathVariable Integer id) {
		data.deleteById(id);
		return id;
	}
	
	@PostMapping("/editar")
	public EncargadoSubProyecto editar(@RequestBody EncargadoSubProyecto esp) {
		return data.save(esp);
	}
}