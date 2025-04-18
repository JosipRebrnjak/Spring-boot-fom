package com.spring.rest.fom.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "review")
public class Review {

    public Review(Product product, String reviewer, String text, int rating) {
        this.product = product;
        this.reviewer = reviewer;
        this.text = text;
        this.rating = rating;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @Column(name = "reviewer")
    private String reviewer;

    @Column(name = "text")
    private String text;

    @Min(value = 1, message = "Ocjena mora biti najmanje 1")
    @Max(value = 10, message = "Ocjena može biti najviše 10")
    @Column(name = "rating")
    private int rating;

}
