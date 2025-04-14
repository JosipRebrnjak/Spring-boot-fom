package com.spring.rest.fom.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.rest.fom.dto.PopularProductDTO;
import com.spring.rest.fom.dto.ProductDTO;
import com.spring.rest.fom.service.ProductService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/thyme")
@RequiredArgsConstructor
public class ProductWebController {
    private final ProductService productService;

    @GetMapping("/create")
    public String showProductForm(Model model) {
        model.addAttribute("productDTO", new ProductDTO());
        return "create-product";
    }

    @PostMapping("/create")
    public String createProduct(@ModelAttribute ProductDTO productDTO, Model model) {
        try {
            productService.createProduct(productDTO);
            model.addAttribute("successMessage", "Proizvod je uspješno dodan!");
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Greška prilikom unosa proizvoda.");
        }
        return "create-product";
    }

    @GetMapping("/filter")
    public String showFilteredProducts(
            @RequestParam(required = false) String code,
            @RequestParam(required = false) String name,
            Model model) {

        List<ProductDTO> filteredProducts = productService.getFilteredProducts(code, name);
        model.addAttribute("products", filteredProducts);
        model.addAttribute("code", code);
        model.addAttribute("name", name);
        return "product-filter";
    }

    @GetMapping("/popular-products")
    public String showPopularProducts(Model model) {
        List<PopularProductDTO> popularProducts = productService.getTop3PopularProducts();
        model.addAttribute("popularProducts", popularProducts);
        return "popular-products";
    }
}
