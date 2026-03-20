package com.weg.pedido.controller;


import com.weg.pedido.dto.funcionario.dtos.FuncionarioRequestDto;
import com.weg.pedido.dto.funcionario.dtos.FuncionarioResponseDto;
import com.weg.pedido.service.FuncionarioService;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @PostMapping
    public ResponseEntity<FuncionarioResponseDto> save(@RequestBody FuncionarioRequestDto funcionarioRequestDto) {
        return ResponseEntity.ok(funcionarioService.save(funcionarioRequestDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(funcionarioService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<FuncionarioResponseDto>> findAll() {
        return ResponseEntity.ok(funcionarioService.findAll());
    }

    @GetMapping("/departamento/{id}")
    public ResponseEntity<List<FuncionarioResponseDto>> findByIdDepartamento(@PathVariable Long id) {
        return ResponseEntity.ok(funcionarioService.findByIdDepartamento(id));
    }

    @GetMapping("/{nome}")
    public ResponseEntity<List<FuncionarioResponseDto>> findByName(@PathVariable String nome) {
        return ResponseEntity.ok(funcionarioService.findByName(nome));
    }

    @GetMapping("/{id}/{nome}")
    public ResponseEntity<FuncionarioResponseDto> findByIdAndName(@PathVariable Long id, @PathVariable String nome) {
        return ResponseEntity.ok(funcionarioService.findByIdAndName(id, nome));
    }
}
