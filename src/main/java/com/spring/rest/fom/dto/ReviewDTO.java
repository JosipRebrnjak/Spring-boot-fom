package com.spring.rest.fom.dto;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDTO {

    @NotBlank(message = "Id produkta ne smije biti prazan.")
    private Long productId;
    private String productName;

    @NotBlank(message = "Ime ne smije biti prazno.")
    private String reviewer;

    @NotBlank(message = "Tekst ne smije biti prazan.")
    private String text;

    @NotNull(message = "Ocjena mora biti zadana.")
    @Min(value = 1, message = "Ocjena  mora biti veća od 1.")
    @Max(value = 10, message = "Ocjena mora biti manja ili jednaka 10.")
    private int rating;
}

