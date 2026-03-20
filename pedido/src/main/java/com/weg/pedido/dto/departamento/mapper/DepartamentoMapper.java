package com.weg.pedido.dto.departamento.mapper;

import com.weg.pedido.dto.departamento.dtos.DepartamentoRequestDto;
import com.weg.pedido.dto.departamento.dtos.DepartamentoResponseDto;
import com.weg.pedido.model.Departamento;
import org.springframework.stereotype.Component;

@Component
public class DepartamentoMapper {

    public Departamento requestToEntity(DepartamentoRequestDto departamentoRequestDto){
        return new Departamento(
                departamentoRequestDto.nome()
        );
    }

    public DepartamentoResponseDto responseToEntity(Departamento departamento){
        return new DepartamentoResponseDto(
                departamento.getId(),
                departamento.getNome()
        );
    }
}
