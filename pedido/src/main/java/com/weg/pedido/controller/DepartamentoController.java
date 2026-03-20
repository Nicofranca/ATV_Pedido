package com.weg.pedido.controller;

import com.weg.pedido.dto.departamento.dtos.DepartamentoRequestDto;
import com.weg.pedido.dto.departamento.dtos.DepartamentoResponseDto;
import com.weg.pedido.service.DepartamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {
    private final DepartamentoService departamentoService;

    public DepartamentoController(DepartamentoService departamentoService) {
        this.departamentoService = departamentoService;
    }

    @PostMapping
    public ResponseEntity<DepartamentoResponseDto> save(@RequestBody DepartamentoRequestDto departamentoRequestDto) {
        return ResponseEntity.ok(departamentoService.save(departamentoRequestDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartamentoResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(departamentoService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<DepartamentoResponseDto>> findAll() {
        return ResponseEntity.ok(departamentoService.findAll());
    }
}
