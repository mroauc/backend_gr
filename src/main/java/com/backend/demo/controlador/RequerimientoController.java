package com.backend.demo.controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.cache.internal.QueryResultsCacheImpl.CacheItem;
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

import com.backend.demo.modelo.Comentario;
import com.backend.demo.modelo.ImpactoDirecto;
import com.backend.demo.modelo.RelacionRequerimientos;
import com.backend.demo.modelo.Requerimiento;
import com.backend.demo.modelo.SubProyecto;
import com.backend.demo.modelo.UsuarioActividad;
import com.backend.demo.repositorio.RComentario;
import com.backend.demo.repositorio.RImpactoDirecto;
import com.backend.demo.repositorio.RPropuestaCambio;
import com.backend.demo.repositorio.RProyecto;
import com.backend.demo.repositorio.RRelacionRequerimientos;
import com.backend.demo.repositorio.RRequerimiento;
import com.backend.demo.repositorio.RSubProyecto;
import com.backend.demo.repositorio.RUsuarioActividad;

@RestController
@RequestMapping("api/requerimiento")
@CrossOrigin("*")
public class RequerimientoController {
	
	@Autowired
	private RRequerimiento data;
	@Autowired
	private RComentario rComentario;
	@Autowired
	private RImpactoDirecto rImpactoDirecto;
	@Autowired
	private RPropuestaCambio rPropuestaCambio;
	@Autowired
	private RRelacionRequerimientos rRelacionRequerimiento;
	@Autowired
	private RUsuarioActividad rUsuarioActividad;
	@Autowired
	private RProyecto rProyecto;
	@Autowired
	private RSubProyecto rSubproyecto;
	
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ANALISTA' ,'ROLE_JEFE_PROYECTO','ROLE_LIDER_SUBPROYECTO')")
	@GetMapping("/")
	public List<Requerimiento> index(){
		return (List<Requerimiento>) data.findAll();
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_JEFE_PROYECTO','ROLE_ANALISTA','ROLE_LIDER_SUBPROYECTO')")
	@GetMapping("/{id_requerimiento}")
	public Optional<Requerimiento> get(@PathVariable Integer id_requerimiento){
		return data.findById(id_requerimiento);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_JEFE_PROYECTO','ROLE_ANALISTA','ROLE_LIDER_SUBPROYECTO')")
	@GetMapping("/nombre/{nombre}")
	public Optional<Requerimiento> obtenerPorNombre(@PathVariable String nombre){
		return data.findByNombre(nombre);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_JEFE_PROYECTO','ROLE_ANALISTA','ROLE_CLIENTE','ROLE_LIDER_SUBPROYECTO')")
	@GetMapping("/obtener/{id_subproyecto}")
	public List<Requerimiento> obtener(@PathVariable Integer id_subproyecto){
		return data.findAllByid_subProyecto(id_subproyecto);
	}
	
	@GetMapping("/obtenerRequerimientos/{id_subproyecto}")
	public List<Requerimiento> obtenerTodos(@PathVariable Integer id_subproyecto){
		Optional<SubProyecto> actual = rSubproyecto.findById(id_subproyecto);
		List<SubProyecto> moduloos = rSubproyecto.findByid_proyecto(actual.get().getId_proyecto());
		List<Requerimiento> listaTotal = new ArrayList<Requerimiento>();
		List<Requerimiento> aux = new ArrayList<Requerimiento>();
		for (SubProyecto item: moduloos) {
			aux = data.findAllByid_subProyecto(item.getId_subProyecto());
			for(Requerimiento itemm: aux) {
				listaTotal.add(itemm);
			}
		}
		return listaTotal;
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_JEFE_PROYECTO','ROLE_ANALISTA','ROLE_LIDER_SUBPROYECTO')")
	@GetMapping("obtener/template/{id_template}")
	public List<Requerimiento> obtenerportemplate(@PathVariable Integer id_template){
		return data.findAllByid_template(id_template);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_JEFE_PROYECTO', 'ROLE_ANALISTA', 'ROLE_LIDER','ROLE_LIDER_SUBPROYECTO')")
	@PostMapping("/guardar")
	public Requerimiento guardar(@RequestBody Requerimiento requerimiento) {
		return data.save(requerimiento);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_JEFE_PROYECTO','ROLE_ANALISTA','ROLE_LIDER_SUBPROYECTO')")
	@PostMapping("/editar")
	public Requerimiento editar(@RequestBody Requerimiento requerimiento) {
		return data.save(requerimiento);
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_JEFE_PROYECTO', 'ROLE_ANALISTA','ROLE_LIDER_SUBPROYECTO')")
	@DeleteMapping("/eliminar/{id_requerimiento}")
	public Integer eliminar(@PathVariable Integer id_requerimiento) {
		List<Comentario> comentarios = rComentario.findAllByRequerimiento(id_requerimiento);
		for (Comentario item: comentarios) {
			rComentario.deleteById(item.getId_comentario());
		}
		List<ImpactoDirecto> registrosImpacto = rImpactoDirecto.findAllByid_requerimiento(id_requerimiento);
		for (ImpactoDirecto item: registrosImpacto) {
			rPropuestaCambio.deleteById(item.getId_propuesta_cambio());
			rImpactoDirecto.deleteById(item.getId_impacto_directo());
		}
		List<RelacionRequerimientos> Relaciones_a = rRelacionRequerimiento.findAllByid_requerimiento_a(id_requerimiento);
		for (RelacionRequerimientos item: Relaciones_a) {
			rRelacionRequerimiento.deleteById(item.getId_relacionRequerimientos());
		}
		List<RelacionRequerimientos> Relaciones_b = rRelacionRequerimiento.findAllByid_requerimiento_b(id_requerimiento);
		for (RelacionRequerimientos item: Relaciones_b) {
			rRelacionRequerimiento.deleteById(item.getId_relacionRequerimientos());
		}
		UsuarioActividad UsuariosActividades = rUsuarioActividad.findAllByIdRequerimiento(id_requerimiento);
		System.out.println(UsuariosActividades.getId_usuarioActividad());
		rUsuarioActividad.deleteById(UsuariosActividades.getId_usuarioActividad());
		
		data.deleteById(id_requerimiento);
		return id_requerimiento;
	}
}
