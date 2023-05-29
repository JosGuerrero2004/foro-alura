package com.alura.foro.domain.usuarios;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DatosUsuario(
        @NotBlank
        Long id,
        @NotBlank
        String nombre,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String clave
) {
}
