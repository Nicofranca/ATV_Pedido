package com.weg.pedido.dto.funcionario.dtos;

import com.weg.pedido.model.Departamento;

public record FuncionarioRequestDto(
        String nome,
        String email,
        Long idDepartamento
) {
}
