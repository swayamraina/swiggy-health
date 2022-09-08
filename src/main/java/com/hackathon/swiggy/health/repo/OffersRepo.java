package com.hackathon.swiggy.health.repo;

import com.hackathon.swiggy.health.services.MockService;
import com.hackathon.swiggy.health.vo.Item;
import com.hackathon.swiggy.health.vo.Recommendation;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class OffersRepo {

    private static int minOffers = 3;
    private static int buffer = 5;

    private Map<Integer, Item> brandFundedOffers = new HashMap<>();
    private Map<Integer, Item> swiggyFundedOffers = new HashMap<>();

    @Autowired
    private MockService mockService;

    public void init() throws IOException {
        int counter = 1;
        Recommendation brand = mockService.getBrandRecommendations();
        for (int i=0; i<brand.items.size(); i++) {
            brandFundedOffers.put(counter++, brand.items.get(i));
        }

        counter = 1;
        Recommendation swiggy = mockService.getSwiggyRecommendations();
        for (int i=0; i<swiggy.items.size(); i++) {
            swiggyFundedOffers.put(counter++, swiggy.items.get(i));
        }
    }

    public Pair<List<Item>, List<Item>> generateRecommendation(int score) {
        int totalOffers = ThreadLocalRandom.current().nextInt(minOffers, minOffers + buffer);
        List<Item> funded = generateBrandedRecommendation(0, totalOffers/2);
        List<Item> swiggy = generateSwiggyRecommendation(0, totalOffers/2);
        return new Pair<>(funded, swiggy);
    }

    private List<Item> generateBrandedRecommendation(int score, int totalOffers) {
        return generateXRecommendation(score, totalOffers, brandFundedOffers);
    }

    private List<Item> generateSwiggyRecommendation(int score, int totalOffers) {
        return generateXRecommendation(score, totalOffers, swiggyFundedOffers);
    }

    private List<Item> generateXRecommendation(int score, int totalOffers, Map<Integer, Item> xRecommendation) {
        Set<Integer> used = new HashSet<>();
        List<Item> response = new ArrayList<>();
        int x = ThreadLocalRandom.current().nextInt(1, totalOffers);
        for (int i=0; i<x; i++) {
            int index = ThreadLocalRandom.current().nextInt(0, xRecommendation.size()-1);
            if (used.contains(index)) {
                continue;
            }
            response.add(xRecommendation.get(index));
            used.add(index);
        }
        return response;
    }

}
