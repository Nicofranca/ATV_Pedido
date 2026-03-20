package com.weg.pedido.dto.funcionario.mapper;

import com.weg.pedido.dto.funcionario.dtos.FuncionarioRequestDto;
import com.weg.pedido.dto.funcionario.dtos.FuncionarioResponseDto;
import com.weg.pedido.model.Funcionario;
import jakarta.persistence.Column;
import org.springframework.stereotype.Component;

@Component
public class FuncionarioMapper {
    public Funcionario requestToEntity(FuncionarioRequestDto funcionarioRequestDto){
        return new Funcionario(
                funcionarioRequestDto.nome(),
                funcionarioRequestDto.email()
        );
    }

    public FuncionarioResponseDto responseToEntity(Funcionario funcionario){
        return new FuncionarioResponseDto(
                funcionario.getId(),
                funcionario.getNome(),
                funcionario.getEmail(),
                funcionario.getDepartamento().getId()
        );
    }
}
