package com.weg.pedido.dto.pedido;


import java.time.LocalDate;

public record PedidoResponseDTO(

        Long id,
        LocalDate dataPedido
) {
}
