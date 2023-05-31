package com.alura.foro.domain.respuestas;

import com.alura.foro.domain.topicos.Topico;
import com.alura.foro.domain.usuarios.Usuario;
import com.alura.foro.domain.usuarios.UsuarioRepository;

public record DatosReturnRespuesta(Long id, String mensaje, String topico, String usuario) {
    public DatosReturnRespuesta(Respuesta respuesta) {
        this(respuesta.getId(), respuesta.getMensaje(), respuesta.getTopico().getTitulo(), respuesta.getUsuario().getNombre());
    }
}
