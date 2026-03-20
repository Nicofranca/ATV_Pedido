package com.weg.pedido.service;

import com.weg.pedido.dto.item.ItemPedidoRequestDTO;
import com.weg.pedido.dto.item.ItemPedidoResponseDTO;
import com.weg.pedido.dto.mapper.ItemPedidoMapper;
import com.weg.pedido.model.ItemPedido;
import com.weg.pedido.model.Pedido;
import com.weg.pedido.repository.ItemPedidoRepositoryJpa;
import com.weg.pedido.repository.PedidoRepositoryJpa;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemPedidoService {

    private final ItemPedidoRepositoryJpa itemPedidoRepositoryJpa;
    private final ItemPedidoMapper itemPedidoMapper;
    private final PedidoRepositoryJpa pedidoRepositoryJpa;

    public ItemPedidoService(ItemPedidoRepositoryJpa itemPedidoRepositoryJpa, ItemPedidoMapper itemPedidoMapper, PedidoRepositoryJpa pedidoRepositoryJpa) {
        this.itemPedidoRepositoryJpa = itemPedidoRepositoryJpa;
        this.itemPedidoMapper = itemPedidoMapper;
        this.pedidoRepositoryJpa = pedidoRepositoryJpa;
    }

    public ItemPedidoResponseDTO save(ItemPedidoRequestDTO itemPedidoRequestDTO){
        try {
            Pedido pedido = pedidoRepositoryJpa.findById(itemPedidoRequestDTO.idPedido())
                    .orElseThrow(() -> new RuntimeException("Erro ao buscar pedido! "));

            if (pedido == null){
                throw new RuntimeException("Erro, o pedido não pode ser nulo! ");
            }

            ItemPedido itemPedido = itemPedidoMapper.requestToEntity(itemPedidoRequestDTO);

            itemPedido.setPedido(pedido);

            itemPedidoRepositoryJpa.save(itemPedido);

            return itemPedidoMapper.responseToEntity(itemPedido);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public ItemPedidoResponseDTO findById(Long id){
        try {
            ItemPedido itemPedido = itemPedidoRepositoryJpa.findById(id)
                    .orElseThrow(() -> new RuntimeException("Erro ao buscar pedido! "));

            Pedido pedido = pedidoRepositoryJpa.findById(itemPedido.getPedido().getId())
                    .orElseThrow(() -> new RuntimeException("Erro ao buscar pedido! "));

            if (pedido == null){
                throw new RuntimeException("Pedido não existe");
            }

            return itemPedidoMapper.responseToEntity(itemPedido);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ItemPedidoResponseDTO> findAll(){
        try {
            return itemPedidoRepositoryJpa.findAll().stream()
                    .map(itemPedidoMapper::responseToEntity)
                    .toList();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public ItemPedidoResponseDTO update(Long id, ItemPedidoRequestDTO itemPedidoRequestDTO){
        try {
            Pedido pedido = pedidoRepositoryJpa.findById(itemPedidoRequestDTO.idPedido())
                    .orElseThrow(() -> new RuntimeException("Erro ao buscar pedido! "));

            if (pedido == null){
                throw new RuntimeException("Pedido não pode ser nulo! ");
            }

            ItemPedido itemPedido = itemPedidoMapper.requestToEntity(itemPedidoRequestDTO);

            itemPedido.setPedido(pedido);
            itemPedido.setId(id);
            itemPedido.setNomeProduto(itemPedidoRequestDTO.nomeProduto());
            itemPedido.setQuantidade(itemPedidoRequestDTO.quantidade());
            itemPedido.setPrecoUnitario(itemPedidoRequestDTO.precoUnitario());

            return itemPedidoMapper.responseToEntity(itemPedido);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public ItemPedidoResponseDTO delete(Long id){
        try {
            ItemPedido itemPedido = itemPedidoRepositoryJpa.findById(id)
                    .orElseThrow(() -> new RuntimeException("Erro ao buscar pedido! "));

            itemPedidoRepositoryJpa.delete(itemPedido);

            return itemPedidoMapper.responseToEntity(itemPedido);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
