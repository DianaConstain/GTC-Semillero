package com.semillerogtc.gtcusermanagement.domain;

import javax.validation.constraints.NotEmpty;

public class UsuarioDto2 {
    @NotEmpty(message="El email no puede ser vacío")
    public String email;
    @NotEmpty(message="El usuario no puede ser vacío")
    public String userId;
    @NotEmpty(message="El celular no puede ser vacío")
    public String celular;

    public UsuarioDto2() {
    }
}