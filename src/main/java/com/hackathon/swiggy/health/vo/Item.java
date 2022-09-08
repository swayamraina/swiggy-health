package com.hackathon.swiggy.health.vo;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {

    public String display_name;
    public List<Variations> variations;

    public Item () {}

}


