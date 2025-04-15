package com.spring.rest.fom.projection;

//Automatsko mapiranje rezultata querya direktno iz baze u objekt
public interface PopularProductProjection {
    String getName();
    Double getAverageRating();
}
