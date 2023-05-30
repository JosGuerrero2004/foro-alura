package com.alura.foro.controller;

import com.alura.foro.domain.cursos.Curso;
import com.alura.foro.domain.topicos.*;
import com.alura.foro.domain.usuarios.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
        DatosReturnTopico returnTopico = new DatosReturnTopico(topico);
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(returnTopico);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> listarTopicos(Pageable paginacion){
        return ResponseEntity.ok(topicoRepository.findAll(paginacion).map(DatosListadoTopico::new));
    }

    //TODO:update



    //TODO:Delete
}
