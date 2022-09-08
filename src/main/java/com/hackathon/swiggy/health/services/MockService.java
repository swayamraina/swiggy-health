package com.hackathon.swiggy.health.services;

import java.io.File;
import java.io.IOException;
import java.net.URL;

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

    private File getFileFromResources(String name)  {
        URL url = this.getClass().getResource("../../../../../mockdata/" + name + ".json");
        return new File(url.getPath());
    }

}