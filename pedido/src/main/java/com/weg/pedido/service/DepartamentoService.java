package com.weg.pedido.service;

import com.weg.pedido.dto.departamento.dtos.DepartamentoRequestDto;
import com.weg.pedido.dto.departamento.dtos.DepartamentoResponseDto;
import com.weg.pedido.dto.departamento.mapper.DepartamentoMapper;
import com.weg.pedido.model.Departamento;
import com.weg.pedido.repository.DepartamentoRepositoryJpa;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoService {
    private final DepartamentoRepositoryJpa departamentoRepositoryJpa;
    private final DepartamentoMapper departamentoMapper;

    public DepartamentoService(DepartamentoRepositoryJpa departamentoRepositoryJpa, DepartamentoMapper departamentoMapper) {
        this.departamentoRepositoryJpa = departamentoRepositoryJpa;
        this.departamentoMapper = departamentoMapper;
    }

    public DepartamentoResponseDto save(DepartamentoRequestDto departamentoRequestDto){
        try {
            Departamento departamento = departamentoMapper.requestToEntity(departamentoRequestDto);

            departamentoRepositoryJpa.save(departamento);

            return departamentoMapper.responseToEntity(departamento);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public DepartamentoResponseDto findById(Long id){
        try {
            Departamento departamento = departamentoRepositoryJpa.findById(id)
                    .orElseThrow(() -> new RuntimeException("Erro"));

            return departamentoMapper.responseToEntity(departamento);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public List<DepartamentoResponseDto> findAll(){
        try {
            return departamentoRepositoryJpa.findAll().stream()
                    .map(departamentoMapper::responseToEntity)
                    .toList();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

}
