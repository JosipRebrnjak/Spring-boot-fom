package com.spring.rest.fom.mapper;

import com.spring.rest.fom.dto.ProductDTO;
import com.spring.rest.fom.entity.Product;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDTO toDTO(Product product);
    Product toEntity(ProductDTO dto);
}