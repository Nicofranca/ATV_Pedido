package com.weg.pedido.controller;

import com.weg.pedido.dto.professor.dtos.ProfessorRequestDTO;
import com.weg.pedido.dto.professor.dtos.ProfessorResponseDTO;
import com.weg.pedido.service.ProfessorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorController {
    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @PostMapping
    public ProfessorResponseDTO cadastrarProfessor(@RequestBody ProfessorRequestDTO professorRequestDTO) {
        return professorService.cadastrarProfessor(professorRequestDTO);
    }

    @GetMapping
    public List<ProfessorResponseDTO> listarProfessores() {
        return professorService.listarProfessores();
    }
}
