package com.semillerogtc.gtcusermanagement.domain.components;

import org.springframework.stereotype.Component;
import com.semillerogtc.gtcusermanagement.domain.Usuario;

@Component
public class UsersValidation {
    public boolean excecute(Usuario user){
        if(!(user.getName().equals("Jeff")))
            return false;
        return true;
    }

//    public boolean excecute(String user){
//        if(!(user=="Jeff"))
//            return false;
//        return true;
//    }
}