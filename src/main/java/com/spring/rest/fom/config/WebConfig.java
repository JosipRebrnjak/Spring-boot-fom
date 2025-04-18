package com.spring.rest.fom.config;

import org.springframework.lang.NonNull;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(@NonNull CorsRegistry registry) {
        // Omogućava CORS za sve putanje
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:5173") // frontend URL
                .allowedMethods("GET", "POST", "PUT", "DELETE") // dozvoljene HTTP metode
                .allowedHeaders("*") // dozvoljava sve zaglavlja
                .allowCredentials(true); // opcionalno, ako se koriste cookies/sesije
    }

}