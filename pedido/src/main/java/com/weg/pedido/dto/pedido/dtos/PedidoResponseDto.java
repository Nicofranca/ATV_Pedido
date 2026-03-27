package com.weg.pedido.dto.pedido.dtos;

public record PedidoResponseDto(
        Long id,
        String descricao,
        Long idCliente
) {
}
