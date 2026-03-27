package com.weg.pedido.repository;

import com.weg.pedido.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepositoryJpa extends JpaRepository<Pedido, Long> {
    List<Pedido> findByClienteNome(String nome);
    List<Pedido> findByPedidoId(Long id);
    Pedido findByIdAndNome(Long id, String nome);
    List<Pedido> findByClienteId(Long idCliente);
    Pedido findByIdAndDescricao(Long id, String descricao);

}
