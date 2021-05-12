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

import com.backend.demo.modelo.UsuarioActividad;
import com.backend.demo.repositorio.RUsuarioActividad;

@RestController
@RequestMapping("api/usuarioactividad")
@CrossOrigin("*")
public class UsuarioActividadController {

	@Autowired
	private RUsuarioActividad data;
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_JEFE_PROYECTO', 'ROLE_ANALISTA', 'ROLE_LIDER','ROLE_LIDER_SUBPROYECTO')")
	@GetMapping("/")
	public List<UsuarioActividad> index(){
		return (List<UsuarioActividad>) data.findAll();
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_JEFE_PROYECTO', 'ROLE_ANALISTA', 'ROLE_LIDER','ROLE_LIDER_SUBPROYECTO')")
	@GetMapping("/{id}")
	public Optional<UsuarioActividad> get(@PathVariable Integer id){
		return data.findById(id);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_JEFE_PROYECTO', 'ROLE_ANALISTA', 'ROLE_LIDER','ROLE_LIDER_SUBPROYECTO')")
	@PostMapping("/guardar")
	public UsuarioActividad guardar(@RequestBody UsuarioActividad usuarioactividad) {
		return data.save(usuarioactividad);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_JEFE_PROYECTO', 'ROLE_ANALISTA', 'ROLE_LIDER','ROLE_LIDER_SUBPROYECTO')")
	@DeleteMapping("/eliminar/{id}")
	public Integer eliminar(@PathVariable Integer id) {
		data.deleteById(id);
		return id;
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_JEFE_PROYECTO', 'ROLE_ANALISTA', 'ROLE_LIDER','ROLE_LIDER_SUBPROYECTO')")
	@PostMapping("/editar")
	public UsuarioActividad editar(@RequestBody UsuarioActividad usuarioactividad) {
		return data.save(usuarioactividad);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_JEFE_PROYECTO', 'ROLE_ANALISTA', 'ROLE_LIDER','ROLE_LIDER_SUBPROYECTO')")
	@GetMapping("id_requerimiento/{id_requerimiento}")
	public UsuarioActividad findUsuarioActividadByIdReq(@PathVariable Integer id_requerimiento) {
		return data.findAllByIdRequerimiento(id_requerimiento);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_JEFE_PROYECTO', 'ROLE_ANALISTA', 'ROLE_LIDER','ROLE_LIDER_SUBPROYECTO')")
	@DeleteMapping("eliminar/id_requerimiento/{id_requerimiento}")
	public Integer deleteByIdRequerimiento(@PathVariable Integer id_requerimiento) {
		UsuarioActividad usuarioActividad = data.findAllByIdRequerimiento(id_requerimiento);
		data.deleteById(usuarioActividad.getId_usuarioActividad());
		return id_requerimiento;
	}
}
