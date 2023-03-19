package com.semillerogtc.gtcusermanagement.domain;

import lombok.Builder;
import lombok.Data;
//import lombok.Getter;

//@Getter
@Builder
@Data
public class Usuario {
    private int id;
    private String name;
    private Integer edad;
    private String fechaNacimiento;
    private String email;

    /* public String getFechaNacimiento(){
        return this.fechaNacimiento;
    } 

    public Usuario setFechaNacimiento(String fechaNacimiento){
        this.fechaNacimiento=fechaNacimiento;
        return this;
    } */


}