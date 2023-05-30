package com.alura.foro.domain.topicos;

import com.alura.foro.domain.cursos.DatosCurso;
import com.alura.foro.domain.usuarios.DatosUsuario;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        EstadoTopico estadoTopico,
        @NotNull
        @Valid
        DatosUsuario usuario,
        @NotNull
        @Valid
        DatosCurso curso
) {
}
