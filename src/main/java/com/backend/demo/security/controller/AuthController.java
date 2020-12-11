package com.backend.demo.security.controller;

import com.backend.demo.dto.Mensaje;
import com.backend.demo.repositorio.RUsuarioActividad;
import com.backend.demo.security.dto.JwtDto;
import com.backend.demo.security.dto.LoginUsuario;
import com.backend.demo.security.dto.NuevoUsuario;
import com.backend.demo.security.entity.Rol;
import com.backend.demo.security.entity.Usuario;
import com.backend.demo.security.enums.RolNombre;
import com.backend.demo.security.jwt.JwtProvider;
import com.backend.demo.security.repository.UsuarioRepository;
import com.backend.demo.security.service.RolService;
import com.backend.demo.security.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    RolService rolService;

    @Autowired
    JwtProvider jwtProvider;
    
    @Autowired
	private UsuarioRepository rUsuario;
    
    
    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult){
    	
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("campos mal puestos o email inválido"), HttpStatus.BAD_REQUEST);
        if(usuarioService.existsByEmail(nuevoUsuario.getEmail()))
            return new ResponseEntity(new Mensaje("ese email ya existe"), HttpStatus.BAD_REQUEST);
      
     
        Usuario usuario =
                new Usuario(nuevoUsuario.getNombre(), nuevoUsuario.getEmail(), nuevoUsuario.getEstado(),
                        nuevoUsuario.getTipo(),passwordEncoder.encode(nuevoUsuario.getPassword()));
        Set<Rol> roles = new HashSet<>();
        
        if(!nuevoUsuario.getRoles().contains("cliente")) {
        	roles.add(rolService.getByRolNombre(RolNombre.ROLE_ANALISTA).get());
        	if(nuevoUsuario.getRoles().contains("lider") || nuevoUsuario.getRoles().contains("jefe") || nuevoUsuario.getRoles().contains("admin")) {
        		roles.add(rolService.getByRolNombre(RolNombre.ROLE_LIDER_SUBPROYECTO).get());
        		if(nuevoUsuario.getRoles().contains("jefe") || nuevoUsuario.getRoles().contains("admin") ) {
        			roles.add(rolService.getByRolNombre(RolNombre.ROLE_JEFE_PROYECTO).get());
        			if(nuevoUsuario.getRoles().contains("admin")) {
        				roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
        				roles.add(rolService.getByRolNombre(RolNombre.ROLE_CLIENTE).get());
        			}
        		}
        	}
        }
        else
        	roles.add(rolService.getByRolNombre(RolNombre.ROLE_CLIENTE).get());
        
        /**roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
        if(nuevoUsuario.getRoles().contains("admin"))
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());**/
        
        usuario.setRoles(roles);
        usuarioService.save(usuario);
        return new ResponseEntity(new Mensaje("usuario guardado"), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
    	Usuario usuario = rUsuario.findByEmail(loginUsuario.getEmail()).get();
    	if(usuario.getEstado().equals("Activo")) {
    		if(bindingResult.hasErrors())
                return new ResponseEntity(new Mensaje("campos mal puestos"), HttpStatus.BAD_REQUEST);
            Authentication authentication =
                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getEmail(), loginUsuario.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtProvider.generateToken(authentication);
            UserDetails userDetails = (UserDetails)authentication.getPrincipal();
            JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
            return new ResponseEntity(jwtDto, HttpStatus.OK);
    	}
    	return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        
    }
    
    /*@PostMapping("/cambiarRol")
    public ResponseEntity<?> CambiarRol(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult){
    	Usuario usuario =
                new Usuario(nuevoUsuario.getNombre(), nuevoUsuario.getEmail(), nuevoUsuario.getEstado(),
                        nuevoUsuario.getTipo(),passwordEncoder.encode(nuevoUsuario.getPassword()));
        
    	Set<Rol> roles = new HashSet<>();
        if(!nuevoUsuario.getRoles().contains("cliente")) {
        	roles.add(rolService.getByRolNombre(RolNombre.ROLE_ANALISTA).get());
        	if(nuevoUsuario.getRoles().contains("lider") || nuevoUsuario.getRoles().contains("jefe") || nuevoUsuario.getRoles().contains("admin")) {
        		roles.add(rolService.getByRolNombre(RolNombre.ROLE_LIDER_SUBPROYECTO).get());
        		if(nuevoUsuario.getRoles().contains("jefe") || nuevoUsuario.getRoles().contains("admin") ) {
        			roles.add(rolService.getByRolNombre(RolNombre.ROLE_JEFE_PROYECTO).get());
        			if(nuevoUsuario.getRoles().contains("admin")) {
        				roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
        				roles.add(rolService.getByRolNombre(RolNombre.ROLE_CLIENTE).get());
        			}
        		}
        	}
        }
        else
        	roles.add(rolService.getByRolNombre(RolNombre.ROLE_CLIENTE).get());
        
        usuario.setRoles(roles);
        usuarioService.save(usuario);
        return new ResponseEntity(new Mensaje("usuario guardado"), HttpStatus.CREATED);
    }*/
}
