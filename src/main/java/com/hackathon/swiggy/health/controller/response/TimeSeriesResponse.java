package com.hackathon.swiggy.health.controller.response;

import com.hackathon.swiggy.health.vo.TimeSeries;

import java.util.ArrayList;
import java.util.List;

public class TimeSeriesResponse {

    private List<Integer> steps;
    public List<Integer> getSteps() { return steps; }
    public void setSteps(List<Integer> steps) { this.steps = steps; }

    public TimeSeriesResponse(TimeSeries timeSeries) {
        this.steps = new ArrayList<>();
        timeSeries.dayData.forEach((x,y) -> {
            steps.add(y);
        });
    }

}
