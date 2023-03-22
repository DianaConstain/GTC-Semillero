package com.semillerogtc.gtcusermanagement.domain;

import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;
import java.util.Date;
import lombok.Builder;

@Builder
public class UsuarioDto {
    public String nombre;
    @NotEmpty
    public String email;
    @NotEmpty
    public int edad;
    public long celular;
    public Date fechaNacimiento;
    
    /* @NotEmpty(message="El usuario no puede ser vacío")
    @NotNull(message="El usuario es requerido")
    public String userId; */

    //public UsuarioDto() {    }
}