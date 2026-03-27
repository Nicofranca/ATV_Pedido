package com.weg.pedido.service;

import com.weg.pedido.dto.projeto.dtos.ProjetoRequestDto;
import com.weg.pedido.dto.projeto.dtos.ProjetoResponseDto;
import com.weg.pedido.dto.projeto.mapper.ProjetoMapper;
import com.weg.pedido.model.Projeto;
import com.weg.pedido.repository.ProjetoRespositoryJPA;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoService {
    private final ProjetoRespositoryJPA projetoRespositoryJPA;
    private final ProjetoMapper projetoMapper;

    public ProjetoService(ProjetoRespositoryJPA projetoRespositoryJPA, ProjetoMapper projetoMapper) {
        this.projetoRespositoryJPA = projetoRespositoryJPA;
        this.projetoMapper = projetoMapper;
    }

    public ProjetoResponseDto cadastrarProjeto(ProjetoRequestDto projetoRequestDto){
        Projeto projeto = projetoMapper.requestToEntity(projetoRequestDto);

        projetoRespositoryJPA.save(projeto);

        return projetoMapper.responseToEntity(projeto);
    }

    public List<ProjetoResponseDto> listarProjetos(){
        return projetoRespositoryJPA.findAll()
                .stream()
                .map(projetoMapper::responseToEntity)
                .toList();
    }
}
