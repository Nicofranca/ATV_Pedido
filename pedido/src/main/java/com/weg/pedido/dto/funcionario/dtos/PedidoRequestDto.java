package com.weg.pedido.dto.funcionario.dtos;

public record PedidoRequestDto(
        String descricao,
        Long idCliente
) {
}
