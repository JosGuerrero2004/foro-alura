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
    EstadoTopico estado;
    @ManyToOne
    @JoinColumn(name = "autor")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "curso")
    private Curso curso;

    public Topico(DatosRegistroTopico datosRegistroTopico) {
        this.titulo = datosRegistroTopico.titulo();
        this.mensaje = datosRegistroTopico.mensaje();
        this.estado = datosRegistroTopico.estadoTopico();
        this.usuario = new Usuario(datosRegistroTopico.usuario());
        this.curso = new Curso(datosRegistroTopico.curso());
    }
}