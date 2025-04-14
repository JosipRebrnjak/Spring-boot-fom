package com.spring.rest.fom.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class HnbExchangeRateDTO {

    private String drzava;

    @JsonProperty("drzava_iso")
    private String drzavaIso;

    @JsonProperty("sifra_valute")
    private String sifraValute;

    private String valuta;

    private String jedinica;

    @JsonProperty("kupovni_tecaj")
    private String kupovniTecaj;

    @JsonProperty("srednji_tecaj")
    private String srednjiTecaj;

    @JsonProperty("prodajni_tecaj")
    private String prodajniTecaj;

    private String datum;
}