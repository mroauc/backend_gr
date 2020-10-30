package com.backend.demo.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.access.prepost.PreAuthorize;

import com.backend.demo.modelo.Palabra;
import com.backend.demo.repositorio.RPalabra;

@RestController
@RequestMapping("/api/palabra")
@CrossOrigin("*")

public class PalabraController {
	
	@Autowired
	private RPalabra data;
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/")
	public ResponseEntity<List<Palabra>> listar(){
		return new ResponseEntity((List<Palabra>)data.findAll(), HttpStatus.OK);
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
	
	@GetMapping("/consulta/{id_proyecto}")
	public List<Palabra> consultaBy_idProyecto(@PathVariable int id_proyecto){
		return data.getPalabrasByProyecto(id_proyecto);
	}
	
	
}
