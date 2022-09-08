package com.hackathon.swiggy.health.vo;

import java.util.Map;

public class TimeSeries {

    // key = 2022-09-25
    public Map<String, DayData> dayData;

}

class DayData {

    // key = 15
    public Map<String, HourData> hourData;

}

class HourData {

    public int steps;

}
