package com.weg.pedido.controller;


import com.weg.pedido.dto.funcionario.dtos.PedidoRequestDto;
import com.weg.pedido.dto.funcionario.dtos.PedidoResponseDto;
import com.weg.pedido.service.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
    private final PedidoService pedidoService;

    public FuncionarioController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public ResponseEntity<PedidoResponseDto> save(@RequestBody PedidoRequestDto pedidoRequestDto) {
        return ResponseEntity.ok(pedidoService.save(pedidoRequestDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(pedidoService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<PedidoResponseDto>> findAll() {
        return ResponseEntity.ok(pedidoService.findAll());
    }

    @GetMapping("/departamento/{id}")
    public ResponseEntity<List<PedidoResponseDto>> findByIdDepartamento(@PathVariable Long id) {
        return ResponseEntity.ok(pedidoService.findByIdDepartamento(id));
    }

    @GetMapping("/{nome}")
    public ResponseEntity<List<PedidoResponseDto>> findByName(@PathVariable String nome) {
        return ResponseEntity.ok(pedidoService.findByName(nome));
    }

    @GetMapping("/{id}/{nome}")
    public ResponseEntity<PedidoResponseDto> findByIdAndName(@PathVariable Long id, @PathVariable String nome) {
        return ResponseEntity.ok(pedidoService.findByIdAndName(id, nome));
    }
}
