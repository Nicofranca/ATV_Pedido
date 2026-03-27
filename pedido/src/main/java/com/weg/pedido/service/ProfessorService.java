package com.weg.pedido.service;

import com.weg.pedido.dto.professor.dtos.ProfessorRequestDTO;
import com.weg.pedido.dto.professor.dtos.ProfessorResponseDTO;
import com.weg.pedido.dto.professor.mapper.ProfessorMapper;
import com.weg.pedido.model.Professor;
import com.weg.pedido.repository.ProfessorRepositoryJPA;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {
    private final ProfessorRepositoryJPA professorRepositoryJPA;
    private final ProfessorMapper professorMapper;

    public ProfessorService(ProfessorRepositoryJPA professorRepositoryJPA, ProfessorMapper professorMapper) {
        this.professorRepositoryJPA = professorRepositoryJPA;
        this.professorMapper = professorMapper;
    }

    public ProfessorResponseDTO cadastrarProfessor(ProfessorRequestDTO professorRequestDTO){
        Professor professor = professorMapper.requestToEntity(professorRequestDTO);

        professorRepositoryJPA.save(professor);

        return professorMapper.responseToEntity(professor);
    }

    public List<ProfessorResponseDTO> listarProfessores(){
        return professorRepositoryJPA.findAll()
                .stream()
                .map(professorMapper::responseToEntity)
                .toList();
    }
}
