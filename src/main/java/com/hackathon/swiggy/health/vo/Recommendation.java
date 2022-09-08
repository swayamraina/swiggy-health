package com.hackathon.swiggy.health.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Recommendation {

    public List<Item> items;

}




