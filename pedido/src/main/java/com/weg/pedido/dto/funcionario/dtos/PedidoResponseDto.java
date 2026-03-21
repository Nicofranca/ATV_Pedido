package com.weg.pedido.dto.funcionario.dtos;

public record PedidoResponseDto(
        Long id,
        String descricao,
        Long idCliente
) {
}
