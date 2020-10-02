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

import com.roa.demo.modelo.ProyectoEmpresa;
import com.roa.demo.repositorio.RProyectoEmpresa;

@RestController
@RequestMapping("/api/proyecto_empresa")
@CrossOrigin("*")
public class ProyectoEmpresaController {
	
	@Autowired
	private RProyectoEmpresa data;
	
	@GetMapping("/")
	public List<ProyectoEmpresa> listar(){
		return (List<ProyectoEmpresa>)data.findAll();
	}
	
	@GetMapping("/{id_proyecto_empresa}")
	public Optional<ProyectoEmpresa> obtenerProyectoEmpresa(@PathVariable int id_proyecto_empresa) {
		return data.findById(id_proyecto_empresa);
	}
	
	@PostMapping("/guardar")
	public ProyectoEmpresa guardarProyectoEmpresa(@RequestBody ProyectoEmpresa proyecto_empresa) {
		return data.save(proyecto_empresa);
	}
	
	@DeleteMapping("/eliminar/{id_proyecto_empresa}")
	public int eliminarProyectoEmpresa(@PathVariable int id_proyecto_empresa) {
		data.deleteById(id_proyecto_empresa);
		return id_proyecto_empresa;
	}
	
	@PostMapping("/editar")
	public ProyectoEmpresa editarProyectoEmpresa(@RequestBody ProyectoEmpresa proyecto_empresa) {
		return data.save(proyecto_empresa);
	}
	
	
}
