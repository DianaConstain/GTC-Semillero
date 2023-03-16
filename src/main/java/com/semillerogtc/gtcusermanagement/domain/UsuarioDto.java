package com.semillerogtc.gtcusermanagement.domain;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UsuarioDto {
    @NotEmpty(message="El email no puede ser vacío")
    @NotNull(message="El email es requerido")
    public String email;
    @NotEmpty(message="El usuario no puede ser vacío")
    @NotNull(message="El usuario es requerido")
    public String userId;

    public UsuarioDto() {
    }
}