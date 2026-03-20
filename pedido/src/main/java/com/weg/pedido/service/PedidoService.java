package com.weg.pedido.service;

import com.weg.pedido.dto.pedido.PedidoRequestDTO;
import com.weg.pedido.dto.pedido.PedidoResponseDTO;
import com.weg.pedido.dto.mapper.PedidoMapper;
import com.weg.pedido.model.Pedido;
import com.weg.pedido.repository.PedidoRepositoryJpa;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepositoryJpa pedidoRepositoryJpa;
    private final PedidoMapper pedidoMapper;

    public PedidoService(PedidoRepositoryJpa pedidoRepositoryJpa, PedidoMapper pedidoMapper) {
        this.pedidoRepositoryJpa = pedidoRepositoryJpa;
        this.pedidoMapper = pedidoMapper;
    }

    public PedidoResponseDTO save(PedidoRequestDTO pedidoRequestDTO){
        try {
            Pedido pedido = pedidoMapper.requestToEntity(pedidoRequestDTO);

            pedidoRepositoryJpa.save(pedido);

            return pedidoMapper.responseToEntity(pedido);
        } catch (RuntimeException e) {
            throw new RuntimeException("Erro ao salvar pedido! " + e);
        }
    }

    public PedidoResponseDTO findById(Long id){
        try {
            Pedido pedido = pedidoRepositoryJpa.findById(id)
                    .orElseThrow(() -> new RuntimeException("Erro ao buscar Pedido por ID! "));

            return pedidoMapper.responseToEntity(pedido);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public List<PedidoResponseDTO> findAll(){
        try {
            return pedidoRepositoryJpa.findAll().stream()
                    .map(pedidoMapper::responseToEntity)
                    .toList();
        } catch (RuntimeException e) {
            throw new RuntimeException("Erro ao listar todos os Pedidos" + e);
        }
    }

    public PedidoResponseDTO update(Long id, PedidoRequestDTO pedidoRequestDTO){
        try {
            Pedido pedido = pedidoRepositoryJpa.findById(id)
                    .orElseThrow(() -> new RuntimeException("Erro ao buscar Pedido por ID! "));

            pedido.setDataPedido(pedidoRequestDTO.dataPedido());

            pedidoRepositoryJpa.save(pedido);

            return pedidoMapper.responseToEntity(pedido);
        } catch (RuntimeException e) {
            throw new RuntimeException("Erro ao atualizar pedido! " + e);
        }
    }

    public PedidoResponseDTO delete(Long id){
        try {
            Pedido pedido = pedidoRepositoryJpa.findById(id)
                    .orElseThrow(() -> new RuntimeException("Erro ao buscar Pedido por ID! "));

            pedidoRepositoryJpa.delete(pedido);

            return pedidoMapper.responseToEntity(pedido);
        } catch (RuntimeException e) {
            throw new RuntimeException("Erro ao deletar Pedido" + e);
        }
    }
}
