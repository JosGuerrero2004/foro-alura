package com.alura.foro.domain.usuarios;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosUsuario(
        @NotNull
        Long id,
        @NotBlank
        String nombre,
        @NotBlank
        @Email
        String email
) {
}
