package com.spring.rest.fom.response;

import java.util.List;

import com.spring.rest.fom.dto.PopularProductDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Deprecated
@Getter
@Setter
@AllArgsConstructor
public class PopularProductsResponse {
    private List<PopularProductDTO> popularProducts;
}
