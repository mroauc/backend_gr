package com.backend.demo.security.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

public class NuevoUsuario {
    @NotBlank
    private String nombre;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String estado;
    @NotBlank
    private String tipo;
    @NotBlank
    private String color_vistaDrag;
    @NotBlank
    private String color_backgr;
    @NotBlank
    private String password;
    private Set<String> roles = new HashSet<>();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getColor_vistaDrag() {
		return color_vistaDrag;
	}
	
	public void setColor_vistaDrag(String color) {
		this.color_vistaDrag = color;
	}
	
	public String getColor_backgr() {
		return color_backgr;
	}
	
	public void setColor_backgr(String color_backgr) {
		this.color_backgr = color_backgr;
	}

	public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}
