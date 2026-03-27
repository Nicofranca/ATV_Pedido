package com.weg.pedido.repository;

import com.weg.pedido.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepositoryJPA extends JpaRepository<Produto, Long> {
    List<Produto> findByCategoriaNome(String nome);
    List<Produto> findByNome(String nome);
    List<Produto> findByCategoriaId(Long id);
}
