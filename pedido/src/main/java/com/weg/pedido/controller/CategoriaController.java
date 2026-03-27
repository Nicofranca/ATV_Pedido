package com.weg.pedido.controller;

import com.weg.pedido.dto.categoria.dtos.CategoriaRequestDTO;
import com.weg.pedido.dto.categoria.dtos.CategoriaResponseDTO;
import com.weg.pedido.service.CategoriaService;
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
    public CategoriaResponseDTO cadastrarCategoria(@RequestBody CategoriaRequestDTO categoriaRequestDTO) {
        return categoriaService.cadastrarCategoria(categoriaRequestDTO);
    }

    @GetMapping("/{id}")
    public CategoriaResponseDTO buscarPorId(@PathVariable Long id) {
        return categoriaService.buscarPorId(id);
    }
}
