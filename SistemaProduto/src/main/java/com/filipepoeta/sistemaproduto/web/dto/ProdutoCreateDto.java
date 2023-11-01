package com.filipepoeta.sistemaproduto.web.dto;

import lombok.*;

import java.math.BigDecimal;
@Getter
@Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class ProdutoCreateDto {
    private String nome;
    private BigDecimal preco;
    private String descricao;
    private Integer quantidade;
}
