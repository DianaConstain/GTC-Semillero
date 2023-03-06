package com.semillerogtc.gtcusermanagement.services;

import org.springframework.stereotype.Service;
import com.semillerogtc.gtcusermanagement.components.UsersValidation;
import com.semillerogtc.gtcusermanagement.domain.Usuario;

@Service
public class UsersService {
    UsersValidation _usersValidation;

    UsersService(UsersValidation usersValidation){
        _usersValidation=usersValidation;
    }

    public boolean registrarUsuario(Usuario user){
        boolean resultado=_usersValidation.excecute(user);
        return resultado;
    }

//    public boolean registrarUsuario(String user){
//        boolean resultado=_usersValidation.excecute(user);
//        return resultado;
//    }

    public String consultarUsuario(){
        return "true";
    }
}