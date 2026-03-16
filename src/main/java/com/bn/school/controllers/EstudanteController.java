package com.bn.school.controllers;

import com.bn.school.models.EstudanteModel;
import com.bn.school.services.EstudanteService;
import jakarta.servlet.Servlet;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController // informar que a classe sera o controlador - receber a url
@RequestMapping("/estudantes") // mapeamento a ser feito na rota - localhost:8080/estudantes
// server.port = 80*0 no application properties caso precise alterar a porta
public class EstudanteController {

    @Autowired // injeçao de dependencia
    private EstudanteService estudanteService;

    @GetMapping // informar que sera apenas uma busca
    public ResponseEntity<List<EstudanteModel> > findAll() {
        List<EstudanteModel> request = estudanteService.findAll();
        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    // optional é necessario para uma busca onde pode ter um resultado ou nao
    public Optional<EstudanteModel> buscarPorId(@PathVariable Long id) {
        return estudanteService.buscarPorId(id);
    }

    @PostMapping // informar que é um metodo de criaçao
    public ResponseEntity<EstudanteModel> criarEstudante(@RequestBody EstudanteModel estudanteModel) { // RequestBody para informar que a requisicao HTTP sera pelo corpo
        EstudanteModel request = estudanteService.criarEstudante(estudanteModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(request.getId()).toUri();

        return ResponseEntity.created(uri).body(request);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstudanteModel> atualizarEstudante(@PathVariable Long id, @RequestBody EstudanteModel estudanteModel) { // o estudante sera passado pelo body
        EstudanteModel request = estudanteService.atualizarEstudante(id, estudanteModel);
        return ResponseEntity.status(201).body(estudanteModel);
    }

    @DeleteMapping("/{id}")
    // PathVariable para extrair valores da **URL** e passar como parametro para o metodo
    public ResponseEntity<?> deletarEstudante(@PathVariable Long id) {
        estudanteService.deletarEstudante(id);
        return ResponseEntity.noContent().build(); // retornando um status
    }

}