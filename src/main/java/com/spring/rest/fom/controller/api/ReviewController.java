package com.spring.rest.fom.controller.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.fom.dto.ReviewDTO;
import com.spring.rest.fom.response.ApiResponse;
import com.spring.rest.fom.service.ReviewService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/{productId}")
    public ResponseEntity<ApiResponse<ReviewDTO>> createReview(@PathVariable Long productId,
            @Valid @RequestBody ReviewDTO reviewDTO) {
        ReviewDTO createdReview = reviewService.createReview(reviewDTO);
        ApiResponse<ReviewDTO> response = new ApiResponse<>(
                true,
                "Recenzija uspješno kreirana.",
                createdReview);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ApiResponse<List<ReviewDTO>>> getAllReviewsByProduct(@PathVariable Long productId) {
        List<ReviewDTO> reviews = reviewService.getAllReviewsByProduct(productId);
        ApiResponse<List<ReviewDTO>> response = new ApiResponse<>(
                true,
                "Uspješno dohvaćene recenzije.",
                reviews);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
