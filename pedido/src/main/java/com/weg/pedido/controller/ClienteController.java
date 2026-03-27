package com.weg.pedido.controller;

import com.weg.pedido.dto.cliente.dtos.ClienteRequestDto;
import com.weg.pedido.dto.cliente.dtos.ClienteResponseDto;
import com.weg.pedido.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<ClienteResponseDto> save(@RequestBody ClienteRequestDto clienteRequestDto) {
        return ResponseEntity.ok(clienteService.save(clienteRequestDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponseDto>> findAll() {
        return ResponseEntity.ok(clienteService.findAll());
    }
}
