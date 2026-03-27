package com.weg.pedido.dto.produto.dtos;

public record ProdutoResponseDTO(
        Long id,
        String nome,
        Double preco,
        String categoriaNome
) {
}
