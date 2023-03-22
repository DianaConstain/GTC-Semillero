package com.semillerogtc.gtcusermanagement.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;
//import lombok.Builder;
import lombok.Data;
//import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotEmpty;

//@Getter
@Data
//@Builder
@Entity
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID",strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @NotEmpty(message="El parametro name es obligatorio")
    private String name;
    private int edad;
    //private String fechaNacimiento;
    private String email;
    private long celular;

    /* public String getFechaNacimiento(){
        return this.fechaNacimiento;
    } 

    public Usuario setFechaNacimiento(String fechaNacimiento){
        this.fechaNacimiento=fechaNacimiento;
        return this;
    } */
}