package com.filipepoeta.sistemaproduto.service;

import com.filipepoeta.sistemaproduto.entity.Produto;
import com.filipepoeta.sistemaproduto.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {
    private final  ProdutoRepository produtoRepository;

    @Transactional
    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Transactional(readOnly = true)
    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Produto não encontrado.")
        );
    }

    @Transactional
    public Produto editarPreco(Long id, BigDecimal preco) {
        Produto produto = buscarPorId(id);
        produto.setPreco(preco);
        return produto;
    }

    @Transactional(readOnly = true)
    public List<Produto> buscarTodos() {
        return produtoRepository.findAll();
    }

    @Transactional
    public void deletarProduto(Long id){
        Produto produto = buscarPorId(id);
         produtoRepository.delete(produto);
    }
}
