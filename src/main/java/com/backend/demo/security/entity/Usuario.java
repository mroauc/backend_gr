package com.backend.demo.security.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String nombre;
    @NotNull
    @Column(unique = true)
    private String email;
    @NotNull
    private String estado;
    @NotNull
    private String tipo;
    @NotNull
    private String color_vistaDrag;
    @NotNull
    private String color_backgr;
    @NotNull
    private String password;
    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "usuario_id"),
    inverseJoinColumns = @JoinColumn(name = "rol_id"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Rol> roles = new HashSet<>();

    public Usuario() {
    }

    public Usuario(@NotNull String nombre, @NotNull String email, @NotNull String estado, @NotNull String tipo, @NotNull String color_vistaDrag, @NotNull String color_backgr, @NotNull String password) {
        this.nombre = nombre;
        this.email = email;
        this.estado = estado;
        this.tipo = tipo;
        this.color_vistaDrag = color_vistaDrag;
        this.color_backgr = color_backgr;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }
}
