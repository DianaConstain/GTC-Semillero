package com.semillerogtc.gtcusermanagement.common;

import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

@Service
@Profile("prod")
@PropertySource("classpath:applicationprod.properties")
public class ProdEnvironmentService implements EnvironmentService{
    @Value("${environment.name:0}") 
    String nombre;
    @Override
    public String getEnvironmentName(){
        return nombre;
    }

    @Override
    public String obtenerPoliticaDeClaveDeUsuario(){
        return "[0-9{1}A-Z{1}a-z]";
    }
}