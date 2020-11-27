package com.backend.demo.controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.loader.plan.spi.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.demo.modelo.Requerimiento;
import com.backend.demo.modelo.Seccion;
import com.backend.demo.repositorio.RSeccion;

@RestController
@RequestMapping("/api/seccion")
@CrossOrigin("*")
public class SeccionController {
	@Autowired
	private RSeccion data;
	
	@GetMapping("/")
	public List<Seccion> listar(){
		return (List<Seccion>) data.findAll();
	}
	
	@GetMapping("/{id_seccion}")
	public Optional<Seccion> obtenerSeccion(@PathVariable int id_seccion) {
		return data.findById(id_seccion);
	}
	
	@GetMapping("/id_proyecto/{id_proyecto}")
	public List<Seccion> obtenerSeccionesByProyecto(@PathVariable int id_proyecto) {
		List<Seccion> ListaSecciones = new ArrayList<Seccion>();
		ListaSecciones = data.findAllByid_proyecto(id_proyecto);
		return ListaSecciones;
	}
	
	@PostMapping("/guardar")
	public Seccion guardarSeccion(@RequestBody Seccion seccion) {
		return data.save(seccion);
	}
	
	@DeleteMapping("/eliminar/{id_seccion}")
	public int eliminarSeccion(@PathVariable int id_seccion){
		data.deleteById(id_seccion);
		return id_seccion;
	}
	
	@PostMapping("/editar")
	public Seccion editarSeccion(@RequestBody Seccion seccion) {
		return data.save(seccion);
	}
	
	
}
