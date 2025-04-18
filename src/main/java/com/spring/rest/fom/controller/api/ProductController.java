package com.spring.rest.fom.controller.api;

import com.spring.rest.fom.dto.PopularProductDTO;
import com.spring.rest.fom.dto.ProductDTO;
import com.spring.rest.fom.response.ApiResponse;
import com.spring.rest.fom.response.PopularProductsResponse;
import com.spring.rest.fom.service.ProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/filter")
    public ResponseEntity<List<ProductDTO>> getFilteredProducts(
            @RequestParam(required = false) String code,
            @RequestParam(required = false) String name) {
        return ResponseEntity.ok(productService.getFilteredProducts(code, name));
    }

    /*
     * @GetMapping("/popular")
     * public ResponseEntity<ApiResponse<List<PopularProductDTO>>>
     * getPopularProducts() {
     * List<PopularProductDTO> popularProducts =
     * reviewService.getTop3PopularProducts();
     * 
     * ApiResponse<List<PopularProductDTO>> response = new ApiResponse<>(
     * true,
     * "Tri najpopularnija produkta dohvaćena.",
     * popularProducts
     * );
     * 
     * return ResponseEntity.ok(response);
     * }
     */

    // Ovako sam prilagodio response kako bih zadovoljavao uvjete zadanog zadatka, pravilniji je
    // response iznad
    @GetMapping("/popular")
    public ResponseEntity<PopularProductsResponse> getPopularProducts() {
        List<PopularProductDTO> topRated = productService.getTop3PopularProducts();
        PopularProductsResponse response = new PopularProductsResponse(topRated);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ProductDTO>> createProduct(@Valid @RequestBody ProductDTO productDTO) {
        ProductDTO createdProduct = productService.createProduct(productDTO);
        ApiResponse<ProductDTO> response = new ApiResponse<>(
                true,
                "Produkt uspješno kreiran.",
                createdProduct);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}