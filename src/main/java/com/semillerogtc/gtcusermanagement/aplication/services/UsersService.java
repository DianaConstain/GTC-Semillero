package com.semillerogtc.gtcusermanagement.aplication.services;

import org.springframework.stereotype.Service;
import com.semillerogtc.gtcusermanagement.domain.Usuario;
import com.semillerogtc.gtcusermanagement.domain.components.UsersValidation;

@Service
public class UsersService {
    UsersValidation _usersValidation;

    UsersService(UsersValidation usersValidation){
        _usersValidation=usersValidation;
    }


    public boolean registrarUsuario(Usuario user){
        Usuario usuarioARegistrar= Usuario.builder()
                                .email("cortes")
                                .edad(35)
                                .fechaNacimiento("1987-10-03")
                                .build();
        boolean resultado=_usersValidation.excecute(usuarioARegistrar);
        return resultado;
    } 

    /* public boolean registrarUsuario(Usuario user){
        boolean resultado=_usersValidation.excecute(user);
        return resultado;
    }  */

//    public boolean registrarUsuario(String user){
//        boolean resultado=_usersValidation.excecute(user);
//        return resultado;
//    }

    public String consultarUsuario(){
        return "true";
    }
}