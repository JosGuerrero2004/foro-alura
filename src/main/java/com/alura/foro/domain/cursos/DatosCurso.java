package com.alura.foro.domain.cursos;

import jakarta.validation.constraints.NotBlank;

public record DatosCurso(
    @NotBlank
    Long id,
    @NotBlank
    String nombre,
    @NotBlank
    String categoria
) {
}
