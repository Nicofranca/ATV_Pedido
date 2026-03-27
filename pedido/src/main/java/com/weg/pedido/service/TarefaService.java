package com.weg.pedido.service;

import com.weg.pedido.dto.tarefa.dtos.TarefaRequestDto;
import com.weg.pedido.dto.tarefa.dtos.TarefaResponseDto;
import com.weg.pedido.dto.tarefa.mapper.TarefaMapper;
import com.weg.pedido.model.Projeto;
import com.weg.pedido.model.Tarefa;
import com.weg.pedido.repository.ProjetoRespositoryJPA;
import com.weg.pedido.repository.TarefaRepositoryJPA;
import jakarta.persistence.Id;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {
    private final TarefaRepositoryJPA tarefaRepositoryJPA;
    private final TarefaMapper tarefaMapper;
    private final ProjetoRespositoryJPA projetoRespositoryJPA;

    public TarefaService(TarefaRepositoryJPA tarefaRepositoryJPA, TarefaMapper tarefaMapper, ProjetoRespositoryJPA projetoRespositoryJPA) {
        this.tarefaRepositoryJPA = tarefaRepositoryJPA;
        this.tarefaMapper = tarefaMapper;
        this.projetoRespositoryJPA = projetoRespositoryJPA;
    }

    public TarefaResponseDto cadastrarTarefa(TarefaRequestDto tarefaRequestDto){
        Projeto projeto = projetoRespositoryJPA.findById(tarefaRequestDto.projetoId())
                .orElseThrow(()-> new RuntimeException("Erro ao buscar Projeto! "));

        Tarefa tarefa = tarefaMapper.requestToEntity(tarefaRequestDto);

        tarefa.setProjeto(projeto);

        return tarefaMapper.responseToEntity(tarefa);
    }

    public List<TarefaResponseDto> listarTarefas(){
        return tarefaRepositoryJPA.findAll()
                .stream()
                .map(tarefaMapper::responseToEntity)
                .toList();
    }

    public List<TarefaResponseDto> filtrarPorProjeto(String nome){
        return tarefaRepositoryJPA.findByProjetoNome(nome)
                .stream()
                .map(tarefaMapper::responseToEntity)
                .toList();
    }

    public TarefaResponseDto filtrarPorId(Long id){
        Tarefa tarefa = tarefaRepositoryJPA.findById(id)
                .orElseThrow(()-> new RuntimeException("Erro ao buscar Tarefa! "));

        return tarefaMapper.responseToEntity(tarefa);
    }

    public List<TarefaResponseDto> filtrarPorNome(String nome){
        return tarefaRepositoryJPA.findByNome(nome)
                .stream()
                .map(tarefaMapper::responseToEntity)
                .toList();
    }


}
