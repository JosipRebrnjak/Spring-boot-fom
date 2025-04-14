package com.spring.rest.fom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.rest.fom.dto.PopularProductProjection;
import com.spring.rest.fom.entity.Review;
import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
   @Query(
    value = "SELECT p.name AS name, ROUND(AVG(r.rating), 1) AS averageRating " +
            "FROM review r JOIN product p ON r.product_id = p.id " +
            "GROUP BY p.id, p.name " +
            "ORDER BY averageRating DESC " +
            "LIMIT 3",
    nativeQuery = true)
    List<PopularProductProjection> findTop3PopularProducts();
    List<Review> findByProductId(Long productId);

}
