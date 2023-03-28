package com.semillerogtc.gtcusermanagement.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
//import lombok.Builder;
import lombok.Data;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
import javax.validation.constraints.NotEmpty;
//import java.util.List;
import java.util.Set;
//import javax.persistence.Column;
//import javax.persistence.Convert;

//@Getter
@Data
//@Builder
@Entity
@Table(name = "usuarios")
//@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID",strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @NotEmpty(message="El nombre es obligatorio")
    private String name;
    @NotEmpty(message="El email es obligatorio")
    private String email;
    private Integer edad;

    //@OneToMany(targetEntity = Telefonos.class)
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "usuario_id",referencedColumnName = "id")
    Set<UsuarioTelefono> telefonos;

    //List<Telefonos> telefonos;
    //@Column
    //@Convert(converter = Telefono.class)
    
    //private long celular;
    //private String fechaNacimiento;

    /* public String getFechaNacimiento(){
        return this.fechaNacimiento;
    } 

    public Usuario setFechaNacimiento(String fechaNacimiento){
        this.fechaNacimiento=fechaNacimiento;
        return this;
    } */
}