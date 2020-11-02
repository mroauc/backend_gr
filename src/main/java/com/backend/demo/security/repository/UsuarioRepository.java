package com.backend.demo.security.repository;

import com.backend.demo.security.entity.Usuario;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
    Optional<Usuario> findByEmail(String email);
    boolean existsByEmail(String email);
    @Query("SELECT u FROM Usuario u WHERE u.tipo = :tipo")
    public List<Usuario> getUsuarioByTipo(@Param("tipo") String tipo);
    @Query("SELECT u FROM Usuario u WHERE u.id = :id")
    public Optional<Usuario> getUsuarioById(@Param("id") String id);
}
