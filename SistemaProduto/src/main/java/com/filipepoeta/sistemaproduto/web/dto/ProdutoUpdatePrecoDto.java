package com.filipepoeta.sistemaproduto.web.dto;

import lombok.*;

import java.math.BigDecimal;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProdutoUpdatePrecoDto {
    private BigDecimal preco;
}
