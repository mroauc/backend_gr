 package com.backend.demo.controlador;

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

import com.backend.demo.modelo.EncargadoSubProyecto;
import com.backend.demo.modelo.ImpactoDirecto;
import com.backend.demo.modelo.PropuestaCambio;
import com.backend.demo.modelo.Requerimiento;
import com.backend.demo.modelo.SubProyecto;
import com.backend.demo.repositorio.REncargadoSubProyecto;
import com.backend.demo.repositorio.RPropuestaCambio;
import com.backend.demo.repositorio.RRequerimiento;
//import com.backend.demo.modelo.UsuarioRol;
import com.backend.demo.repositorio.RSubProyecto;

@RestController
@RequestMapping("/api/subProyecto")
@CrossOrigin
public class SubProyectoController {
	
	@Autowired
	private RSubProyecto data;
	@Autowired
	private REncargadoSubProyecto rEncargadoSubProyecto;
	@Autowired
	private RPropuestaCambio rPropuestaCambio;
	@Autowired
	private RequerimientoController requerimientoC;
	
	@GetMapping("/")
	public List<SubProyecto> listar(){
		return (List<SubProyecto>)data.findAll();
	}
	
	@GetMapping("/{id_subProyecto}")
	public Optional<SubProyecto> obtenerSubProyecto(@PathVariable int id_subProyecto) {
		return data.findById(id_subProyecto);
	}
	
	@GetMapping("/pertenecientes/{id_proyecto}")
	public List<SubProyecto> listaSubProyectos(@PathVariable int id_proyecto){
		return data.findByid_proyecto(id_proyecto);
	}
	
	@PostMapping("/guardar")
	public SubProyecto guardarSubProyecto(@RequestBody SubProyecto subProyecto) {
		return data.save(subProyecto);
	} 
	
	@DeleteMapping("/eliminar/{id_subProyecto}")
	public int eliminarSubProyecto(@PathVariable int id_subProyecto){
		List<EncargadoSubProyecto> encargos = rEncargadoSubProyecto.findAllByid_subProyecto(id_subProyecto);
		for (EncargadoSubProyecto item: encargos) {
			rEncargadoSubProyecto.deleteById(item.getId_encargadoSubProyecto());
		}
		/*
		List<PropuestaCambio> propuestas = rPropuestaCambio.findByid_subproyecto(id_subProyecto);
		System.out.println(propuestas.get(0));
		for (PropuestaCambio item: propuestas) {
			rPropuestaCambio.deleteById(item.getId_propuestaCambio());
		}*/
		System.out.println("hola");
		List<Requerimiento> requerimientos = requerimientoC.obtener(id_subProyecto);
		for (Requerimiento item: requerimientos) {
			requerimientoC.eliminar(item.getId_requerimiento());
		}
		
		data.deleteById(id_subProyecto);
		return id_subProyecto;
	}
	
	@PostMapping("/editar")
	public SubProyecto editarSubProyecto(@RequestBody SubProyecto subProyecto) {
		return data.save(subProyecto);
	}
	
	//@GetMapping("/rol_usuario")
	//public List<UsuarioRol> obtenerUsuarioRoles() {
	//	return data.UsuariosRoles();
	//}
	
}
