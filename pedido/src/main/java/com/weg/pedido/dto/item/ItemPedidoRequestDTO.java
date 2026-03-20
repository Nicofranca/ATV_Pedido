package com.weg.pedido.dto.item;

public record ItemPedidoRequestDTO(
        String nomeProduto,
        Integer quantidade,
        Double precoUnitario,
        Long idPedido
) {
}
