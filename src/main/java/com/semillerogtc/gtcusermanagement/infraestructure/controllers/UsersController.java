package com.semillerogtc.gtcusermanagement.infraestructure.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.http.StreamingHttpOutputMessage.Body;
//import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
//import com.semillerogtc.gtcusermanagement.domain.Usuario;
import com.semillerogtc.gtcusermanagement.domain.UsuarioNuevoDto;
import com.semillerogtc.gtcusermanagement.domain.components.JWtManagerService;
//import com.semillerogtc.gtcusermanagement.domain.UsuarioDto2;
import com.semillerogtc.gtcusermanagement.aplication.services.UsersService;
import com.semillerogtc.gtcusermanagement.common.EnvironmentService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
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
    JWtManagerService jWtManagerService;

    //@Autowired
    //@Qualifier("devEnvironmentService")
    //EnvironmentService _environmentService2;

    public final Logger logger=LoggerFactory.getLogger(UsersController.class);

    /* UsersController(){
        //logger.info("Se inicializa constructor");
    } */
    UsersController(JWtManagerService jWtManagerService) {
        this.jWtManagerService = jWtManagerService;
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
    @GetMapping("/{email}")
    public ResponseEntity consultarUsuarioPorEmail(@PathVariable("email") String email){
        var usuario=_user.consultarUsuarioXEmail(email);        
        return new ResponseEntity( usuario,HttpStatus.OK);
    } 
    //Header
   @GetMapping("/header")
    public ResponseEntity consultarUsuarioPorHeader(@RequestHeader(HttpHeaders.AUTHORIZATION) String token,@RequestHeader("") String userId){
        logger.info("token y userId: "+ token + " - "+userId);
        //Usuario user=new Usuario(); user.name="Jeffrey";
        //Usuario user= Usuario.builder().name("Jeffrey").build();
        //Usuario user=new Usuario(); user.setName("Jeffrey");
        //return _user.registrarUsuario(user);
        UsuarioNuevoDto user=UsuarioNuevoDto.builder().email("Jeffrey").build();
        return new ResponseEntity( _user.registrarUsuario(user),HttpStatus.OK);
    } 
    //Query String
    @GetMapping("/query")
    public ResponseEntity consultarUsuarioPorQueryString(@RequestParam String email,@RequestParam String userId){
        logger.info("email y userId: "+ email + " - "+userId);
        //Usuario user=new Usuario(); user.name="Jeffrey";
        //Usuario user= Usuario.builder().name("Jeffrey").build();
        //Usuario user=new Usuario(); user.setName("Jeffrey");
        //return _user.registrarUsuario(user);
        UsuarioNuevoDto user=UsuarioNuevoDto.builder().email("cortes@gmail.com").build();
        return new ResponseEntity( _user.registrarUsuario(user),HttpStatus.OK);
    }
    //Uri Template
    @GetMapping("/uritemplate/{email}/{id}")
    public ResponseEntity consultarUsuarioPorPathUriTemplate(@PathVariable("email") String email,@PathVariable("id") String userId){
        logger.info("email y userId: "+ email + " - "+userId);
        //Usuario user=new Usuario(); user.name="Jeffrey";
        //Usuario user= Usuario.builder().name("Jeffrey").build();
        //Usuario user=new Usuario(); user.setName("Jeffrey");
        //return _user.registrarUsuario(user);
        UsuarioNuevoDto user=UsuarioNuevoDto.builder().email("Jeffrey").build();
        return new ResponseEntity( _user.registrarUsuario(user),HttpStatus.OK);
        
    }
    @PostMapping("v1")
    public ResponseEntity registrarUsuario(@Valid @RequestBody UsuarioNuevoDto usuarioDto){
        logger.info("email: "+ usuarioDto.email );
        var usuarioRegistrado=_user.registrarUsuario(usuarioDto);
        return new ResponseEntity(usuarioRegistrado, HttpStatus.CREATED);
    }
    /* @PostMapping("v1")
    public ResponseEntity registrarUsuario(@RequestBody UsuarioDto usuarioDto) throws Exception{
        logger.info("email y celular: "+ usuarioDto.email + " - "+usuarioDto.celular );
        try{
            var usuarioRegistrado=_user.registrarUsuario(usuarioDto);
            return new ResponseEntity(usuarioRegistrado, HttpStatus.CREATED);
        }catch(Exception ex){
            return new ResponseEntity("Falló la creación de usuario, Error: "+ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    } */

   /* @PostMapping("v1/{token}")
//    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity registrarUsuario(@PathVariable String token,@Valid @RequestBody UsuarioDto usuarioDto) throws Exception{
        logger.info("email y celular: "+ usuarioDto.email + " - "+usuarioDto.celular );
        //Usuario user=new Usuario();
        //Usuario user= Usuario.builder().name("Jeffrey").build();
        //Usuario user=new Usuario();
        //user.setName(token);
        UsuarioDto user=UsuarioDto.builder().email("cortes@gmail.com").build();
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
    }  */

    @PostMapping("v2")
    public ResponseEntity registrarUsuario2(@Valid @RequestBody UsuarioNuevoDto usuarioDto) throws Exception{
        var usuarioRegistrado=_user.registrarUsuario(usuarioDto);
        return new ResponseEntity(usuarioRegistrado, HttpStatus.CREATED);
    }
    /* @PostMapping("v2/{token}")
    public String registrarUsuario2(@Valid @RequestBody UsuarioDto2 usuarioDto2) throws Exception{
        logger.info("email y userId: "+ usuarioDto2.email + " - "+usuarioDto2.userId );
        //Usuario user=new Usuario(); user.name="Jeffrey";
        //Usuario user= Usuario.builder().name("Jeffrey").build();
        return "Hola desde método POST Version 2";
    } */

    @PostMapping("/login")
    public ResponseEntity login() {
        return new ResponseEntity(this.jWtManagerService.generate(), HttpStatus.OK);
    }

    @PostMapping("/auth")
    public ResponseEntity auth(@RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        try{
            var jwt = this.jWtManagerService.validate(token);
            return new ResponseEntity(jwt.toString(), HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity("Token epirado o no válido", HttpStatus.UNAUTHORIZED);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity actualizarUsuario(@RequestBody UsuarioNuevoDto usuarioDto){
        UsuarioNuevoDto user=UsuarioNuevoDto.builder().email("Jeffrey").build();
        return new ResponseEntity( _user.registrarUsuario(user),HttpStatus.OK);

    }
    /* @PatchMapping("/{id}")
    public UsuarioDto actualizarUsuario(@RequestBody UsuarioDto usuarioDto){
        return usuarioDto;
        //Usuario user=new Usuario();
        //user.name="Jeffrey";
        //return _user.registrarUsuario(user);
    } */

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarUsuario(@PathVariable String id){
        try{
            _user.eliminarUsuario(id);
            return new ResponseEntity( "Usuario eliminado con éxito",HttpStatus.OK);
        }catch(Exception ex){
            return new ResponseEntity(ex.getMessage(),HttpStatus.NO_CONTENT);
        }
    }
    /* @DeleteMapping
    public boolean eliminarUsuario(){
        //Usuario user=new Usuario(); user.name="Jeffrey";
        //Usuario user= Usuario.builder().name("Jeffrey").build();
        //Usuario user=new Usuario(); user.setName("Jeffrey");
        UsuarioDto user=UsuarioDto.builder().email("cortes@gmail.com").build();
        return _user.registrarUsuario(user);
    }  */
}
