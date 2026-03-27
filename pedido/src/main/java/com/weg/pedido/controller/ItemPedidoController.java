package com.weg.pedido.controller;

import com.weg.pedido.dto.item.ItemPedidoRequestDTO;
import com.weg.pedido.dto.item.ItemPedidoResponseDTO;
import com.weg.pedido.service.ItemPedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itens")
@RequiredArgsConstructor
public class ItemPedidoController {
    private final ItemPedidoService itemPedidoService;

    @PostMapping
    public ResponseEntity<ItemPedidoResponseDTO> save(@RequestBody ItemPedidoRequestDTO itemPedidoRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(itemPedidoService.save(itemPedidoRequestDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemPedidoResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(itemPedidoService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<ItemPedidoResponseDTO>> findAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(itemPedidoService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemPedidoResponseDTO> update(@PathVariable Long id, @RequestBody ItemPedidoRequestDTO itemPedidoRequestDTO) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(itemPedidoService.update(id, itemPedidoRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ItemPedidoResponseDTO> delete(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body(itemPedidoService.delete(id));
    }
}
