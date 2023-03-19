package com.semillerogtc.gtcusermanagement.common.beans;

//import org.springframework.context.annotation.Configuration;
import com.semillerogtc.gtcusermanagement.infraestructure.controllers.ProdEnvironmentService;
//import org.springframework.context.annotation.Bean;

//@Configuration
public class EnvironmentConfig{
    //@Bean
    public ProdEnvironmentService getEnvironmentService(){
        return new ProdEnvironmentService();
    }
}