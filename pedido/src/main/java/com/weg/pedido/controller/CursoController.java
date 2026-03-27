package com.weg.pedido.controller;

import com.weg.pedido.dto.curso.dtos.CursoRequestDTO;
import com.weg.pedido.dto.curso.dtos.CursoResponseDTO;
import com.weg.pedido.service.CursoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso")
public class CursoController {
    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @PostMapping
    public ResponseEntity<CursoResponseDTO> cadastrarCurso(@RequestBody CursoRequestDTO cursoRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(cursoService.cadastrarCurso(cursoRequestDTO));
    }

    @GetMapping
    public ResponseEntity<List<CursoResponseDTO>> listarCursos() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(cursoService.listarCursos());
    }

    @GetMapping("/professor/{nome}")
    public ResponseEntity<List<CursoResponseDTO>> listarCursosPorProfessorNome(@PathVariable String nome) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(cursoService.listarCursosPorProfessorNome(nome));
    }

    @GetMapping("/professor/{id}")
    public ResponseEntity<List<CursoResponseDTO>> listarCursoPorProfessorId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(cursoService.listarCursoPorProfessorId(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(cursoService.buscarPorId(id));
    }

    @GetMapping("/{nome}")
    public ResponseEntity<CursoResponseDTO> buscarPorNomeCurso(@PathVariable String nome) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(cursoService.buscarPorNomeCurso(nome));
    }
}
