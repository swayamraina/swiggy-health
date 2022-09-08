package com.hackathon.swiggy.health.controller;

import com.hackathon.swiggy.health.controller.response.ItemRecommendationResponse;
import com.hackathon.swiggy.health.proprietry.ItemRecommendation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class RecommendationController {

    @Autowired
    private ItemRecommendation itemRecommendation;

    @GetMapping("/api/{user-id}/recommendation")
    public ItemRecommendationResponse getItemRecommendation(
            @PathVariable("user-id") String userId) {

        return itemRecommendation.getRecommendation(userId);
    }

    @GetMapping("/api/recommendation/create")
    public boolean createOffers() throws IOException {
        itemRecommendation.init();
        return true;
    }

}
