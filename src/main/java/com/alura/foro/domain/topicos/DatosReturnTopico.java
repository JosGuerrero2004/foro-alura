package com.alura.foro.domain.topicos;

import java.util.Date;

public record DatosReturnTopico(Long id, String titulo, String mensaje, Date fechaCreacion, String EstadoTopico, String usuario, String curso) {
    public DatosReturnTopico(Topico topico) {
        this(topico.getId(),topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(), topico.getEstadoTopico().toString(), topico.getUsuario().getNombre(), topico.getCurso().getNombre());
    }
}
