package com.weg.pedido.service;

import com.weg.pedido.dto.departamento.dtos.ClienteRequestDto;
import com.weg.pedido.dto.departamento.dtos.ClienteResponseDto;
import com.weg.pedido.dto.departamento.mapper.ClienteMapper;
import com.weg.pedido.model.Cliente;
import com.weg.pedido.repository.ClienteRepositoryJpa;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    private final ClienteRepositoryJpa clienteRepositoryJpa;
    private final ClienteMapper clienteMapper;

    public ClienteService(ClienteRepositoryJpa clienteRepositoryJpa, ClienteMapper clienteMapper) {
        this.clienteRepositoryJpa = clienteRepositoryJpa;
        this.clienteMapper = clienteMapper;
    }

    public ClienteResponseDto save(ClienteRequestDto clienteRequestDto){
        try {
            Cliente cliente = clienteMapper.requestToEntity(clienteRequestDto);

            clienteRepositoryJpa.save(cliente);

            return clienteMapper.responseToEntity(cliente);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public ClienteResponseDto findById(Long id){
        try {
            Cliente cliente = clienteRepositoryJpa.findById(id)
                    .orElseThrow(() -> new RuntimeException("Erro"));

            return clienteMapper.responseToEntity(cliente);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ClienteResponseDto> findAll(){
        try {
            return clienteRepositoryJpa.findAll().stream()
                    .map(clienteMapper::responseToEntity)
                    .toList();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

}
