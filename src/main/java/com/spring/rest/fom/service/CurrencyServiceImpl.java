package com.spring.rest.fom.service;

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
        String url = "https://api.hnb.hr/tecajn-eur/v3";

        try {
            HnbExchangeRateDTO[] response = restTemplate.getForObject(url, HnbExchangeRateDTO[].class);
            if (response != null) {
                for (HnbExchangeRateDTO rate : response) {
                    if ("USD".equals(rate.getValuta())) {
                        BigDecimal srednjiTecaj = new BigDecimal(rate.getSrednjiTecaj().replace(",", "."));
                        return eurAmount.multiply(srednjiTecaj).setScale(2, RoundingMode.HALF_UP);
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Greška prilikom dohvaćanja tečaja od HNB-a", e);
        }

        throw new RuntimeException("Tečaj za USD nije pronađen u HNB odgovoru.");
    }
}
