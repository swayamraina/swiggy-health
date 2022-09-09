package com.hackathon.swiggy.health.services;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import com.hackathon.swiggy.health.vo.Recommendation;
import com.hackathon.swiggy.health.vo.Rewards;
import com.hackathon.swiggy.health.vo.TimeSeries;
import com.fasterxml.jackson.databind.*;
import org.springframework.stereotype.Service;

@Service
public class MockService {

    public TimeSeries getTimeSeriesDataFromMock(String name) throws IOException {
        File file = getFileFromResources(name);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(file, TimeSeries.class);
    }

    public Recommendation getBrandRecommendations() throws IOException {
        File file = getFileFromResources("brand-recommendation");
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(file, Recommendation.class);
    }

    public Recommendation getSwiggyRecommendations() throws IOException {
        File file = getFileFromResources("swiggy-recommendation");
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(file, Recommendation.class);
    }

    public Rewards getRewards() throws IOException {
        File file = getFileFromResources("rewards");
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(file, Rewards.class);
    }

    private File getFileFromResources(String name)  {
        URL url = this.getClass().getResource("../../../../../mockdata/" + name + ".json");
        return new File(url.getPath());
    }


}
