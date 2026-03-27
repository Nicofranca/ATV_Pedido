package com.weg.pedido.controller;

import com.weg.pedido.dto.produto.dtos.ProdutoRequestDTO;
import com.weg.pedido.dto.produto.dtos.ProdutoResponseDTO;
import com.weg.pedido.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> cadastrarProduto(@PathVariable ProdutoRequestDTO produtoRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(produtoService.cadastrarProduto(produtoRequestDTO));
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> listarTodos() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(produtoService.listarTodos());
    }

    @GetMapping("/categoria/{nome}")
    public ResponseEntity<List<ProdutoResponseDTO>> buscarPorCategoriaNome(@PathVariable String nome) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(produtoService.buscarPorCategoriaNome(nome));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(produtoService.buscarPorId(id));
    }

    @GetMapping("/{nome}")
    public ResponseEntity<List<ProdutoResponseDTO>> buscarPorNome(@PathVariable String nome) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(produtoService.buscarPorNome(nome));
    }

    @GetMapping("/categoria/{id}")
    public ResponseEntity<List<ProdutoResponseDTO>> buscaPorCategoriaId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(produtoService.buscaPorCategoriaId(id));
    }
}
