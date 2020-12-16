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

import com.backend.demo.modelo.VersionAnterior;
import com.backend.demo.repositorio.RVersionAnterior;

@RestController
@RequestMapping("api/versionanterior")
@CrossOrigin("*")
public class VersionAnteriorController {
	
	@Autowired
	private RVersionAnterior data;
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_JEFE_PROYECTO')")
	@GetMapping("/")
	public List<VersionAnterior> index(){
		return (List<VersionAnterior>) data.findAll();
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_JEFE_PROYECTO')")
	@GetMapping("/{id_versionAnterior}")
	public Optional<VersionAnterior> get(@PathVariable Integer id_versionAnterior){
		return data.findById(id_versionAnterior);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_JEFE_PROYECTO')")
	@GetMapping("/requerimiento/{id_requerimiento}")
	public List<VersionAnterior> obtener(@PathVariable Integer id_requerimiento){
		return data.findAllById_requerimiento(id_requerimiento);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_JEFE_PROYECTO')")
	@PostMapping("/guardar")
	public VersionAnterior guardar(@RequestBody VersionAnterior versionAnterior) {
		return data.save(versionAnterior);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_JEFE_PROYECTO')")
	@PostMapping("/editar")
	public VersionAnterior editar(@RequestBody VersionAnterior versionAnterior) {
		return data.save(versionAnterior);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_JEFE_PROYECTO')")
	@DeleteMapping("/eliminar/{id_versionAnterior}")
	public Integer eliminar(@PathVariable Integer id_versionAnterior) {
		data.deleteById(id_versionAnterior);
		return id_versionAnterior;
	}
}