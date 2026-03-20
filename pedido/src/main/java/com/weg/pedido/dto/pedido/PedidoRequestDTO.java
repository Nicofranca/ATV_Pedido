package com.weg.pedido.dto.pedido;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record PedidoRequestDTO(
        @NotNull
        @FutureOrPresent
        LocalDate dataPedido
) {
}
