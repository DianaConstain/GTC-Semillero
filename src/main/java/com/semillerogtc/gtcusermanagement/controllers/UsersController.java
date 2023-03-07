package com.semillerogtc.gtcusermanagement.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.semillerogtc.gtcusermanagement.services.UsersService;
import com.semillerogtc.gtcusermanagement.domain.Usuario;
import com.semillerogtc.gtcusermanagement.common.EnvironmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@RestController
@RequestMapping("/usuarios")

public class UsersController {
    @Autowired
    UsersService _user;

    @Autowired
    @Qualifier("devEnvironmentService")
    EnvironmentService _environmentService1;

    @Autowired
    @Qualifier("devEnvironmentService")
    EnvironmentService _environmentService2;

    public final Logger logger=LoggerFactory.getLogger(UsersController.class);

    UsersController(){
        logger.info("Se inicializa constructor");
    }

    @GetMapping("/ping")
    public String ping(){
        logger.info("Ambiente configurado: "+ _environmentService1.getEnvironmentName());
        logger.info("Ambiente configurado: "+ _environmentService2.getEnvironmentName());
        var sonIguales=_environmentService1==_environmentService2;
        logger.info("Son iguales las dependencias? " + sonIguales);
        return "Hola desde controlador usuarios";
    }

    @PostMapping()
    public boolean registrarUsuario(){
        Usuario user=new Usuario();
        user.name="Jeffrey";
        return _user.registrarUsuario(user);
//        String user="Jeffrey";
//        return _user.registrarUsuario(user);
    }
}
