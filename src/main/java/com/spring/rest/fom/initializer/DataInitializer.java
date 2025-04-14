package com.spring.rest.fom.initializer;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.spring.rest.fom.entity.Product;
import com.spring.rest.fom.entity.Review;
import com.spring.rest.fom.repository.ProductRepository;
import com.spring.rest.fom.repository.ReviewRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public void run(String... args) throws Exception {
        // Provjeriti postoje li već podaci u bazi kako bi spriječili dupliciranje
        if (productRepository.count() == 0) {
            /*
            Product product1 = new Product("123456789012345", "Product 1", BigDecimal.valueOf(100), BigDecimal.valueOf(110), "Description 1");
            Product product2 = new Product("123456789012346", "Product 2", BigDecimal.valueOf(150), BigDecimal.valueOf(165), "Description 2");
            Product product3 = new Product("123456789012347", "Product 3", BigDecimal.valueOf(200), BigDecimal.valueOf(220), "Description 3");
            Product product4 = new Product("123456789012348", "Product 4", BigDecimal.valueOf(300), BigDecimal.valueOf(330), "Description 4");
            Product product5 = new Product("123456789012349", "Product 5", BigDecimal.valueOf(400), BigDecimal.valueOf(440), "Description 5");
             */

            // Insert predefiniranih podataka za proizvode, koristimo var koji je omogućen nakon jave 10. Nosio je JavaScript od njegovih začetaka, a sad ga svi izbjegavaju samo zato što ima mušice.
            var product1 = new Product("123456789012345", "Product 1", BigDecimal.valueOf(100), BigDecimal.valueOf(110), "Description 1", "EUR");
            var product2 = new Product("123456789012346", "Product 2", BigDecimal.valueOf(150), BigDecimal.valueOf(165), "Description 2", "EUR");
            var product3 = new Product("123456789012347", "Product 3", BigDecimal.valueOf(200), BigDecimal.valueOf(220), "Description 3", "EUR");
            var product4 = new Product("123456789012348", "Product 4", BigDecimal.valueOf(300), BigDecimal.valueOf(330), "Description 4", "EUR");
            var product5 = new Product("123456789012349", "Product 5", BigDecimal.valueOf(400), BigDecimal.valueOf(440), "Description 5", "EUR");

            // Spremanje proizvoda u bazu
            productRepository.save(product1);
            productRepository.save(product2);
            productRepository.save(product3);
            productRepository.save(product4);
            productRepository.save(product5);

            /*
            Review review1 = new Review(product1, "Reviewer 1", "Great product!", 5);
            Review review2 = new Review(product1, "Reviewer 2", "Not bad, but can improve.", 3);
            Review review3 = new Review(product2, "Reviewer 3", "Amazing value for the price.", 5);
            Review review4 = new Review(product2, "Reviewer 4", "Could be better.", 4);
            Review review5 = new Review(product3, "Reviewer 5", "Average, nothing special.", 3);
            Review review6 = new Review(product3, "Reviewer 6", "Best purchase ever!", 5);
            Review review7 = new Review(product4, "Reviewer 7", "Good product but overpriced.", 4);
            Review review8 = new Review(product4, "Reviewer 8", "Really good quality.", 5);
            Review review9 = new Review(product5, "Reviewer 9", "Disappointed.", 2);
            Review review10 = new Review(product5, "Reviewer 10", "Excellent quality, highly recommend!", 5);
             */

            // Insert predefiniranih podataka za recenzije
            var review1 = new Review(product1, "Reviewer 1", "Great product!", 5);
            var review2 = new Review(product1, "Reviewer 2", "Not bad, but can improve.", 3);
            var review3 = new Review(product2, "Reviewer 3", "Amazing value for the price.", 5);
            var review4 = new Review(product2, "Reviewer 4", "Could be better.", 4);
            var review5 = new Review(product3, "Reviewer 5", "Average, nothing special.", 3);
            var review6 = new Review(product3, "Reviewer 6", "Best purchase ever!", 5);
            var review7 = new Review(product4, "Reviewer 7", "Good product but overpriced.", 4);
            var review8 = new Review(product4, "Reviewer 8", "Really good quality.", 5);
            var review9 = new Review(product5, "Reviewer 9", "Disappointed.", 2);
            var review10 = new Review(product5, "Reviewer 10", "Excellent quality, highly recommend!", 5);

            // Spremanje recenzija u bazu
            reviewRepository.save(review1);
            reviewRepository.save(review2);
            reviewRepository.save(review3);
            reviewRepository.save(review4);
            reviewRepository.save(review5);
            reviewRepository.save(review6);
            reviewRepository.save(review7);
            reviewRepository.save(review8);
            reviewRepository.save(review9);
            reviewRepository.save(review10);

            System.out.println("Predefinirani podaci su uspješno uneseni.");
        }
    }
}