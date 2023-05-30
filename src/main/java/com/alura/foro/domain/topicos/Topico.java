package com.alura.foro.domain.topicos;

import com.alura.foro.domain.cursos.Curso;
import com.alura.foro.domain.usuarios.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    @Column(name = "fecha_creacion")
    private Date fechaCreacion = new Date();
    @Column(name = "estado")
    @Enumerated(EnumType.STRING)
    EstadoTopico estadoTopico;
    @ManyToOne
    @JoinColumn(name = "autor")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "curso")
    private Curso curso;

    public Topico(DatosRegistroTopico datosRegistroTopico) {
        this.titulo = datosRegistroTopico.titulo();
        this.mensaje = datosRegistroTopico.mensaje();
        this.estadoTopico = datosRegistroTopico.estadoTopico();
        this.usuario = new Usuario(datosRegistroTopico.usuario());
        this.curso = new Curso(datosRegistroTopico.curso());
    }

    public void actualizarDatos(DatosActualizarTopico datosActualizarTopico) {
        if(datosActualizarTopico.titulo() != null){
            this.titulo = datosActualizarTopico.titulo();
        }
        if(datosActualizarTopico.mensaje() != null){
            this.mensaje = datosActualizarTopico.mensaje();
        }
        if(datosActualizarTopico.estadoTopico()!= null){
            this.estadoTopico = datosActualizarTopico.estadoTopico();
        }
        if(datosActualizarTopico.usuario()!= null){
            this.usuario = datosActualizarTopico.usuario();
        }
        if(datosActualizarTopico.curso()!= null){
            this.curso = datosActualizarTopico.curso();
        }
    }
}
