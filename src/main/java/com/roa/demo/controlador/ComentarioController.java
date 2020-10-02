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

import com.roa.demo.modelo.Comentario;
import com.roa.demo.repositorio.RComentario;

@RestController
@RequestMapping("/api/comentario")
@CrossOrigin("*")
public class ComentarioController {
	
	@Autowired
	private RComentario data;

	@GetMapping("/")
	public List<Comentario> listar(){
		return (List<Comentario>)data.findAll();
	}
	
	@GetMapping("/{id_comentario}")
	public Optional<Comentario> obtenerComentario(@PathVariable int id_comentario){
		return data.findById(id_comentario);
	}
	
	@PostMapping("/guardar")
	public Comentario guardarComentario(@RequestBody Comentario comentario) {
		return data.save(comentario);
	}
	
	@DeleteMapping("/eliminar/{id_comentario}")
	public int eliminarComentario(@PathVariable int id_comentario) {
		data.deleteById(id_comentario);
		return id_comentario;
	}
	
	@PostMapping("/editar")
	public Comentario editarComentario(@RequestBody Comentario comentario) {
		return data.save(comentario);
	}
	
	
}
