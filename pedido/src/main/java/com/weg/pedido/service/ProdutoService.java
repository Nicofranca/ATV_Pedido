package com.weg.pedido.service;

import com.weg.pedido.dto.produto.dtos.ProdutoRequestDTO;
import com.weg.pedido.dto.produto.dtos.ProdutoResponseDTO;
import com.weg.pedido.dto.produto.mapper.ProdutoMapper;
import com.weg.pedido.model.Categoria;
import com.weg.pedido.model.Produto;
import com.weg.pedido.repository.CategoriaRepositoryJPA;
import com.weg.pedido.repository.ProdutoRepositoryJPA;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    private final ProdutoRepositoryJPA produtoRepositoryJPA;
    private final CategoriaRepositoryJPA categoriaRepositoryJPA;
    private final ProdutoMapper produtoMapper;

    public ProdutoService(ProdutoRepositoryJPA produtoRepositoryJPA, CategoriaRepositoryJPA categoriaRepositoryJPA, ProdutoMapper produtoMapper) {
        this.produtoRepositoryJPA = produtoRepositoryJPA;
        this.categoriaRepositoryJPA = categoriaRepositoryJPA;
        this.produtoMapper = produtoMapper;
    }

    public ProdutoResponseDTO cadastrarProduto(ProdutoRequestDTO produtoRequestDTO){
        Categoria categoria = categoriaRepositoryJPA.findById(produtoRequestDTO.categoraId())
                .orElseThrow(() -> new RuntimeException("Erro ao buscar Categoria! "));

        if (categoria == null){
            throw new RuntimeException("Categoria não existente! ");
        }

        Produto produto = produtoMapper.requestToEntity(produtoRequestDTO);

        produto.setCategoria(categoria);

        produtoRepositoryJPA.save(produto);

        return produtoMapper.responseToEntity(produto);
    }

    public List<ProdutoResponseDTO> listarTodos(){
        return produtoRepositoryJPA.findAll()
                .stream()
                .map(produtoMapper::responseToEntity)
                .toList();
    }

    public List<ProdutoResponseDTO> buscarPorCategoriaNome(String nome){
        return produtoRepositoryJPA.findByCategoriaNome(nome)
                .stream()
                .map(produtoMapper::responseToEntity)
                .toList();
    }

    public ProdutoResponseDTO buscarPorId (Long id){
        Produto produto = produtoRepositoryJPA.findById(id)
                .orElseThrow(() -> new RuntimeException("Erro ao buscar Produto! "));

        return produtoMapper.responseToEntity(produto);
    }

    public List<ProdutoResponseDTO> buscarPorNome(String nome){
        return produtoRepositoryJPA.findByNome(nome)
                .stream()
                .map(produtoMapper::responseToEntity)
                .toList();
    }

    public List<ProdutoResponseDTO> buscaPorCategoriaId(Long id){
        return produtoRepositoryJPA.findByCategoriaId(id)
                .stream()
                .map(produtoMapper::responseToEntity)
                .toList();
    }
}
