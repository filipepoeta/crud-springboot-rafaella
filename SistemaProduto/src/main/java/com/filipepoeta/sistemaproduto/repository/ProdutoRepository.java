package com.filipepoeta.sistemaproduto.repository;

import com.filipepoeta.sistemaproduto.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {
}
