package com.weg.pedido.repository;

import com.weg.pedido.model.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoRepositoryJpa extends JpaRepository<ItemPedido, Long> {
}
