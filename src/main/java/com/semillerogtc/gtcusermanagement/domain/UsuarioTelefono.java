package com.semillerogtc.gtcusermanagement.domain;

//import javax.persistence.CascadeType;
//import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;
//import lombok.Data;

@Entity
//@Data
@Table(name = "usuarios_telefonos")
public class UsuarioTelefono {
    @Id
    //@Column(name = "id",nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Convert(converter = TelefonoAttributeConverter.class)
    private Telefono telefono;

    public String getTelefono(){return telefono.getValue();}
    public void setTelefono(String telefono){this.telefono=new Telefono(telefono);}

    /* //@ManyToOne(targetEntity = Usuario.class)
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "usuario_id")
    private Usuario usuario; */
}
