package com.spring.rest.fom.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService{

    private final RestTemplate restTemplate;

    public BigDecimal convertEurToUsd(BigDecimal eurAmount) {
        String url = "https://api.hnb.hr/tecajn/v3?valuta=USD";

        try {
            // Primamo niz mapa jer HNB vraća JSON array
            var response = restTemplate.getForObject(url, Map[].class);
            if (response != null && response.length > 0) {
                String rateString = ((String) response[0].get("srednji_tecaj")).replace(",", ".");
                BigDecimal rate = new BigDecimal(rateString);
                return eurAmount.divide(rate, 2, RoundingMode.HALF_UP);
            }
        } catch (Exception e) {
            throw new RuntimeException("Greška prilikom dohvaćanja tečaja od HNB-a", e);
        }

        throw new RuntimeException("Neuspješan dohvat tečaja za USD");
    }
}
