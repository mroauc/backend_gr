package com.backend.demo.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.backend.demo.modelo.Palabra;
import com.backend.demo.repositorio.RPalabra;

@RestController
@RequestMapping("/api/palabra")
@CrossOrigin("*")

public class PalabraController {
	
	@Autowired
	private RPalabra data;
	
	@GetMapping("/")
	public List<Palabra> listar(){
		return (List<Palabra>)data.findAll();
	}
	
	@GetMapping("/{id_palabra}")
	public Optional<Palabra> obtenerPalabra(@PathVariable int id_palabra) {
		return data.findById(id_palabra);
	}
	
	@PostMapping("/guardar")
	public Palabra guardarPalabra(@RequestBody Palabra palabra) {
		return data.save(palabra);
	} 
	
	@DeleteMapping("/eliminar/{id_palabra}")
	public int eliminarPalabra(@PathVariable int id_palabra){
		data.deleteById(id_palabra);
		return id_palabra;
	}
	
	@PostMapping("/editar")
	public Palabra editarPalabra(@RequestBody Palabra palabra) {
		return data.save(palabra);
	}
	
	@GetMapping("/consulta/{id_glosario}")
	public List<Palabra> consultaBy_idGLosario(@PathVariable int id_glosario){
		return data.getPalabrasByGLosario(id_glosario);
	}
	
	
}
