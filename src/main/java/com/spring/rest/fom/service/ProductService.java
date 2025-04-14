package com.spring.rest.fom.service;

import com.spring.rest.fom.dto.PopularProductDTO;
import com.spring.rest.fom.dto.ProductDTO;
import java.util.List;

public interface ProductService {
    ProductDTO createProduct(ProductDTO product);
    List<ProductDTO> getAllProducts(); 
    List<ProductDTO> getFilteredProducts(String code, String name);
    List<PopularProductDTO> getTop3PopularProducts();
}