package com.weg.pedido.dto.tarefa.mapper;

import com.weg.pedido.dto.tarefa.dtos.TarefaRequestDto;
import com.weg.pedido.dto.tarefa.dtos.TarefaResponseDto;
import com.weg.pedido.model.Tarefa;
import org.springframework.stereotype.Component;

@Component
public class TarefaMapper {
    public Tarefa requestToEntity(TarefaRequestDto tarefaRequestDto){
        return new Tarefa(
                tarefaRequestDto.nome()
        );
    }

    public TarefaResponseDto responseToEntity(Tarefa tarefa){
        return new TarefaResponseDto(
                tarefa.getId(),
                tarefa.getNome()
        );
    }
}
