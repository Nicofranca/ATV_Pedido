package com.weg.pedido.repository;

import com.weg.pedido.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepositoryJpa extends JpaRepository<Funcionario, Long> {
    List<Funcionario> findByNome(String nome);
    List<Funcionario> findByDepartamentoId(Long id);
    Funcionario findByIdAndNome(Long id, String nome);

}
