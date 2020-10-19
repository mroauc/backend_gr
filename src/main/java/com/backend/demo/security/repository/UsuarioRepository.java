package com.backend.demo.security.repository;

import com.backend.demo.security.entity.Usuario;
/**import org.springframework.data.jpa.repository.JpaRepository;**/
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
    Optional<Usuario> findByEmail(String email);
    boolean existsByEmail(String email);

}
