package com.semillerogtc.gtcusermanagement.common;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
//@Profile("dev")
public class DevEnvironmentService implements EnvironmentService{
    @Override
    public String getEnvironmentName(){
        return "ambiente dev";
    }

    @Override
    public String obtenerPoliticaDeClaveDeUsuario(){
        return "[0-9A-Za-z]";
    }
}