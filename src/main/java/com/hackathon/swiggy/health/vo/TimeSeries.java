package com.hackathon.swiggy.health.vo;

import com.hackathon.swiggy.health.vo.timeseries.DayData;
import com.hackathon.swiggy.health.vo.timeseries.HourData;

import java.util.HashMap;
import java.util.Map;

public class TimeSeries {

    // key = 2022-09-25
    public Map<String, Integer> dayData;

    public TimeSeries() {
        // Map<String, HourData> hourDataMap = new HashMap<>();
        this.dayData = new HashMap<>();
    }

}
