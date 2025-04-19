package com.spring.rest.fom.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PopularProductDTO {
    private String code; 
    private String name;
    private Double averageRating;
    private String formatedRating;
    private BigDecimal priceEur;
}
