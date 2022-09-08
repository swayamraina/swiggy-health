package com.hackathon.swiggy.health.repo;

import com.hackathon.swiggy.health.vo.Item;
import javafx.util.Pair;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class OffersRepo {

    private static int minOffers = 3;
    private static int buffer = 5;

    private Map<Integer, Item> brandFundedOffers = new HashMap<>();
    private Map<Integer, Item> swiggyFundedOffers = new HashMap<>();

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
        int funded = ThreadLocalRandom.current().nextInt(1, totalOffers);
        for (int i=0; i<funded; i++) {
            int index = ThreadLocalRandom.current().nextInt(1, xRecommendation.size());
            if (used.contains(index)) {
                continue;
            }
            response.add(xRecommendation.get(index));
            used.add(index);
        }
        return response;
    }

}
