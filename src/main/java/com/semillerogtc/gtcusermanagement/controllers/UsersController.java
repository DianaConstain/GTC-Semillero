package com.semillerogtc.gtcusermanagement.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.semillerogtc.gtcusermanagement.services.UsersService;
import com.semillerogtc.gtcusermanagement.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@RestController
@RequestMapping("/usuarios")

public class UsersController {
    @Autowired
    UsersService _user;
    public final Logger logger=LoggerFactory.getLogger(UsersController.class);

    UsersController(){logger.info("Se inicializa constructor");}

    @GetMapping("/ping")
    public String ping(){
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
