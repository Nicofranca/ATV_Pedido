package com.weg.pedido.dto.pedido.mapper;

import com.weg.pedido.dto.pedido.dtos.PedidoRequestDto;
import com.weg.pedido.dto.pedido.dtos.PedidoResponseDto;
import com.weg.pedido.model.Pedido;
import org.springframework.stereotype.Component;

@Component
public class PedidoMapper {
    public Pedido requestToEntity(PedidoRequestDto pedidoRequestDto){
        return new Pedido(
                pedidoRequestDto.descricao()
        );
    }

    public PedidoResponseDto responseToEntity(Pedido pedido){
        return new PedidoResponseDto(
                pedido.getId(),
                pedido.getDescricao(),
                pedido.getCliente().getId()
        );
    }
}
