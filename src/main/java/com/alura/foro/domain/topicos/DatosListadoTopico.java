package com.alura.foro.domain.topicos;

import java.util.Date;

public record DatosListadoTopico(String titulo, String mensaje, Date fechaCreacion, String estado, String usuario, String curso) {
    public DatosListadoTopico(Topico topico) {
        this(topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(), topico.getEstadoTopico().toString(), topico.getUsuario().getNombre(), topico.getCurso().getNombre());
    }
}
