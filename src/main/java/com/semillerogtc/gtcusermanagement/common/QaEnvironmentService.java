package com.semillerogtc.gtcusermanagement.common;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
//@Profile("qa")
public class QaEnvironmentService implements EnvironmentService{
    @Override
    public String getEnvironmentName(){
        return "ambiente qa";
    }

    @Override
    public String obtenerPoliticaDeClaveDeUsuario(){
        return "[0-9{1}A-Za-z]";
    }
}