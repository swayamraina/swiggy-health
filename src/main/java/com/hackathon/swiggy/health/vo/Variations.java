package com.hackathon.swiggy.health.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Variations {
    public String id;
    public String display_name;
    public Price price;
    public String quantity;
    public String unit_of_measure;

    public Variations() {}
}
