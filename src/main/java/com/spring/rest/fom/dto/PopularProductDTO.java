package com.spring.rest.fom.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PopularProductDTO {
    private String name;
    private Double averageRating;
    private String formatedRating;
}
