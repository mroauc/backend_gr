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

import com.backend.demo.modelo.Comentario;
import com.backend.demo.modelo.EncargadoSubProyecto;
import com.backend.demo.modelo.Errores;
import com.backend.demo.modelo.PropuestaCambio;
import com.backend.demo.modelo.Proyecto;
import com.backend.demo.modelo.SubProyecto;
import com.backend.demo.modelo.UsuarioActividad;
import com.backend.demo.repositorio.RComentario;
import com.backend.demo.repositorio.REncargadoSubProyecto;
import com.backend.demo.repositorio.RErrores;
import com.backend.demo.repositorio.RPropuestaCambio;
import com.backend.demo.repositorio.RProyecto;
import com.backend.demo.repositorio.RSubProyecto;
import com.backend.demo.repositorio.RUsuarioActividad;
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
	@Autowired
	private RComentario rComentario;
	@Autowired
	private REncargadoSubProyecto rEncargadoSubProyecto;
	@Autowired
	private RUsuarioActividad rUsuarioActividad;
	@Autowired
	private RSubProyecto rSubProyecto;
	@Autowired
	private RProyecto rProyecto;
	@Autowired
	private RPropuestaCambio rPropuestadeCambio;
	@Autowired
	private RErrores rError;
	

	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CLIENTE','ROLE_ANALISTA')")
	@GetMapping("/")
	public List<Usuario> index(){
		return (List<Usuario>) data.findAll();
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_JEFE_PROYECTO','ROLE_CLIENTE','ROLE_ANALISTA')")
	@GetMapping("/{email}")
	public Optional<Usuario> getUsuario(@PathVariable String email){
		return data.findByEmail(email);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_JEFE_PROYECTO','ROLE_CLIENTE')")
	@GetMapping("/id/{id}")
	public Optional<Usuario> getUsuarioById(@PathVariable int id){
		return data.findById(id);
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
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_JEFE_PROYECTO','ROLE_CLIENTE')")
	@DeleteMapping("/eliminar/{id_usuario}")
	public Integer eliminarUsuario(@PathVariable Integer id_usuario) {
		List<Comentario> comentarios = rComentario.findAllByUsuario(id_usuario);
		for (Comentario item: comentarios) {
			item.setId_usuario(0);
			System.out.println(item);
		}
		List <EncargadoSubProyecto> cargos = rEncargadoSubProyecto.findAllByid_usuario(id_usuario);
		for (EncargadoSubProyecto item: cargos) {
			rEncargadoSubProyecto.deleteById(item.getId_encargadoSubProyecto());
		}
		List <UsuarioActividad> regActividad = rUsuarioActividad.findAllByIdUsuario(id_usuario);
		for (UsuarioActividad item: regActividad) {
			item.setId_usuario(0);
		}
		List <SubProyecto> SubProyectos = rSubProyecto.findByid_usuario(id_usuario);
		for (SubProyecto item: SubProyectos) {
			item.setId_usuario(0);
		}
		List <Proyecto> Proyectos = rProyecto.findProyectosByid_usuario(id_usuario);
		for (Proyecto item: Proyectos) {
			item.setId_usuario(0);
		}
		List <PropuestaCambio> Propuestas = rPropuestadeCambio.findByid_usuario(id_usuario);
		for (PropuestaCambio item: Propuestas) {
			item.setId_usuario(0);
		}
		List <Errores> errores = rError.findAllByid_usuario(id_usuario);
		for (Errores item: errores) {
			item.setId_usuario(0);
		}
		data.deleteById(id_usuario);
		return id_usuario;
	}
	
}