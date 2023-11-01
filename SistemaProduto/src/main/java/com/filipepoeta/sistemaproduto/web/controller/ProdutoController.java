package com.filipepoeta.sistemaproduto.web.controller;

import com.filipepoeta.sistemaproduto.entity.Produto;
import com.filipepoeta.sistemaproduto.service.ProdutoService;
import com.filipepoeta.sistemaproduto.web.dto.ProdutoCreateDto;
import com.filipepoeta.sistemaproduto.web.dto.ProdutoResponseDto;
import com.filipepoeta.sistemaproduto.web.dto.ProdutoUpdatePrecoDto;
import com.filipepoeta.sistemaproduto.web.dto.mapper.ProdutoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/produtos")
public class ProdutoController {
    private final ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<ProdutoResponseDto> create(@RequestBody ProdutoCreateDto createDto) {
        Produto prod = produtoService.salvar(ProdutoMapper.toProduto(createDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(ProdutoMapper.toDto(prod));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDto> getById(@PathVariable Long id) {
        Produto prod = produtoService.buscarPorId(id);
        return ResponseEntity.ok(ProdutoMapper.toDto(prod));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updatePreco(@PathVariable Long id, @RequestBody ProdutoUpdatePrecoDto dto) {
        Produto prod = produtoService.editarPreco(id, dto.getPreco());
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponseDto>> getAll() {
        List<Produto> prods = produtoService.buscarTodos();
        return ResponseEntity.ok(ProdutoMapper.toListDto(prods));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable Long id){
         produtoService.deletarProduto(id);
        return ResponseEntity.noContent().build();

    }
}
