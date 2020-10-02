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

import com.backend.demo.modelo.RelacionRequerimientos;
import com.backend.demo.repositorio.RRelacionRequerimientos;

@RestController
@RequestMapping("api/relacionrequerimientos")
@CrossOrigin("*")
public class RelacionRequerimientosController {

	@Autowired
	private RRelacionRequerimientos data;
	
	@GetMapping("/")
	public List<RelacionRequerimientos> index(){
		return (List<RelacionRequerimientos>) data.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<RelacionRequerimientos> get(@PathVariable Integer id){
		return data.findById(id);
	}
	
	@PostMapping("/guardar")
	public RelacionRequerimientos guardar(@RequestBody RelacionRequerimientos rr) {
		return data.save(rr);
	}
	
	@DeleteMapping("/eliminar")
	public Integer eliminar(@PathVariable Integer id) {
		data.deleteById(id);
		return id;
	}
	
	@PostMapping("/editar")
	public RelacionRequerimientos editar(@RequestBody RelacionRequerimientos rr) {
		return data.save(rr);
	}
}
