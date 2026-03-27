package com.weg.pedido.service;

import com.weg.pedido.dto.categoria.dtos.CategoriaRequestDTO;
import com.weg.pedido.dto.categoria.dtos.CategoriaResponseDTO;
import com.weg.pedido.dto.categoria.mapper.CategoriaMapper;
import com.weg.pedido.model.Categoria;
import org.springframework.stereotype.Service;

import com.weg.pedido.repository.CategoriaRepositoryJPA;

@Service
public class CategoriaService {
    private final CategoriaRepositoryJPA categoriaRepositoryJPA;
    private final CategoriaMapper categoriaMapper;

    public CategoriaService(CategoriaRepositoryJPA categoriaRepositoryJPA, CategoriaMapper categoriaMapper) {
        this.categoriaRepositoryJPA = categoriaRepositoryJPA;
        this.categoriaMapper = categoriaMapper;
    }

    public CategoriaResponseDTO cadastrarCategoria(CategoriaRequestDTO categoriaRequestDTO){
        Categoria categoria = categoriaMapper.requestToEntity(categoriaRequestDTO);

        categoriaRepositoryJPA.save(categoria);

        return categoriaMapper.responseToEntity(categoria);
    }

    public CategoriaResponseDTO buscarPorId(Long id){
        Categoria categoria = categoriaRepositoryJPA.findById(id)
                .orElseThrow(() -> new RuntimeException("Erro ao buscar Categoria! "));

        return categoriaMapper.responseToEntity(categoria);
    }
    
}
