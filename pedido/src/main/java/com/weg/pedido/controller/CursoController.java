package com.weg.pedido.controller;

import com.weg.pedido.dto.curso.dtos.CursoRequestDTO;
import com.weg.pedido.dto.curso.dtos.CursoResponseDTO;
import com.weg.pedido.service.CursoService;
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
    public CursoResponseDTO cadastrarCurso(@RequestBody CursoRequestDTO cursoRequestDTO) {
        return cursoService.cadastrarCurso(cursoRequestDTO);
    }

    @GetMapping
    public List<CursoResponseDTO> listarCursos() {
        return cursoService.listarCursos();
    }

    @GetMapping("/professor/{nome}")
    public List<CursoResponseDTO> listarCursosPorProfessorNome(@PathVariable String nome) {
        return cursoService.listarCursosPorProfessorNome(nome);
    }

    @GetMapping("/professor/{id}")
    public List<CursoResponseDTO> listarCursoPorProfessorId(@PathVariable Long id) {
        return cursoService.listarCursoPorProfessorId(id);
    }

    @GetMapping("/{id}")
    public CursoResponseDTO buscarPorId(@PathVariable Long id) {
        return cursoService.buscarPorId(id);
    }

    @GetMapping("/{nome}")
    public CursoResponseDTO buscarPorNomeCurso(@PathVariable String nome) {
        return cursoService.buscarPorNomeCurso(nome);
    }
}
