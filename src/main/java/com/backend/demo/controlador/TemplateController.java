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

import com.backend.demo.modelo.Template;
import com.backend.demo.repositorio.RTemplate;

@RestController
@RequestMapping("api/template")
@CrossOrigin("*")
public class TemplateController {
	
	@Autowired
	private RTemplate data;
	
	@GetMapping("/")
	public List<Template> index(){
		return (List<Template>) data.findAll();
	}
	
	@GetMapping("/{id_template}")
	public Optional<Template> getTemplate(@PathVariable Integer id_template){
		return data.findById(id_template);
	}
	
	@PostMapping("/guardar")
	public Template guardarTemplate(@RequestBody Template template) {
		return data.save(template);
	}
	
	@DeleteMapping("/eliminar/{id_template}")
	public Integer eliminarTemplate(@PathVariable Integer id_template) {
		data.deleteById(id_template);
		return id_template;
	}
	
	@PostMapping("editar")
	public Template editarTemplate(@RequestBody Template template) {
		return data.save(template);
	}
}
