package com.semillerogtc.gtcusermanagement.aplication.services;

import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Service;
//import com.semillerogtc.gtcusermanagement.domain.Telefono;
import com.semillerogtc.gtcusermanagement.domain.UsuarioTelefono;
import com.semillerogtc.gtcusermanagement.domain.Email;
import com.semillerogtc.gtcusermanagement.domain.Usuario;
import com.semillerogtc.gtcusermanagement.domain.UsuarioNuevoDto;
import com.semillerogtc.gtcusermanagement.domain.UsuariosRepositorio;
import com.semillerogtc.gtcusermanagement.domain.components.UsersValidation;
import com.semillerogtc.gtcusermanagement.domain.components.PasswordEncoderService;


@Service
public class UsersService {
    UsersValidation _usersValidation;
    UsuariosRepositorio usuariosRepositorio;
    PasswordEncoderService _passwordEncoderService;

    /* UsersService(UsersValidation usersValidation){
        _usersValidation=usersValidation;
    } */
    /* UsersService(UsersValidation usersValidation,UsuariosRepositorio usuariosRepositorio){
        this.usuariosRepositorio=usuariosRepositorio;
        _usersValidation=usersValidation;
    } */
    UsersService(UsersValidation usersValidation, UsuariosRepositorio usuariosRepositorio,
            PasswordEncoderService passwordEncoderService) {
        this.usuariosRepositorio = usuariosRepositorio;
        _usersValidation = usersValidation;
        this._passwordEncoderService = passwordEncoderService;
    }

    public Usuario registrarUsuario(UsuarioNuevoDto usuarioNuevoDto){
        boolean resultado=_usersValidation.excecute(usuarioNuevoDto);
        var pass = this.generarPassword();

        var passEncriptado1 = this._passwordEncoderService.encode(pass);
        var passEncriptado2 = this._passwordEncoderService.encode("otro");
        var esPasswordIgual = this._passwordEncoderService.validarPassword(pass, passEncriptado1);
        var esPassword2Igual = this._passwordEncoderService.validarPassword(pass, passEncriptado2);
        System.out.println(esPasswordIgual); 
        
        Usuario usuarioNuevo=new Usuario();
        usuarioNuevo.setName(usuarioNuevoDto.nombre);  
        usuarioNuevo.setEmail(new Email(usuarioNuevoDto.email));
        usuarioNuevo.setEdad(usuarioNuevoDto.edad);
        
        UsuarioTelefono usuarioTelefono=new UsuarioTelefono();
        //telefono1.setTelefono(usuarioNuevoDto.telefonos.get(0));
        //var telefonoVO =Telefono.instance(usuarioNuevoDto.telefonos.get(0));
        usuarioTelefono.setTelefono(usuarioNuevoDto.telefonos.get(0));
        Set<UsuarioTelefono> telefonosSet=new HashSet<UsuarioTelefono>();
        telefonosSet.add(usuarioTelefono);
        //telefono1.setUsuario(usuarioARegistrar);
        //usuarioNuevo.setTelefonos(telefonosSet);
        usuarioNuevo.setTelefonos(telefonosSet);

        //usuarioARegistrar.setCelular(usuarioDto.celular);
        
        var usuarioRegistrado=this.usuariosRepositorio.save(usuarioNuevo);
        return usuarioRegistrado;
    } 

    /* public boolean registrarUsuario(Usuario user){
        /*Usuario usuarioARegistrar= Usuario.builder()
                                .email("cortes")
                                .edad(35)
                                .fechaNacimiento("1987-10-03")
                                .build();*/
        /*Usuario usuarioARegistrar=new Usuario();
        usuarioARegistrar.setEmail("cortesj3f");
        usuarioARegistrar.setEdad(34);
        boolean resultado=_usersValidation.excecute(usuarioARegistrar);
        this.usuariosRepositorio.save(usuarioARegistrar);
        return resultado;
    }  */

    /* public boolean registrarUsuario(Usuario user){
        boolean resultado=_usersValidation.excecute(user);
        return resultado;
    }  */

//    public boolean registrarUsuario(String user){
//        boolean resultado=_usersValidation.excecute(user);
//        return resultado;
//    }

    public String generarPassword() {
        return "clavesegura";
    }

    public void eliminarUsuario(String userId){
        this.usuariosRepositorio.deleteById(userId);
    } 

    public String consultarUsuario(){
        return "true";
    }
    public Usuario consultarUsuarioXEmail(String email){
        return this.usuariosRepositorio.findByEmail(new Email(email));
    }
}