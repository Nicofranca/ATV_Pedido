package com.weg.pedido.controller;

import com.weg.pedido.dto.item.ItemPedidoRequestDTO;
import com.weg.pedido.dto.item.ItemPedidoResponseDTO;
import com.weg.pedido.service.ItemPedidoService;
import lombok.RequiredArgsConstructor;
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
        return ResponseEntity.ok(itemPedidoService.save(itemPedidoRequestDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemPedidoResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(itemPedidoService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<ItemPedidoResponseDTO>> findAll() {
        return ResponseEntity.ok(itemPedidoService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemPedidoResponseDTO> update(@PathVariable Long id, @RequestBody ItemPedidoRequestDTO itemPedidoRequestDTO) {
        return ResponseEntity.ok(itemPedidoService.update(id, itemPedidoRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ItemPedidoResponseDTO> delete(@PathVariable Long id) {
        return ResponseEntity.ok(itemPedidoService.delete(id));
    }
}
