package com.spring.rest.fom.projection;

import java.math.BigDecimal;

//Automatsko mapiranje rezultata querya direktno iz baze u objekt
public interface PopularProductProjection {
    String getName();
    Double getAverageRating();
    String getCode();
    BigDecimal getPriceEur();
}
