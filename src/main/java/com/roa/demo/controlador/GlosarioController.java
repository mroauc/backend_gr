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

import com.roa.demo.modelo.Glosario;
import com.roa.demo.repositorio.RGlosario;

@RestController
@RequestMapping("/api/glosario")
@CrossOrigin("*")
public class GlosarioController {
	@Autowired
	private RGlosario data;
	
	@GetMapping("/")
	public List<Glosario> listar(){
		return (List<Glosario>)data.findAll();
	}
	
	@GetMapping("/{id_glosario}")
	public Optional<Glosario> obtenerGlosario(@PathVariable int id_glosario){
		return data.findById(id_glosario);
	}
	
	@PostMapping("/guardarGlosario")
	public Glosario guardarGlosario(@RequestBody Glosario glosario) {
		return data.save(glosario);
	}
	
	@DeleteMapping("/eliminar/{id_glosario}")
	public int eliminarGlosario(@PathVariable int id_glosario) {
		data.deleteById(id_glosario);
		return id_glosario;
	}
	
	@PostMapping("/editar")
	public Glosario edtiarGlosario(@RequestBody Glosario glosario) {
		return data.save(glosario);
	}
}
