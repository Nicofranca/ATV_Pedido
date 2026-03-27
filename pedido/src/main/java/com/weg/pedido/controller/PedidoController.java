package com.weg.pedido.controller;


import com.weg.pedido.dto.pedido.dtos.PedidoDescricaoRequestDto;
import com.weg.pedido.dto.pedido.dtos.PedidoRequestDto;
import com.weg.pedido.dto.pedido.dtos.PedidoResponseDto;
import com.weg.pedido.service.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public ResponseEntity<PedidoResponseDto> save(@RequestBody PedidoRequestDto pedidoRequestDto) {
        return ResponseEntity.ok(pedidoService.save(pedidoRequestDto));
    }

    @GetMapping("/cliente/{id}")
    public List<PedidoResponseDto> findByClienteId(@PathVariable Long id) {
        return pedidoService.findByClienteId(id);
    }

    @GetMapping("/{id}")
    public List<PedidoResponseDto> findByPedidoId(@PathVariable Long id) {
        return pedidoService.findByPedidoId(id);
    }

    @GetMapping("/{nome}")
    public List<PedidoResponseDto> findByClienteNome(@PathVariable String nome) {
        return pedidoService.findByClienteNome(nome);
    }

    @GetMapping
    public PedidoResponseDto findByIdAndDescricao(PedidoDescricaoRequestDto pedidoDescricaoRequestDto) {
        return pedidoService.findByIdAndDescricao(pedidoDescricaoRequestDto);
    }
}
