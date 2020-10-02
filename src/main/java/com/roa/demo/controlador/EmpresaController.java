package com.roa.demo.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import com.roa.demo.modelo.Empresa;
import com.roa.demo.repositorio.REmpresa;

@RestController
@RequestMapping("/api/empresa")
@CrossOrigin("*")

public class EmpresaController {
	
	@Autowired
	private REmpresa data;
	
	@GetMapping("/")
	public List<Empresa> listar(){
		return (List<Empresa>)data.findAll();
	}
	
	@GetMapping("/{id_empresa}")
	public Optional<Empresa> obtenerEmpresa(@PathVariable int id_empresa) {
		return data.findById(id_empresa);
	}
	
	@PostMapping("/guardarEmpresa")
	public Empresa guardarEmpresa(@RequestBody Empresa empresa) {
		return data.save(empresa);
	} 
	
	@DeleteMapping("/eliminar/{id_empresa}")
	public int eliminarEmpresa(@PathVariable int id_empresa){
		data.deleteById(id_empresa);
		return id_empresa;
	}
	
	@PostMapping("/editar")
	public Empresa editarEmpresa(@RequestBody Empresa empresa) {
		return data.save(empresa);
	}
	
	
}
