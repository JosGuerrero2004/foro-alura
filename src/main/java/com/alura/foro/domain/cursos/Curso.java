package com.alura.foro.domain.cursos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "cursos")
@Entity(name = "Curso")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String categoria;

    public Curso(DatosCurso curso) {
        this.id = curso.id();
        this.nombre = curso.nombre();
        this.categoria = curso.categoria();
    }

    public Curso(String nombre) {
        this.nombre = nombre;
    }

    public Curso actualizarDatos(Curso curso) {
        this.id = curso.id;
        this.nombre = curso.nombre;
        this.categoria = curso.categoria;
        return this;
    }
}
