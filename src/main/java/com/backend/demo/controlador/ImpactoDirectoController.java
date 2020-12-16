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

import com.backend.demo.modelo.ImpactoDirecto;
import com.backend.demo.repositorio.RImpactoDirecto;

@RestController
@RequestMapping("/api/impacto_directo")
@CrossOrigin("*")
public class ImpactoDirectoController {
	
	@Autowired
	private RImpactoDirecto data;

	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_JEFE_PROYECTO','ROLE_ANALISTA')")
	@GetMapping("/")
	public List<ImpactoDirecto> listar(){
		return (List<ImpactoDirecto>)data.findAll();
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_JEFE_PROYECTO','ROLE_ANALISTA')")
	@GetMapping("/{id_impacto_directo}")
	public Optional<ImpactoDirecto> obtenerImpactoDirecto(@PathVariable int id_impacto_directo){
		return data.findById(id_impacto_directo);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_JEFE_PROYECTO','ROLE_ANALISTA')")
	@GetMapping("/obtener/{id_propuestaCambio}")
	public List<ImpactoDirecto> obtenerPorPropuestaCambio(@PathVariable Integer id_propuestaCambio){
		return data.findAllByid_propuestaCambio(id_propuestaCambio);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_JEFE_PROYECTO','ROLE_ANALISTA')")
	@GetMapping("obtener/requerimiento/{id_requerimiento}")
	public List<ImpactoDirecto> obtenerPorRequerimiento(@PathVariable Integer id_requerimiento){
		return data.findAllByid_requerimiento(id_requerimiento);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/guardar")
	public ImpactoDirecto guardarImpactoDirecto(@RequestBody ImpactoDirecto impacto_directo) {
		return data.save(impacto_directo);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/eliminar/{id_impacto_directo}")
	public int eliminarImpactoDirecto(@PathVariable int id_impacto_directo) {
		data.deleteById(id_impacto_directo);
		return id_impacto_directo;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/editar")
	public ImpactoDirecto editarImpactoDirecto(@RequestBody ImpactoDirecto impacto_directo) {
		return data.save(impacto_directo);
	}
}
