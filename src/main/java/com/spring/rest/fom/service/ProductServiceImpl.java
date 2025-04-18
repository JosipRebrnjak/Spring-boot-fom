package com.spring.rest.fom.service;

import com.spring.rest.fom.dto.PopularProductDTO;
import com.spring.rest.fom.dto.ProductDTO;
import com.spring.rest.fom.entity.Product;
import com.spring.rest.fom.exception.ResourceNotFoundException;
import com.spring.rest.fom.mapper.ProductMapper;
import com.spring.rest.fom.projection.PopularProductProjection;
import com.spring.rest.fom.repository.ProductRepository;
import com.spring.rest.fom.repository.ReviewRepository;

import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ReviewRepository reviewRepository;
    private final ProductMapper productMapper;
    private final CurrencyService currencyService;
    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> products = (List<Product>) productRepository.findAll();
        return products.stream()
                       .map(productMapper::toDTO)
                       .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getFilteredProducts(String code, String name) {

        List<Product> products;

      
        products = productRepository.searchByFilters(code, name);

        if (products.isEmpty()) {
            throw new ResourceNotFoundException("Nema produkata koji odgovaraju filterima.");
        }

        // Ispis proizvoda prije nego što ih mapiramo u DTO
        products.forEach(product ->  logger.debug("Produkt prije mapiranja: " + product.getName()));


        return products.stream()
            .map(productMapper::toDTO)
            .toList();
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        // Provjeri postoji li već proizvod s istim kodom
        if (productRepository.existsByCode(productDTO.getCode())) {
            throw new ResourceNotFoundException("Proizvod s kodom " + productDTO.getCode() + " već postoji.");
        }

        // Postavi USD cijenu automatski
        BigDecimal eur = productDTO.getPriceEur();
        BigDecimal usd = currencyService.convertEurToUsd(eur);
        productDTO.setPriceUsd(usd);

        // Mapiraj ProductDTO u Product entitet
        Product product = productMapper.toEntity(productDTO);

        // Spremi proizvod u bazu
        Product savedProduct = productRepository.save(product);

        // Mapiraj spremljeni entitet u ProductDTO i vrati ga
        return productMapper.toDTO(savedProduct);
    }

    @Override
    public List<PopularProductDTO> getTop3PopularProducts() {
    List<PopularProductProjection> projections = reviewRepository.findTop3PopularProducts();

    return projections.stream()
        .map(p -> new PopularProductDTO(p.getName(), p.getAverageRating(),String.format("%.1f", p.getAverageRating())))
        .collect(Collectors.toList());
    }
}
