package com.spring.rest.fom.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.spring.rest.fom.dto.HnbExchangeRateDTO;

import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

    private final RestTemplate restTemplate;

    public BigDecimal convertEurToUsd(BigDecimal eurAmount) {
        HnbExchangeRateDTO[] response = getExchangeRates();

        for (HnbExchangeRateDTO rate : response) {
            if ("USD".equals(rate.getValuta())) {
                BigDecimal srednjiTecaj = new BigDecimal(rate.getSrednjiTecaj().replace(",", "."));
                return eurAmount.multiply(srednjiTecaj).setScale(2, RoundingMode.HALF_UP);
            }
        }

        throw new RuntimeException("Tečaj za USD nije pronađen u HNB odgovoru.");
    }

    @Cacheable("hnbExchangeRates")
    public HnbExchangeRateDTO[] getExchangeRates() {
        String url = "https://api.hnb.hr/tecajn-eur/v3";
        try {
            return restTemplate.getForObject(url, HnbExchangeRateDTO[].class);
        } catch (Exception e) {
            throw new RuntimeException("Greška prilikom dohvaćanja tečaja od HNB-a", e);
        }
    }
}
