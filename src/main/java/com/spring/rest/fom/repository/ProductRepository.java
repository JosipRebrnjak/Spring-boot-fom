package com.spring.rest.fom.repository;

import com.spring.rest.fom.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    boolean existsByCode(String code);

    List<Product> findByCodeContainingIgnoreCase(String code);

    List<Product> findByNameContainingIgnoreCase(String name);

    List<Product> findByCodeContainingIgnoreCaseAndNameContainingIgnoreCase(String code, String name);
}
