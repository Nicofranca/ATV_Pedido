package com.weg.pedido.repository;

import com.weg.pedido.model.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetoRespositoryJPA extends JpaRepository<Projeto, Long> {
}
