package com.weg.pedido.dto.pedido.dtos;

public record PedidoRequestDto(
        String descricao,
        Long idCliente
) {
}
