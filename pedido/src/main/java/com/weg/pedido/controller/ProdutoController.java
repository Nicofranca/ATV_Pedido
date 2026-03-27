package com.weg.pedido.controller;

import com.weg.pedido.dto.produto.dtos.ProdutoRequestDTO;
import com.weg.pedido.dto.produto.dtos.ProdutoResponseDTO;
import com.weg.pedido.service.ProdutoService;
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
    public ProdutoResponseDTO cadastrarProduto(@PathVariable ProdutoRequestDTO produtoRequestDTO) {
        return produtoService.cadastrarProduto(produtoRequestDTO);
    }

    @GetMapping
    public List<ProdutoResponseDTO> listarTodos() {
        return produtoService.listarTodos();
    }

    @GetMapping("/categoria/{nome}")
    public List<ProdutoResponseDTO> buscarPorCategoriaNome(@PathVariable String nome) {
        return produtoService.buscarPorCategoriaNome(nome);
    }

    @GetMapping("/{id}")
    public ProdutoResponseDTO buscarPorId(@PathVariable Long id) {
        return produtoService.buscarPorId(id);
    }

    @GetMapping("/{nome}")
    public List<ProdutoResponseDTO> buscarPorNome(@PathVariable String nome) {
        return produtoService.buscarPorNome(nome);
    }

    @GetMapping("/categoria/{id}")
    public List<ProdutoResponseDTO> buscaPorCategoriaId(@PathVariable Long id) {
        return produtoService.buscaPorCategoriaId(id);
    }
}
