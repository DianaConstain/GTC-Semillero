package com.semillerogtc.gtcusermanagement.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.semillerogtc.gtcusermanagement.services.UsersService;

import lombok.var;

import com.semillerogtc.gtcusermanagement.domain.Usuario;
import com.semillerogtc.gtcusermanagement.domain.UsuarioDto;
import com.semillerogtc.gtcusermanagement.domain.UsuarioDto2;
import com.semillerogtc.gtcusermanagement.common.EnvironmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestParam;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;

import org.slf4j.Logger;

@RestController
@RequestMapping("/usuarios")

public class UsersController {
    @Autowired
    UsersService _user;

    //@Autowired
    //@Qualifier("devEnvironmentService")
    EnvironmentService _environmentService1;

    //@Autowired
    //@Qualifier("devEnvironmentService")
    //EnvironmentService _environmentService2;

    public final Logger logger=LoggerFactory.getLogger(UsersController.class);

    UsersController(){
        //logger.info("Se inicializa constructor");
    }

    @GetMapping("/ping")
    public String ping(@RequestHeader(HttpHeaders.AUTHORIZATION) String token){
        logger.info("Token: "+ token);

        //logger.info("Ambiente configurado: "+ _environmentService1.getEnvironmentName());
        //logger.info("Ambiente configurado: "+ _environmentService2.getEnvironmentName());
        //var sonIguales=_environmentService1==_environmentService2;
        //logger.info("Son iguales las dependencias? " + sonIguales);
        return "Hola desde controlador usuarios";
    }
    //Header
    @GetMapping
    public boolean consultarUsuarioPorHeader(@RequestHeader(HttpHeaders.AUTHORIZATION) String token,@RequestHeader("") String userId){
        logger.info("token y userId: "+ token + " - "+userId);
        Usuario user=new Usuario();
        user.name="Jeffrey";
        return _user.registrarUsuario(user);
    }
    //Query String
    @GetMapping("/query")
    public boolean consultarUsuarioPorQueryString(@RequestParam String email,@RequestParam String userId){
        logger.info("email y userId: "+ email + " - "+userId);
        Usuario user=new Usuario();
        user.name="Jeffrey";
        return _user.registrarUsuario(user);
    }
    //Uri Template
    @GetMapping("/uritemplate/{email}/{id}")
    public boolean consultarUsuarioPorPathUriTemplate(@PathVariable("email") String email,@PathVariable("id") String userId){
        logger.info("email y userId: "+ email + " - "+userId);
        Usuario user=new Usuario();
        user.name="Jeffrey";
        return _user.registrarUsuario(user);
    }

    @PostMapping("v1/{token}")
//    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity registrarUsuario(@PathVariable String token,@Valid @RequestBody UsuarioDto usuarioDto) throws Exception{
        logger.info("email y userId: "+ usuarioDto.email + " - "+usuarioDto.userId );
        Usuario user=new Usuario();
        user.name=token;
        var esRegistroExitoso=_user.registrarUsuario(user);
        if(!esRegistroExitoso)
            return new ResponseEntity("Falló la creación de usuario", HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity("Usuario creado exitosamente", HttpStatus.CREATED);
        //Usuario user=new Usuario();
        //user.name="Jeffrey";
        //throw new Exception("Error al crear usuario");
        //return _user.registrarUsuario(user);
//        String user="Jeffrey";
//        return _user.registrarUsuario(user);
    }
    @PostMapping("v2/{token}")
    public String registrarUsuario2(@Valid @RequestBody UsuarioDto2 usuarioDto2) throws Exception{
        logger.info("email y userId: "+ usuarioDto2.email + " - "+usuarioDto2.userId );
        Usuario user=new Usuario();
        user.name="Jeffrey";
        return "Hola desde método POST Version 2";
    }

    @PatchMapping("/{id}")
    public UsuarioDto actualizarUsuario(@RequestBody UsuarioDto usuarioDto){
        return usuarioDto;
        //Usuario user=new Usuario();
        //user.name="Jeffrey";
        //return _user.registrarUsuario(user);
    }

    @DeleteMapping
    public boolean eliminarUsuario(){
        Usuario user=new Usuario();
        user.name="Jeffrey";
        return _user.registrarUsuario(user);
    }
}
