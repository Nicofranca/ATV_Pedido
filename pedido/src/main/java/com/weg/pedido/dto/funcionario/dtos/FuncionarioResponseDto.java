package com.weg.pedido.dto.funcionario.dtos;

public record FuncionarioResponseDto(
        Long id,
        String nome,
        String email,
        Long idDepartamento
) {
}
