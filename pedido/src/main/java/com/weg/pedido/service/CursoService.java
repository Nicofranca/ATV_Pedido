package com.weg.pedido.service;

import com.weg.pedido.dto.curso.dtos.CursoRequestDTO;
import com.weg.pedido.dto.curso.dtos.CursoResponseDTO;
import com.weg.pedido.dto.curso.mapper.CursoMapper;
import com.weg.pedido.model.Curso;
import com.weg.pedido.model.Professor;
import com.weg.pedido.repository.CursoRepositoryJPA;
import com.weg.pedido.repository.ProfessorRepositoryJPA;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {
    private final CursoRepositoryJPA cursoRepositoryJPA;
    private final CursoMapper cursoMapper;
    private final ProfessorRepositoryJPA professorRepositoryJPA;

    public CursoService(CursoRepositoryJPA cursoRepositoryJPA, CursoMapper cursoMapper, ProfessorRepositoryJPA professorRepositoryJPA) {
        this.cursoRepositoryJPA = cursoRepositoryJPA;
        this.cursoMapper = cursoMapper;
        this.professorRepositoryJPA = professorRepositoryJPA;
    }

    public CursoResponseDTO cadastrarCurso(CursoRequestDTO cursoRequestDTO){
        Professor professor = professorRepositoryJPA.findById(cursoRequestDTO.professorId())
                .orElseThrow(() -> new RuntimeException("Erro ao buscar Professor! "));

        Curso curso = cursoMapper.requestToEntity(cursoRequestDTO);

        curso.setProfessor(professor);

        return cursoMapper.responseToEntity(curso);
    }

    public List<CursoResponseDTO> listarCursos(){
        return cursoRepositoryJPA.findAll()
                .stream()
                .map(cursoMapper::responseToEntity)
                .toList();
    }

    public List<CursoResponseDTO> listarCursosPorProfessorNome(String nome){
        return cursoRepositoryJPA.findByProfessorNome(nome)
                .stream()
                .map(cursoMapper::responseToEntity)
                .toList();
    }

    public List<CursoResponseDTO> listarCursoPorProfessorId(Long id){
        return cursoRepositoryJPA.findByProfessorId(id)
                .stream()
                .map(cursoMapper::responseToEntity)
                .toList();
    }

    public CursoResponseDTO buscarPorId(Long id){
        Curso curso = cursoRepositoryJPA.findById(id)
                .orElseThrow(() -> new RuntimeException("Erro ao buscar Curso! "));

        return cursoMapper.responseToEntity(curso);
    }

    public CursoResponseDTO buscarPorNomeCurso(String nome){
        Curso curso = cursoRepositoryJPA.findByNome(nome);

        return cursoMapper.responseToEntity(curso);
    }
}
