package com.hackathon.swiggy.health.proprietry;

import com.hackathon.swiggy.health.controller.response.ItemRecommendationResponse;
import com.hackathon.swiggy.health.repo.OffersRepo;
import com.hackathon.swiggy.health.repo.UserRepo;
import com.hackathon.swiggy.health.vo.Item;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ItemRecommendation {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private OffersRepo offersRepo;

    public ItemRecommendationResponse getRecommendation(String userId) {
        int score = userRepo.get(userId).score;
        Pair<List<Item>, List<Item>> pair = offersRepo.generateRecommendation(score);
        return new ItemRecommendationResponse(pair.getKey(), pair.getValue());
    }

    public void init() throws IOException {
        offersRepo.init();
    }

}
