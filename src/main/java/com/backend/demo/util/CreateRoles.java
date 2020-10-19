package com.backend.demo.util;

import com.backend.demo.security.entity.Rol;
import com.backend.demo.security.enums.RolNombre;
import com.backend.demo.security.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


/**
 * MUY IMPORTANTE: ESTA CLASE SÓLO SE EJECUTARÁ UNA VEZ PARA CREAR LOS ROLES.
 * UNA VEZ CREADOS SE DEBERÁ ELIMINAR O BIEN COMENTAR EL CÓDIGO
 *
 */

@Component
public class CreateRoles implements CommandLineRunner {

    @Autowired
    RolService rolService;

    @Override
    public void run(String... args) throws Exception {
        /**Rol rolAdmin = new Rol(RolNombre.ROLE_ADMIN);
        Rol rolAnallista = new Rol(RolNombre.ROLE_ANALISTA);
        Rol rolCliente = new Rol(RolNombre.ROLE_CLIENTE);
        Rol rolJefeProyecto = new Rol(RolNombre.ROLE_JEFE_PROYECTO);
        Rol rolLiderSubproyecto = new Rol(RolNombre.ROLE_LIDER_SUBPROYECTO);
        
        rolService.save(rolAdmin);
        rolService.save(rolAnallista);
        rolService.save(rolCliente);
        rolService.save(rolJefeProyecto);
        rolService.save(rolLiderSubproyecto);
        **/
         
    }
}
