package com.weg.pedido.repository;

import com.weg.pedido.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositoryJpa extends JpaRepository<Cliente, Long> {
}
