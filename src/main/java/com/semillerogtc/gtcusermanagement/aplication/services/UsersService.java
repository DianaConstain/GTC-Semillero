package com.semillerogtc.gtcusermanagement.aplication.services;

import org.springframework.stereotype.Service;
import com.semillerogtc.gtcusermanagement.domain.Usuario;
import com.semillerogtc.gtcusermanagement.domain.UsuarioDto;
import com.semillerogtc.gtcusermanagement.domain.UsuariosRepositorio;
import com.semillerogtc.gtcusermanagement.domain.components.UsersValidation;

@Service
public class UsersService {
    UsersValidation _usersValidation;
    UsuariosRepositorio usuariosRepositorio;

    /* UsersService(UsersValidation usersValidation){
        _usersValidation=usersValidation;
    } */
    UsersService(UsersValidation usersValidation,UsuariosRepositorio usuariosRepositorio){
        this.usuariosRepositorio=usuariosRepositorio;
        _usersValidation=usersValidation;
    }

    public Usuario registrarUsuario(UsuarioDto usuarioDto){
        boolean resultado=_usersValidation.excecute(usuarioDto);    
        
        Usuario usuarioARegistrar=new Usuario();

        usuarioARegistrar.setEmail(usuarioDto.email);
        usuarioARegistrar.setEdad(usuarioDto.edad);
        usuarioARegistrar.setCelular(usuarioDto.celular);
        usuarioARegistrar.setName(usuarioDto.nombre);      

        var usuarioRegistrado=this.usuariosRepositorio.save(usuarioARegistrar);
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

    public void eliminarUsuario(String userId){
        this.usuariosRepositorio.deleteById(userId);
    } 

    public String consultarUsuario(){
        return "true";
    }
}