package com.weg.pedido.dto.produto.dtos;

public record ProdutoRequestDTO(
        String nome,
        Double preco,
        Long categoraId
) {
}
