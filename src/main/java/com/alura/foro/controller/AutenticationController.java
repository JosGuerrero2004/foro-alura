package com.alura.foro.controller;

import com.alura.foro.domain.usuarios.DatosAutenticacionUsuario;
import com.alura.foro.domain.usuarios.Usuario;
import com.alura.foro.infra.security.DatosJWTToken;
import com.alura.foro.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<DatosJWTToken> autenticarUsuario(@RequestBody @Valid DatosAutenticacionUsuario datosAutenticacionUsuario) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(datosAutenticacionUsuario.nombre(),
                datosAutenticacionUsuario.clave());
        authenticationManager.authenticate(authToken);
        var UsuarioAutenticado = authenticationManager.authenticate(authToken);
        var JWToken = tokenService.generarToken((Usuario) UsuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new DatosJWTToken(JWToken));
    }
}
