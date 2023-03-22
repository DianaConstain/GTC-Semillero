package com.semillerogtc.gtcusermanagement.domain.components;

import org.springframework.stereotype.Component;
//import com.semillerogtc.gtcusermanagement.domain.Usuario;

import com.semillerogtc.gtcusermanagement.domain.UsuarioDto;

@Component
public class UsersValidation {
    public boolean excecute(UsuarioDto user){
        return user.email.equals("cortesj3f");
    }
    //Se puede validar más que el email, es la estructura del email, que tenga un formato correcto
    
    /* public boolean excecute(String user){
        if(!(user.equals("Jeff")))
            return false;
        return true;
    } */
    /* public boolean excecute(Usuario user){
        //if(!(user.getName().equals("Jeff")))
        if(!(user.getEmail().equals("Jeff")))
            return false;
        return true;
    } */

//    public boolean excecute(String user){
//        if(!(user=="Jeff"))
//            return false;
//        return true;
//    }
}