package com.weg.pedido.dto.projeto.mapper;

import com.weg.pedido.dto.projeto.dtos.ProjetoRequestDto;
import com.weg.pedido.dto.projeto.dtos.ProjetoResponseDto;
import com.weg.pedido.model.Projeto;
import org.springframework.stereotype.Component;

@Component
public class ProjetoMapper {
    public Projeto requestToEntity(ProjetoRequestDto projetoRequestDto){
        return new Projeto(
                projetoRequestDto.nome()
        );
    }

    public ProjetoResponseDto responseToEntity(Projeto projeto){
        return new ProjetoResponseDto(
                projeto.getId(),
                projeto.getNome()
        );
    }
}
