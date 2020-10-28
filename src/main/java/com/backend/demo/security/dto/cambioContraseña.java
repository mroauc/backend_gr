package com.backend.demo.security.dto;

import javax.validation.constraints.NotBlank;

public class cambioContraseña {
	@NotBlank
    private Integer id_usuario;
	@NotBlank
    private String actual;
	@NotBlank
    private String nueva;
    @NotBlank
    private String nueva2;
    
    
	public Integer getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getActual() {
		return actual;
	}
	public void setActual(String actual) {
		this.actual = actual;
	}
	public String getNueva() {
		return nueva;
	}
	public void setNueva(String nueva) {
		this.nueva = nueva;
	}
	public String getNueva2() {
		return nueva2;
	}
	public void setNueva2(String nueva2) {
		this.nueva2 = nueva2;
	}
    
    
    

}
