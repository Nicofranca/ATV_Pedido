package com.weg.pedido.controller;

import com.weg.pedido.dto.professor.dtos.ProfessorRequestDTO;
import com.weg.pedido.dto.professor.dtos.ProfessorResponseDTO;
import com.weg.pedido.service.ProfessorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ProfessorResponseDTO> cadastrarProfessor(@RequestBody ProfessorRequestDTO professorRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(professorService.cadastrarProfessor(professorRequestDTO));
    }

    @GetMapping
    public ResponseEntity<List<ProfessorResponseDTO>> listarProfessores() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(professorService.listarProfessores());
    }
}
