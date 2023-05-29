package com.alura.foro.domain.topicos;

import com.alura.foro.domain.cursos.Curso;
import com.alura.foro.domain.usuarios.Usuario;

import java.util.Date;

public record DatosReturnTopico(Long id, String titulo, String mensaje, Date fechaCreacion, String EstadoTopico, Usuario usuario, Curso curso) {
}
