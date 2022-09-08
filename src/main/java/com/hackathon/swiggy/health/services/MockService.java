package com.hackathon.swiggy.health.utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import com.hackathon.swiggy.health.vo.TimeSeries;
import com.fasterxml.jackson.databind.*;

public class DataAccess {

    public static TimeSeries GetDataObject(String name) throws IOException {
        URL url = DataAccess.class.getResource("../../../../../mockdata/" + name + ".json");
        File file = new File(url.getPath());

        TimeSeries t = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            t = objectMapper.readValue(file, TimeSeries.class);
        } catch (Exception e) {
            System.out.println(e);
        }
        return t;

    }

    public static void main(String args[]) throws IOException {
        System.out.println(GetDataObject("googlefit"));
    }

}
