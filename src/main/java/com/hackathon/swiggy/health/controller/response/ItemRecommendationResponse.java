package com.hackathon.swiggy.health.controller.response;

import com.hackathon.swiggy.health.vo.Item;

import java.util.List;

public class ItemRecommendationResponse {

    private List<Item> swiggy;
    public List<Item> getSwiggy() { return swiggy; }

    private List<Item> funded;
    public List<Item> getFunded() { return funded; }

    public ItemRecommendationResponse(List<Item> swiggy, List<Item> funded) {
        this.swiggy = swiggy;
        this.funded = funded;
    }

}
