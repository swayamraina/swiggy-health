package com.hackathon.swiggy.health.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Price {
    public String mrp;
    public String store_price;
    public String offer_price;

    public Price() {}
}
