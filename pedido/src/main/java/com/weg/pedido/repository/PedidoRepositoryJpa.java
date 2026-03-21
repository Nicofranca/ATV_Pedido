package com.weg.pedido.repository;

import com.weg.pedido.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepositoryJpa extends JpaRepository<Pedido, Long> {
    List<Pedido> findByNome(String nome);
    List<Pedido> findByDepartamentoId(Long id);
    Pedido findByIdAndNome(Long id, String nome);

}
