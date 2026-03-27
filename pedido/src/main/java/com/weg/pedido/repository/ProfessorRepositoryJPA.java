package com.weg.pedido.repository;

import com.weg.pedido.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepositoryJPA extends JpaRepository<Professor, Long> {
}
