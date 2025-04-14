package com.spring.rest.fom.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.spring.rest.fom.dto.ReviewDTO;
import com.spring.rest.fom.entity.Product;
import com.spring.rest.fom.entity.Review;


@Mapper(componentModel = "spring")
public interface ReviewMapper {

    @Mapping(source = "product.id", target = "productId")
    ReviewDTO toDTO(Review review);

    @Mapping(source = "productId", target = "product")
    Review toEntity(ReviewDTO dto);

    //"helper" metoda za MapStruct
    default Product mapProduct(Long id) {
        if (id == null) return null;
        Product product = new Product();
        product.setId(id);
        return product;
    }
}
