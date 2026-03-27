package com.weg.pedido.dto.categoria.mapper;

import com.weg.pedido.dto.categoria.dtos.CategoriaRequestDTO;
import com.weg.pedido.dto.categoria.dtos.CategoriaResponseDTO;
import com.weg.pedido.model.Categoria;
import com.weg.pedido.model.Produto;
import org.springframework.stereotype.Component;

@Component
public class CategoriaMapper {
    public Categoria requestToEntity(CategoriaRequestDTO categoriaRequestDTO){
        return new Categoria(
                categoriaRequestDTO.nome()
        );
    }

    public CategoriaResponseDTO responseToEntity(Categoria categoria){
        return new CategoriaResponseDTO(
                categoria.getId(),
                categoria.getNome()
        );
    }
}
