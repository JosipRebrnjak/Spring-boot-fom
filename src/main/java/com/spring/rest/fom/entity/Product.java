package com.spring.rest.fom.entity;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {

    public Product(String code, String name, BigDecimal priceEur, BigDecimal priceUsd, String description, String unit) {
        this.code = code;
        this.name = name;
        this.priceEur = priceEur;
        this.priceUsd = priceUsd;
        this.description = description;
        this.unit=unit;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code", unique = true, length = 15)
    @Size(min = 15, max = 15, message = "Code mora imati tocno 15 znakova")
    @NotEmpty(message = "Code ne smije biti prazno.")
    private String code;

    @Column(name = "name")
    @NotEmpty(message = "Name ne smije biti prazno.")
    private String name;

    @Column(name = "price_eur")
    private BigDecimal priceEur;

    @Column(name = "price_usd")
    private BigDecimal priceUsd;

    @Column(name = "description")
    private String description;

    @Column(name = "unit")
    @NotEmpty(message = "Valuta ne smije biti prazna.")
    private String unit;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Review> reviews;

}
