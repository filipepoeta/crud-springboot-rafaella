package com.filipepoeta.sistemaproduto.web.dto.mapper;

import com.filipepoeta.sistemaproduto.entity.Produto;
import com.filipepoeta.sistemaproduto.web.dto.ProdutoCreateDto;
import com.filipepoeta.sistemaproduto.web.dto.ProdutoResponseDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import java.util.List;
import java.util.stream.Collectors;

public class ProdutoMapper {

    public static Produto toProduto(ProdutoCreateDto createDto) {
        return new ModelMapper().map(createDto, Produto.class);
    }

    public static ProdutoResponseDto toDto(Produto produto) {

        ModelMapper mapper = new ModelMapper();
        return mapper.map(produto, ProdutoResponseDto.class);
    }

    public static List<ProdutoResponseDto> toListDto(List<Produto> produtos) {
        return produtos.stream().map(prod -> toDto(prod)).collect(Collectors.toList());
    }
}
