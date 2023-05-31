package com.alura.foro.domain.respuestas;

import com.alura.foro.domain.topicos.DatosListadoTopico;
import com.alura.foro.domain.topicos.Topico;
import com.alura.foro.domain.usuarios.Usuario;

import java.util.Date;

public record DatosListadoRespuesta(String mensaje, DatosListadoTopico topico, Date fechaCreacion, String usuario, Boolean solucion) {
    public DatosListadoRespuesta(Respuesta respuesta){
        this(respuesta.getMensaje(), new DatosListadoTopico(respuesta.topico), respuesta.getFechaCreacion(), respuesta.getUsuario().getNombre(), respuesta.getSolucion());
    }
}
