package com.semillerogtc.gtcusermanagement.common.beans;

import com.semillerogtc.gtcusermanagement.common.ProdEnvironmentService;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

//@Configuration
public class EnvironmentConfig{
    //@Bean
    public ProdEnvironmentService getEnvironmentService(){
        return new ProdEnvironmentService();
    }
}