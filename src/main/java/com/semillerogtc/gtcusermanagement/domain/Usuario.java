package com.semillerogtc.gtcusermanagement.domain;

import lombok.Builder;

//import lombok.Data;
//import lombok.Getter;

//@Data
//@Getter
@Builder
public class Usuario {
    public int id;
    public String name;
    public Integer edad;
    private String fechaNacimiento;
    public String email;

    public String getFechaNacimiento(){
        return this.fechaNacimiento;
    } 

    public Usuario setFechaNacimiento(String fechaNacimiento){
        this.fechaNacimiento=fechaNacimiento;
        return this;
    }


}