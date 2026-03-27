package com.weg.pedido.dto.curso.mapper;

import com.weg.pedido.dto.curso.dtos.CursoRequestDTO;
import com.weg.pedido.dto.curso.dtos.CursoResponseDTO;
import com.weg.pedido.model.Curso;
import org.springframework.stereotype.Component;

@Component
public class CursoMapper {
    public Curso requestToEntity(CursoRequestDTO cursoRequestDTO){
        return new Curso(
                cursoRequestDTO.titulo()
        );
    }

    public CursoResponseDTO responseToEntity(Curso curso){
        return new CursoResponseDTO(
                curso.getId(),
                curso.getTitulo(),
                curso.getProfessor().getId()
        );
    }
}
