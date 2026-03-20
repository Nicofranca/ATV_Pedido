package com.weg.pedido.dto.mapper;

import com.weg.pedido.dto.pedido.PedidoRequestDTO;
import com.weg.pedido.dto.pedido.PedidoResponseDTO;
import com.weg.pedido.model.Pedido;
import org.springframework.stereotype.Component;

@Component
public class PedidoMapper {

    public Pedido requestToEntity(PedidoRequestDTO pedidoRequestDTO){
        return new Pedido(
                null,
                pedidoRequestDTO.dataPedido(),
                null

        );
    }

    public PedidoResponseDTO responseToEntity(Pedido pedido){
        return new PedidoResponseDTO(
                pedido.getId(),
                pedido.getDataPedido()
        );
    }
}
