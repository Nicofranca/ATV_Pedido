package com.weg.pedido.dto.item;

import com.weg.pedido.model.Pedido;

public record ItemPedidoResponseDTO(
        Long id,
        String nomeProduto,
        Integer quantidade,
        Double precoUnitario,
        Long idPedido
) {
}
