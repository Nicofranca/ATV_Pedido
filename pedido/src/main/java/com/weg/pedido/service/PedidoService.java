package com.weg.pedido.service;

import com.weg.pedido.dto.pedido.dtos.PedidoDescricaoRequestDto;
import com.weg.pedido.dto.pedido.dtos.PedidoRequestDto;
import com.weg.pedido.dto.pedido.dtos.PedidoResponseDto;
import com.weg.pedido.dto.pedido.mapper.PedidoMapper;
import com.weg.pedido.model.Cliente;
import com.weg.pedido.model.Pedido;
import com.weg.pedido.repository.ClienteRepositoryJpa;
import com.weg.pedido.repository.PedidoRepositoryJpa;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepositoryJpa pedidoRepositoryJpa;
    private final PedidoMapper pedidoMapper;
    private final ClienteRepositoryJpa clienteRepositoryJpa;

    public PedidoService(PedidoRepositoryJpa pedidoRepositoryJpa, PedidoMapper pedidoMapper, ClienteRepositoryJpa clienteRepositoryJpa) {
        this.pedidoRepositoryJpa = pedidoRepositoryJpa;
        this.pedidoMapper = pedidoMapper;
        this.clienteRepositoryJpa = clienteRepositoryJpa;
    }

    public PedidoResponseDto save(PedidoRequestDto pedidoRequestDto){
        try {
            Cliente cliente = clienteRepositoryJpa.findById(pedidoRequestDto.idCliente())
                    .orElseThrow(() -> new RuntimeException("Erro"));

            if (cliente == null){
                throw new RuntimeException("Erro");
            }

            Pedido pedido = pedidoMapper.requestToEntity(pedidoRequestDto);

            pedido.setCliente(cliente);

            return pedidoMapper.responseToEntity(pedidoRepositoryJpa.save(pedido));
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public PedidoResponseDto findById(Long id){
        try {
            Pedido pedido = pedidoRepositoryJpa.findById(id)
                    .orElseThrow(()-> new RuntimeException("Error"));

            return pedidoMapper.responseToEntity(pedido);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public List<PedidoResponseDto> findByClienteId(Long id){
        try {
            Cliente cliente = clienteRepositoryJpa.findById(id)
                    .orElseThrow(() -> new RuntimeException("Erro ao buscar pedido de cliente! "));

            if (cliente == null){
                throw new RuntimeException("Insira um Cliente já existente! ");
            }

            return pedidoRepositoryJpa.findByClienteId(cliente.getId())
                    .stream()
                    .map(pedidoMapper::responseToEntity)
                    .toList();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public List<PedidoResponseDto> findAll(){
        try {
            return pedidoRepositoryJpa.findAll().stream()
                    .map(pedidoMapper::responseToEntity)
                    .toList();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public List<PedidoResponseDto> findByPedidoId(Long id){
        try {
            return pedidoRepositoryJpa.findByPedidoId(id).stream()
                    .map(pedidoMapper::responseToEntity)
                    .toList();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public List<PedidoResponseDto> findByClienteNome(String nome){
        try {
            return pedidoRepositoryJpa.findByClienteNome(nome).stream()
                    .map(pedidoMapper::responseToEntity)
                    .toList();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public PedidoResponseDto findByIdAndDescricao(PedidoDescricaoRequestDto pedidoDescricaoRequestDto){
        try {
            Pedido pedido = pedidoRepositoryJpa.findByIdAndDescricao(pedidoDescricaoRequestDto.id(), pedidoDescricaoRequestDto.descricao());

            return pedidoMapper.responseToEntity(pedido);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
