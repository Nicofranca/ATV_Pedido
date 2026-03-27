package com.weg.pedido.controller;

import com.weg.pedido.dto.tarefa.dtos.TarefaRequestDto;
import com.weg.pedido.dto.tarefa.dtos.TarefaResponseDto;
import com.weg.pedido.service.TarefaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {
    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @PostMapping
    public ResponseEntity<TarefaResponseDto> cadastrarTarefa(@RequestBody TarefaRequestDto tarefaRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(tarefaService.cadastrarTarefa(tarefaRequestDto));
    }

    @GetMapping
    public ResponseEntity<List<TarefaResponseDto>> listarTarefas() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(tarefaService.listarTarefas());
    }

    @GetMapping("/projeto/{nome}")
    public ResponseEntity<List<TarefaResponseDto>> filtrarPorProjeto(@PathVariable String nome) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(tarefaService.filtrarPorProjeto(nome));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaResponseDto> filtrarPorId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(tarefaService.filtrarPorId(id));
    }

    @GetMapping("/{nome}")
    public ResponseEntity<List<TarefaResponseDto>> filtrarPorNome(@PathVariable String nome) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(tarefaService.filtrarPorNome(nome));
    }
}
