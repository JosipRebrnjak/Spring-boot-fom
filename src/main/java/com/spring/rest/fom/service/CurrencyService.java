package com.spring.rest.fom.service;

import java.math.BigDecimal;

public interface CurrencyService {
      BigDecimal convertEurToUsd(BigDecimal eurAmount);
}
