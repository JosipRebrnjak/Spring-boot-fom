package com.spring.rest.fom.service;

import java.util.List;

import com.spring.rest.fom.dto.ReviewDTO;

public interface ReviewService {
   ReviewDTO createReview(ReviewDTO review);
   List<ReviewDTO> getAllReviewsByProduct(Long productId);
}
