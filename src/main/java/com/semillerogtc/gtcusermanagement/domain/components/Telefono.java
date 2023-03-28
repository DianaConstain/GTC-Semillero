package com.semillerogtc.gtcusermanagement.domain.components;

public class Telefono {
    private String value;
    private Telefono(String telefono){
        this.value=telefono;
    }

    public String getValue(){
        return this.value;
    }

    public static Telefono instance(String telefono){
        return new Telefono(telefono);
    }
}
