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

import com.backend.demo.modelo.EncargadoSubProyecto;
import com.backend.demo.repositorio.REncargadoSubProyecto;

@RestController
@RequestMapping("api/encargadosubproyecto")
@CrossOrigin("*")
public class EncargadoSubProyectoController {
	
	@Autowired
	private REncargadoSubProyecto data;
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ANALISTA')")
	@GetMapping("/")
	public List<EncargadoSubProyecto> index(){
		return (List<EncargadoSubProyecto>) data.findAll();
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ANALISTA')")
	@GetMapping("/{id}")
	public Optional<EncargadoSubProyecto> get(@PathVariable Integer id){
		return data.findById(id);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ANALISTA')")
	@GetMapping("/obtener/{id_subproyecto}")
	public List<EncargadoSubProyecto> obtener(@PathVariable Integer id_subproyecto){
		return data.findAllByid_subProyecto(id_subproyecto);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ANALISTA')")
	@GetMapping("/id_usuario/{id_usuario}")
	public List<EncargadoSubProyecto> obtenerByIdUsuario(@PathVariable Integer id_usuario){
		return data.findAllByid_usuario(id_usuario);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ANALISTA')")
	@PostMapping("/guardar")
	public EncargadoSubProyecto guardar(@RequestBody EncargadoSubProyecto esp) {
		return data.save(esp);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ANALISTA')")
	@DeleteMapping("/eliminar/{id}")
	public Integer eliminar(@PathVariable Integer id) {
		data.deleteById(id);
		return id;
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ANALISTA')")
	@PostMapping("/editar")
	public EncargadoSubProyecto editar(@RequestBody EncargadoSubProyecto esp) {
		return data.save(esp);
	}
}