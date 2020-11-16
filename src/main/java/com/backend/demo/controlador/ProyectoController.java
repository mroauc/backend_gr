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

import com.backend.demo.modelo.EncargadoSubProyecto;
import com.backend.demo.modelo.Proyecto;
import com.backend.demo.modelo.SubProyecto;
import com.backend.demo.repositorio.REncargadoSubProyecto;
import com.backend.demo.repositorio.RProyecto;
import com.backend.demo.repositorio.RSubProyecto;

@RestController
@RequestMapping("api/proyecto")
@CrossOrigin("*")
public class ProyectoController {
	
	@Autowired
	private RProyecto data;
	@Autowired
	private RSubProyecto dataSub;
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CLIENTE','ROLE_ANALISTA')")
	@GetMapping("/")
	public List<Proyecto> index(){
		return (List<Proyecto>) data.findAll();
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CLIENTE')")
	@GetMapping("/{id_proyecto}")
	public Optional<Proyecto> get(@PathVariable Integer id_proyecto){
		return data.findById(id_proyecto);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CLIENTE')")
	@GetMapping("/nombre/{nombre_proyecto}")
	public Optional<Proyecto> getProyecto(@PathVariable String nombre_proyecto){
		return data.findByNombre(nombre_proyecto);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CLIENTE')")
	@PostMapping("/guardar")
	public Proyecto guardar(@RequestBody Proyecto proyecto) {
		return data.save(proyecto);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CLIENTE')")
	@DeleteMapping("/eliminar/{id_proyecto}")
	public Integer eliminar(@PathVariable Integer id_proyecto) {
		data.deleteById(id_proyecto);
		return id_proyecto;
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CLIENTE','ROLE_ANALISTA')")
	@GetMapping("/id_usuario/{id_usuario}/{tipo}")
	public List<Proyecto> getProyectoByIdUser(@PathVariable Integer id_usuario, @PathVariable String tipo){
		
		if(tipo.equals("admin")) {
			
			return (List<Proyecto>) data.findAll();
		}
		else {
			List<EncargadoSubProyecto> registrosEncargados = data.findAllByid_usuario(id_usuario);
			List<Integer> IdSubproyectos = new ArrayList<Integer>();
			List<Proyecto> Proyectos = new ArrayList<Proyecto>();
			
			for (EncargadoSubProyecto item: registrosEncargados) {
				IdSubproyectos.add(item.getId_subProyecto());
			}
			
			for(Integer item: IdSubproyectos ) {
				Proyectos.add(data.findById(dataSub.findById(item).get().getId_proyecto()).get());
			}
			System.out.println(Proyectos);
			return Proyectos;
		}
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CLIENTE')")
	@PostMapping("/editar")
	public Proyecto editar(@RequestBody Proyecto proyecto) {
		return data.save(proyecto);
	}
	
}
