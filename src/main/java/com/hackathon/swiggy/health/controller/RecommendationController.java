package com.hackathon.swiggy.health.controller;

import com.hackathon.swiggy.health.proprietry.ItemRecommendation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecommendationController {

    @Autowired
    private ItemRecommendation itemRecommendation;

    @GetMapping("/api/{user-id}/recommendation")
    public void getItemRecommendation(
            @PathVariable("user-id") String userId) {

        itemRecommendation.getRecommendation(userId);
    }

}
