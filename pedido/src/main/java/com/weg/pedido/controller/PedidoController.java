package com.weg.pedido.controller;

import com.weg.pedido.dto.pedido.PedidoRequestDTO;
import com.weg.pedido.dto.pedido.PedidoResponseDTO;
import com.weg.pedido.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<PedidoResponseDTO> save(@RequestBody PedidoRequestDTO pedidoRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(pedidoService.save(pedidoRequestDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(pedidoService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<PedidoResponseDTO>> findAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(pedidoService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoResponseDTO> update(@PathVariable Long id, @RequestBody PedidoRequestDTO pedidoRequestDTO) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(pedidoService.update(id, pedidoRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PedidoResponseDTO> delete(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body(pedidoService.delete(id));
    }
}
