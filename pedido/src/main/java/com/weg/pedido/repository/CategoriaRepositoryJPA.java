package com.weg.pedido.repository;

import com.weg.pedido.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepositoryJPA extends JpaRepository<Categoria, Long> {
}
