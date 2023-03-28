package com.semillerogtc.gtcusermanagement.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//import com.semillerogtc.gtcusermanagement.domain.components.Telefono;
import lombok.Data;

@Entity
@Data
@Table(name = "usuarios_telefonos")
public class Telefonos {
    @Id
    //@Column(name = "id",nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column
    private String telefono;  
    //Telefono telefono;
    
    //@ManyToOne(targetEntity = Usuario.class)
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
