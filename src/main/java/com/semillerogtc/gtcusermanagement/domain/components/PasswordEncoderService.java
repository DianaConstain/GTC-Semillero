package com.semillerogtc.gtcusermanagement.domain.components;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordEncoderService {
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public PasswordEncoderService() {
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }

    public String encode(String password) {
        return bCryptPasswordEncoder.encode(password);
    }

    public boolean validarPassword(String password, String passwordEncriptado) {
        return bCryptPasswordEncoder.matches(password, passwordEncriptado);
    }
}
