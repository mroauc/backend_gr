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

import com.backend.demo.modelo.ConfiguracionRequerimiento;
import com.backend.demo.repositorio.RConfiguracionRequerimiento;

@RestController
@RequestMapping("api/configReq")
@CrossOrigin("*")
public class ConfiguracionRequerimientoController {

	@Autowired
	private RConfiguracionRequerimiento data;
	
	@GetMapping("/")
	private List<ConfiguracionRequerimiento> index(){
		return (List<ConfiguracionRequerimiento>) data.findAll();
	}
	
	@GetMapping("/{id_config}")
	public Optional<ConfiguracionRequerimiento> getConfig(@PathVariable Integer id_config){
		return data.findById(id_config);
	}
	
	@PostMapping("/guardar")
	public ConfiguracionRequerimiento guardar(@RequestBody ConfiguracionRequerimiento config) {
		return data.save(config);
	}
	
	@DeleteMapping("/eliminar/{id_config}")
	public Integer eliminar(@PathVariable Integer id_config) {
		data.deleteById(id_config);
		return id_config;
	}
	
	@PostMapping("/editar")
	public ConfiguracionRequerimiento editar(@RequestBody ConfiguracionRequerimiento config) {
		return data.save(config);
	}
	
	@GetMapping("/obtener/{id_usuario}")
	public Optional<ConfiguracionRequerimiento> getConfigUser(@PathVariable Integer id_usuario){
		return data.getConfigUsuario(id_usuario);
	}
}
