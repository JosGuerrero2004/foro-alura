package com.alura.foro.domain.respuestas;

import com.alura.foro.domain.topicos.Topico;
import com.alura.foro.domain.usuarios.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Table(name = "respuestas")
@Entity(name = "Respuestas")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensaje;
    @ManyToOne
    @JoinColumn(name = "topico")
    Topico topico;
    @Column(name = "fecha_creacion")
    private Date fechaCreacion = new Date();
    @ManyToOne
    @JoinColumn(name = "usuario")
    private Usuario usuario;
    private Boolean solucion = false;

    public Respuesta(DatosRegistroRespuesta datosRegistroRespuesta) {
        this.mensaje = datosRegistroRespuesta.mensaje();
        this.topico = datosRegistroRespuesta.topico();
        this.usuario = datosRegistroRespuesta.usuario();
    }

    public void actualizarDatos(DatosActualizarRespuesta datosActualizarRespuesta) {
        if (datosActualizarRespuesta.mensaje() != null){
            this.mensaje = datosActualizarRespuesta.mensaje();
        }
        if (datosActualizarRespuesta.topico() != null){
            this.topico = datosActualizarRespuesta.topico();
        }
        if(datosActualizarRespuesta.usuario() != null){
            this.usuario = datosActualizarRespuesta.usuario();
        }
        if (datosActualizarRespuesta.solucion() != null){
            this.solucion = datosActualizarRespuesta.solucion();
        }
    }
}
