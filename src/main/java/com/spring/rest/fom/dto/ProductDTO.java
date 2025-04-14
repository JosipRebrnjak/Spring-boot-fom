package com.spring.rest.fom.dto;

import java.math.BigDecimal;
import java.util.List;


import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    @NotBlank(message = "Code ne smije biti prazan.")
    @Size(min = 15, max = 15, message = "Code mora imati točno 15 znakova.")
    private String code;

    @NotBlank(message = "Ime ne smije biti prazno.")
    private String name;

    @NotNull(message = "Cijena u EUR mora biti zadana.")
    @DecimalMin(value = "0.01", inclusive = true, message = "Cijena u EUR mora biti veća od 0.")
    private BigDecimal priceEur;

    private BigDecimal priceUsd;

    private String description;

    @NotBlank(message = "Unit of measure ne smije biti prazan.")
    @Pattern(regexp = "EUR|USD", message = "Dozvoljene valute su: EUR, USD")
    private String currency = "EUR";

    private List<ReviewDTO> reviews;
}
