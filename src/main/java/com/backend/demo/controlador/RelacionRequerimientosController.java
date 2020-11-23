package com.backend.demo.controlador;

import java.util.ArrayList;
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

import com.backend.demo.modelo.Proyecto;
import com.backend.demo.modelo.RelacionRequerimientos;
import com.backend.demo.modelo.Requerimiento;
import com.backend.demo.repositorio.RRelacionRequerimientos;
import com.backend.demo.repositorio.RRequerimiento;

@RestController
@RequestMapping("api/relacionrequerimientos")
@CrossOrigin("*")
public class RelacionRequerimientosController {

	@Autowired
	private RRelacionRequerimientos data;
	@Autowired
	private RRequerimiento repRequerimiento;
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/")
	public List<RelacionRequerimientos> index(){
		return (List<RelacionRequerimientos>) data.findAll();
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/{id}")
	public Optional<RelacionRequerimientos> get(@PathVariable Integer id){
		return data.findById(id);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/obtener/{id_requerimiento_a}")
	public List<RelacionRequerimientos> obtenerPertenecientes(@PathVariable Integer id_requerimiento_a){
		return data.findAllByid_requerimiento_a(id_requerimiento_a);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/requerimientosAsociados/{id_requerimiento_a}")
	public List<Requerimiento> obtenerReqPertenecientes(@PathVariable Integer id_requerimiento_a){
		List<RelacionRequerimientos> Encontrados =  data.findAllByid_requerimiento_a(id_requerimiento_a);
		List<Requerimiento> requerimientosFinales = new ArrayList<Requerimiento>();
		System.out.println(Encontrados.get(0).getId_relacionRequerimientos());
		
		for(RelacionRequerimientos item : Encontrados ){
			System.out.println(item.getId_requerimiento_b());
			requerimientosFinales.add(repRequerimiento.findById(item.getId_requerimiento_b()).get());
		}
		System.out.println(requerimientosFinales.get(0));
		
		return requerimientosFinales;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/guardar")
	public RelacionRequerimientos guardar(@RequestBody RelacionRequerimientos rr) {
		return data.save(rr);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/eliminar/{id}")
	public Integer eliminar(@PathVariable Integer id) {
		data.deleteById(id);
		return id;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/editar")
	public RelacionRequerimientos editar(@RequestBody RelacionRequerimientos rr) {
		return data.save(rr);
	}
}
