package com.weg.pedido.repository;

import com.weg.pedido.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoRepositoryJPA extends JpaRepository<Curso, Long> {
    List<Curso> findByProfessorNome(String nome);
    List<Curso> findByProfessorId(Long id);
    Curso findByNome(String nome);
}
