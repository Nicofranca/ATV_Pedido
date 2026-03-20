package com.weg.pedido.dto.mapper;

import com.weg.pedido.dto.item.ItemPedidoRequestDTO;
import com.weg.pedido.dto.item.ItemPedidoResponseDTO;
import com.weg.pedido.model.ItemPedido;
import org.springframework.stereotype.Component;

@Component
public class ItemPedidoMapper {

    private PedidoMapper pedidoMapper;

    public ItemPedido requestToEntity(ItemPedidoRequestDTO itemPedidoRequestDTO){
        return new ItemPedido(
                itemPedidoRequestDTO.nomeProduto(),
                itemPedidoRequestDTO.quantidade(),
                itemPedidoRequestDTO.precoUnitario()
        );
    }

    public ItemPedidoResponseDTO responseToEntity(ItemPedido itemPedido){
        return new ItemPedidoResponseDTO(
                itemPedido.getId(),
                itemPedido.getNomeProduto(),
                itemPedido.getQuantidade(),
                itemPedido.getPrecoUnitario(),
                itemPedido.getPedido().getId()
        );
    }
}
