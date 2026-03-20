package com.weg.pedido.model.exception;

public class ErrorPedido extends RuntimeException {
    public ErrorPedido(String message) {
        super("Erro no pedido! " + message);
    }
}
