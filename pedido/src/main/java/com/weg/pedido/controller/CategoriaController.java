package com.weg.pedido.controller;

import com.weg.pedido.dto.categoria.dtos.CategoriaRequestDTO;
import com.weg.pedido.dto.categoria.dtos.CategoriaResponseDTO;
import com.weg.pedido.service.CategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.GetExchange;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping
    public ResponseEntity<CategoriaResponseDTO> cadastrarCategoria(@RequestBody CategoriaRequestDTO categoriaRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(categoriaService.cadastrarCategoria(categoriaRequestDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(categoriaService.buscarPorId(id));
    }
}
