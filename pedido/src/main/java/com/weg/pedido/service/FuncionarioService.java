package com.weg.pedido.service;

import com.weg.pedido.dto.funcionario.dtos.FuncionarioRequestDto;
import com.weg.pedido.dto.funcionario.dtos.FuncionarioResponseDto;
import com.weg.pedido.dto.funcionario.mapper.FuncionarioMapper;
import com.weg.pedido.model.Departamento;
import com.weg.pedido.model.Funcionario;
import com.weg.pedido.repository.DepartamentoRepositoryJpa;
import com.weg.pedido.repository.FuncionarioRepositoryJpa;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    private final FuncionarioRepositoryJpa funcionarioRepositoryJpa;
    private final FuncionarioMapper funcionarioMapper;
    private final DepartamentoRepositoryJpa departamentoRepositoryJpa;

    public FuncionarioService(FuncionarioRepositoryJpa funcionarioRepositoryJpa, FuncionarioMapper funcionarioMapper, DepartamentoRepositoryJpa departamentoRepositoryJpa) {
        this.funcionarioRepositoryJpa = funcionarioRepositoryJpa;
        this.funcionarioMapper = funcionarioMapper;
        this.departamentoRepositoryJpa = departamentoRepositoryJpa;
    }

    public FuncionarioResponseDto save(FuncionarioRequestDto funcionarioRequestDto){
        try {
            Departamento departamento = departamentoRepositoryJpa.findById(funcionarioRequestDto.idDepartamento())
                    .orElseThrow(() -> new RuntimeException("Erro"));

            if (departamento == null){
                throw new RuntimeException("Erro");
            }

            Funcionario funcionario = funcionarioMapper.requestToEntity(funcionarioRequestDto);

            funcionario.setDepartamento(departamento);

            return funcionarioMapper.responseToEntity(funcionarioRepositoryJpa.save(funcionario));
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public FuncionarioResponseDto findById(Long id){
        try {
            Funcionario funcionario = funcionarioRepositoryJpa.findById(id)
                    .orElseThrow(()-> new RuntimeException("Error"));

            return funcionarioMapper.responseToEntity(funcionario);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public List<FuncionarioResponseDto> findAll(){
        try {
            return funcionarioRepositoryJpa.findAll().stream()
                    .map(funcionarioMapper::responseToEntity)
                    .toList();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public List<FuncionarioResponseDto> findByIdDepartamento(Long id){
        try {
            return funcionarioRepositoryJpa.findByDepartamentoId(id).stream()
                    .map(funcionarioMapper::responseToEntity)
                    .toList();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public List<FuncionarioResponseDto> findByName(String nome){
        try {
            return funcionarioRepositoryJpa.findByName(nome).stream()
                    .map(funcionarioMapper::responseToEntity)
                    .toList();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public FuncionarioResponseDto findByIdAndName(Long id, String nome){
        try {
            Funcionario funcionario = funcionarioRepositoryJpa.findByIdAndNome(id, nome);

            return funcionarioMapper.responseToEntity(funcionario);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
