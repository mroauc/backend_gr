package com.backend.demo.security.repository;

import com.backend.demo.security.entity.Rol;
import com.backend.demo.security.enums.RolNombre;
/**import org.springframework.data.jpa.repository.JpaRepository;**/
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends CrudRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
