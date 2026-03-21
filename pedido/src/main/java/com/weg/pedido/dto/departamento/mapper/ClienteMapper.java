package com.weg.pedido.dto.departamento.mapper;

import com.weg.pedido.dto.departamento.dtos.ClienteRequestDto;
import com.weg.pedido.dto.departamento.dtos.ClienteResponseDto;
import com.weg.pedido.model.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    public Cliente requestToEntity(ClienteRequestDto clienteRequestDto){
        return new Cliente(
                clienteRequestDto.nome()
        );
    }

    public ClienteResponseDto responseToEntity(Cliente cliente){
        return new ClienteResponseDto(
                cliente.getId(),
                cliente.getNome()
        );
    }
}
