package com.hackathon.swiggy.health.vo;


import java.util.HashMap;
import java.util.Map;

public class TimeSeries {

    // key = 2022-09-25
    public Map<String, Integer> dayData;

    public TimeSeries() {
        this.dayData = new HashMap<>();
    }

}
