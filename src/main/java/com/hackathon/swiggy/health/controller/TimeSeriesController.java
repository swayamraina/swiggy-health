package com.hackathon.swiggy.health.controller;

import com.hackathon.swiggy.health.controller.response.TimeSeriesResponse;
import com.hackathon.swiggy.health.repo.TimeSeriesRepo;
import com.hackathon.swiggy.health.vo.TimeRange;
import com.hackathon.swiggy.health.vo.TimeSeries;

public class TimeSeriesController {

    private TimeSeriesRepo timeSeriesRepo;

    public TimeSeriesResponse get(String userId, int type) {
        TimeSeries timeSeries = timeSeriesRepo.get(userId, TimeRange.get(type));
        return new TimeSeriesResponse(timeSeries);
    }

}
