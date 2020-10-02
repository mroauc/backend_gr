package com.roa.demo.controlador;

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

import com.roa.demo.modelo.SubProyecto;
import com.roa.demo.repositorio.RSubProyecto;

@RestController
@RequestMapping("/api/subProyecto")
@CrossOrigin
public class SubProyectoController {
	
	@Autowired
	private RSubProyecto data;
	
	@GetMapping("/")
	public List<SubProyecto> listar(){
		return (List<SubProyecto>)data.findAll();
	}
	
	@GetMapping("/{id_subProyecto}")
	public Optional<SubProyecto> obtenerSubProyecto(@PathVariable int id_subProyecto) {
		return data.findById(id_subProyecto);
	}
	
	@PostMapping("/guardar")
	public SubProyecto guardarSubProyecto(@RequestBody SubProyecto subProyecto) {
		return data.save(subProyecto);
	} 
	
	@DeleteMapping("/eliminar/{id_subProyecto}")
	public int eliminarSubProyecto(@PathVariable int id_subProyecto){
		data.deleteById(id_subProyecto);
		return id_subProyecto;
	}
	
	@PostMapping("/editar")
	public SubProyecto editarSubProyecto(@RequestBody SubProyecto subProyecto) {
		return data.save(subProyecto);
	}
	
}
