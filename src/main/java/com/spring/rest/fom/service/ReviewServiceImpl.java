package com.spring.rest.fom.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.spring.rest.fom.dto.ReviewDTO;
import com.spring.rest.fom.entity.Product;
import com.spring.rest.fom.entity.Review;
import com.spring.rest.fom.exception.ResourceNotFoundException;
import com.spring.rest.fom.mapper.ReviewMapper;
import com.spring.rest.fom.repository.ProductRepository;
import com.spring.rest.fom.repository.ReviewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{

    private final ReviewRepository reviewRepository;
    private final ProductRepository productRepository;
    private final ReviewMapper reviewMapper;

    @Override
    public ReviewDTO createReview(ReviewDTO reviewDTO) {
        Product product = productRepository.findById(reviewDTO.getProductId())
            .orElseThrow(() -> new ResourceNotFoundException("Proizvod s ID-em " + reviewDTO.getProductId() + " nije pronađen."));

        Review review = reviewMapper.toEntity(reviewDTO);
        review.setProduct(product);

        Review savedReview = reviewRepository.save(review);
        return reviewMapper.toDTO(savedReview);
    }

    @Override
    public List<ReviewDTO> getAllReviewsByProduct(Long productId) {
        if (!productRepository.existsById(productId)) {
            throw new ResourceNotFoundException("Proizvod s ID-em " + productId + " nije pronađen.");
        }

        List<Review> reviews = reviewRepository.findByProductId(productId);
        return reviews.stream()
                      .map(reviewMapper::toDTO)
                      .collect(Collectors.toList());
    }

   
}
