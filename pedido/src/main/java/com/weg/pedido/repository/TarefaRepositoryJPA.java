package com.weg.pedido.repository;

import com.weg.pedido.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarefaRepositoryJPA extends JpaRepository<Tarefa, Long> {
    List<Tarefa> findByProjetoNome(String nome);
    List<Tarefa> findByNome(String nome);
}
