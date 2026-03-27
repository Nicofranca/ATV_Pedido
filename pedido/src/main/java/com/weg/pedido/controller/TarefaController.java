package com.weg.pedido.controller;

import com.weg.pedido.dto.tarefa.dtos.TarefaRequestDto;
import com.weg.pedido.dto.tarefa.dtos.TarefaResponseDto;
import com.weg.pedido.service.TarefaService;
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
    public TarefaResponseDto cadastrarTarefa(@RequestBody TarefaRequestDto tarefaRequestDto) {
        return tarefaService.cadastrarTarefa(tarefaRequestDto);
    }

    @GetMapping
    public List<TarefaResponseDto> listarTarefas() {
        return tarefaService.listarTarefas();
    }

    @GetMapping("/projeto/{nome}")
    public List<TarefaResponseDto> filtrarPorProjeto(@PathVariable String nome) {
        return tarefaService.filtrarPorProjeto(nome);
    }

    @GetMapping("/{id}")
    public TarefaResponseDto filtrarPorId(@PathVariable Long id) {
        return tarefaService.filtrarPorId(id);
    }

    @GetMapping("/{nome}")
    public List<TarefaResponseDto> filtrarPorNome(@PathVariable String nome) {
        return tarefaService.filtrarPorNome(nome);
    }
}
