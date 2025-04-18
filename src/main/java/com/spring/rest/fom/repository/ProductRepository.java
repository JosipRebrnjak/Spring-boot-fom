package com.spring.rest.fom.repository;

import com.spring.rest.fom.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    boolean existsByCode(String code);

/*
    //Ne koristimo, ali neka ostane kao primjer Spring Data auto generacije querya
    List<Product> findByCodeContainingIgnoreCase(String code);
    List<Product> findByNameContainingIgnoreCase(String name);
*/

    @Query("SELECT p FROM Product p WHERE " +
       "(:code IS NULL OR LOWER(p.code) LIKE LOWER(CONCAT('%', :code, '%'))) AND " +
       "(:name IS NULL OR LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%')))")
    List<Product> searchByFilters(String code, String name);
}
