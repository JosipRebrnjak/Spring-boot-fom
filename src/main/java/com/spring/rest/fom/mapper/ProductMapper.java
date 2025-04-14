package com.spring.rest.fom.mapper;

import com.spring.rest.fom.dto.ProductDTO;
import com.spring.rest.fom.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring", uses = ReviewMapper.class)
public interface ProductMapper {

    
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class); 

    @Mapping(target = "code", source = "product.code") 
    @Mapping(target = "name", source = "product.name")
    @Mapping(target = "priceEur", source = "product.priceEur")
    @Mapping(target = "priceUsd", source = "product.priceUsd")
    @Mapping(target = "currency", source = "product.currency")
    @Mapping(target = "description", source = "product.description")
    @Mapping(target = "reviews", source = "reviews")
    ProductDTO toDTO(Product product);
    
    Product toEntity(ProductDTO dto);
}