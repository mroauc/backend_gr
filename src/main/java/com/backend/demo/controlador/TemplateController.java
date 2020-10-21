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

import com.backend.demo.modelo.Template;
import com.backend.demo.repositorio.RTemplate;

@RestController
@RequestMapping("api/template")
@CrossOrigin("*")
public class TemplateController {
	
	@Autowired
	private RTemplate data;
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/")
	public List<Template> index(){
		return (List<Template>) data.findAll();
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/{id_template}")
	public Optional<Template> getTemplate(@PathVariable Integer id_template){
		return data.findById(id_template);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/guardar")
	public Template guardarTemplate(@RequestBody Template template) {
		return data.save(template);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/eliminar/{id_template}")
	public Integer eliminarTemplate(@PathVariable Integer id_template) {
		data.deleteById(id_template);
		return id_template;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("editar")
	public Template editarTemplate(@RequestBody Template template) {
		return data.save(template);
	}
}