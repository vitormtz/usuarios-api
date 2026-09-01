/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.apicode.service;

import java.util.ArrayList;
import org.apicode.model.Autenticacao;
import org.apicode.model.Usuario;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author vitor
 */
@RestController
@RequestMapping("/usuarios")
public class UsuariosService {

    private RestTemplate restTemplate = new RestTemplate();

    public UsuariosService() {
    }

    public UsuariosService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping
    public ResponseEntity<String> criarUsuario(@RequestBody Usuario usuarioRequest) {

        String url = "http://localhost:8080/usuarios";

        if (restTemplate.postForObject(url, usuarioRequest, Usuario.class) == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body("OK");
        }
    }

    @PostMapping("/autenticacao")
    public ResponseEntity<String> autenticarUsuario(@RequestBody Autenticacao autenticacaoRequest) {

        String url = "http://localhost:8080/usuarios/autenticacao";

        if (restTemplate.postForObject(url, autenticacaoRequest, Autenticacao.class) == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body("OK");
        }
    }
}
