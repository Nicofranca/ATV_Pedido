package com.weg.pedido.dto.produto.mapper;

import com.weg.pedido.dto.produto.dtos.ProdutoRequestDTO;
import com.weg.pedido.dto.produto.dtos.ProdutoResponseDTO;
import com.weg.pedido.model.Produto;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {

    public Produto requestToEntity(ProdutoRequestDTO produtoRequestDTO){
        return new Produto(
                produtoRequestDTO.nome(),
                produtoRequestDTO.preco()
        );
    }

    public ProdutoResponseDTO responseToEntity(Produto produto){
        return new ProdutoResponseDTO(
                produto.getId(),
                produto.getNome(),
                produto.getPreco(),
                produto.getCategoria().getNome()
        );
    }
}
