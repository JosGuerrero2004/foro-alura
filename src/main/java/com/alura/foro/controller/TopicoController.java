package com.alura.foro.controller;

import com.alura.foro.domain.cursos.Curso;
import com.alura.foro.domain.topicos.DatosRegistroTopico;
import com.alura.foro.domain.topicos.DatosReturnTopico;
import com.alura.foro.domain.topicos.Topico;
import com.alura.foro.domain.topicos.TopicoRepository;
import com.alura.foro.domain.usuarios.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public ResponseEntity<DatosReturnTopico> registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico,
                                          UriComponentsBuilder uriComponentsBuilder){
        Topico topico = topicoRepository.save(new Topico(datosRegistroTopico));
        DatosReturnTopico returnTopico = new DatosReturnTopico(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(), topico.getEstado().toString(),
                new Usuario(topico.getUsuario().getId(), topico.getUsuario().getNombre(), topico.getUsuario().getEmail(), topico.getUsuario().getClave()),
                new Curso(topico.getCurso().getId(), topico.getCurso().getNombre(), topico.getCurso().getCategoria()));
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(returnTopico);
    }

    //TODO: OF CRUD FINISHED CREATE, FOLLOWS THE RUD PART


}
