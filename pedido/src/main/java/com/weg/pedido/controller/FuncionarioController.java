package com.weg.pedido.controller;


import com.weg.pedido.dto.funcionario.dtos.FuncionarioRequestDto;
import com.weg.pedido.dto.funcionario.dtos.FuncionarioResponseDto;
import com.weg.pedido.service.FuncionarioService;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
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
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(funcionarioService.save(funcionarioRequestDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(funcionarioService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<FuncionarioResponseDto>> findAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(funcionarioService.findAll());
    }

    @GetMapping("/departamento/{id}")
    public ResponseEntity<List<FuncionarioResponseDto>> findByIdDepartamento(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(funcionarioService.findByIdDepartamento(id));
    }

    @GetMapping("/{nome}")
    public ResponseEntity<List<FuncionarioResponseDto>> findByName(@PathVariable String nome) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(funcionarioService.findByName(nome));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioResponseDto> findByIdAndName(@PathVariable Long id, @RequestBody String nome) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(funcionarioService.findByIdAndName(id, nome));
    }
}
