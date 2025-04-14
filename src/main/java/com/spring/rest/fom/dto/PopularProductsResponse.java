package com.spring.rest.fom.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PopularProductsResponse {
    private List<PopularProductDTO> popularProducts;
}
