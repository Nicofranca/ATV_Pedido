package com.weg.pedido.controller;

import com.weg.pedido.dto.projeto.dtos.ProjetoRequestDto;
import com.weg.pedido.dto.projeto.dtos.ProjetoResponseDto;
import com.weg.pedido.service.ProjetoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tarefa")
public class ProjetoController {

    private final ProjetoService projetoService;

    public ProjetoController(ProjetoService projetoService) {
        this.projetoService = projetoService;
    }

    @PostMapping
    public ResponseEntity<ProjetoResponseDto> cadastrarProjeto(ProjetoRequestDto projetoRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(projetoService.cadastrarProjeto(projetoRequestDto));
    }

    @GetMapping
    public ResponseEntity<List<ProjetoResponseDto>> listarProjetos() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(projetoService.listarProjetos());
    }
}
