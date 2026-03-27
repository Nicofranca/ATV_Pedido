package com.weg.pedido.dto.professor.mapper;

import com.weg.pedido.dto.professor.dtos.ProfessorRequestDTO;
import com.weg.pedido.dto.professor.dtos.ProfessorResponseDTO;
import com.weg.pedido.model.Professor;
import org.springframework.stereotype.Component;

@Component
public class ProfessorMapper {

    public Professor requestToEntity(ProfessorRequestDTO professorRequestDTO){
        return new Professor(
                professorRequestDTO.nome()
        );
    }

    public ProfessorResponseDTO responseToEntity(Professor professor){
        return new ProfessorResponseDTO(
                professor.getId(),
                professor.getNome()
        );
    }
}
