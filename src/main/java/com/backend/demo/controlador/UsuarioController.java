package com.backend.demo.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.demo.security.dto.cambioContraseña;
import com.backend.demo.security.entity.Usuario;
import com.backend.demo.security.repository.UsuarioRepository;

@RestController
@RequestMapping("/api/usuario")
@CrossOrigin("*")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository data;
	@Autowired
    PasswordEncoder passwordEncoder;

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/")
	public List<Usuario> index(){
		return (List<Usuario>) data.findAll();
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_JEFE_PROYECTO')")
	@GetMapping("/{email}")
	public Optional<Usuario> getUsuario(@PathVariable String email){
		return data.findByEmail(email);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/eliminar/{id_usuario}")
	public Integer eliminarUsuario(@PathVariable Integer id_usuario) {
		data.deleteById(id_usuario);
		return id_usuario;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/editar")
	public Usuario editarUsuario(@RequestBody Usuario usuario) {
		return data.save(usuario);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_JEFE_PROYECTO')")
	@GetMapping("tipo/{tipo}")
	public List<Usuario> getUsuarioByTipo(@PathVariable String tipo){
		return data.getUsuarioByTipo(tipo);
	}
	
	@PostMapping("/pass")
	public ResponseEntity<String> cambiarContraseña(@RequestBody cambioContraseña cambioContraseña){

		Usuario usuario = data.findById(cambioContraseña.getId_usuario()).get();
		boolean Match = passwordEncoder.matches(cambioContraseña.getActual(), usuario.getPassword());
		
		if(Match) {
			usuario.setPassword(passwordEncoder.encode(cambioContraseña.getNueva()));
			data.save(usuario);
			return new ResponseEntity<>( "true" , HttpStatus.OK);
		}
		else
			return new ResponseEntity<>( "false" , HttpStatus.OK);	
	}
	
}