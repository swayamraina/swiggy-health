package com.hackathon.swiggy.health.controller;

import com.hackathon.swiggy.health.controller.request.TimeSeriesRequest;
import com.hackathon.swiggy.health.controller.response.TimeSeriesResponse;
import com.hackathon.swiggy.health.repo.TimeSeriesRepo;
import com.hackathon.swiggy.health.vo.TimeRange;
import com.hackathon.swiggy.health.vo.TimeSeries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TimeSeriesController {

    @Autowired
    private TimeSeriesRepo timeSeriesRepo;

    @GetMapping("/api/{user-id}/timeseries/{type}")
    public TimeSeriesResponse get(
            @PathVariable("user-id") String userId,
            @PathVariable("type") int type) {

        TimeSeries timeSeries = timeSeriesRepo.get(userId, TimeRange.get(type));
        return new TimeSeriesResponse(timeSeries);
    }

    @PostMapping(value = "/api/{user-id}/timeseries", consumes = "application/json")
    public boolean add(
            @PathVariable("user-id") String userId,
            @RequestBody TimeSeriesRequest request) {

        timeSeriesRepo.add(userId, request.date, request.steps);
        return true;
    }

}
