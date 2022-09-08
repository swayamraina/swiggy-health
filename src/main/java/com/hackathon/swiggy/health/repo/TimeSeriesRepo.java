package com.hackathon.swiggy.health.repo;

import com.hackathon.swiggy.health.vo.TimeRange;
import com.hackathon.swiggy.health.vo.TimeSeries;
import com.hackathon.swiggy.health.vo.timeseries.DayData;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TimeSeriesRepo {

    private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    Map<String, TimeSeries> userIdToTimeSeries = new HashMap<>();

    public void init() {

    }


    // day = yyyy-MM-dd
    public void add(String userId, String day, DayData dayData) {
        TimeSeries userTimeSeries = userIdToTimeSeries.get(userId);
        userTimeSeries.dayData.put(day, dayData);
    }

    public TimeSeries get(String userId, TimeRange range) {
        TimeSeries userTimeSeries = userIdToTimeSeries.get(userId);
        switch (range) {
            case TODAY: return getToday(userTimeSeries);
            case WEEK: return getLastSevenDays(userTimeSeries);
            case MONTH: return getLastThirtyDays(userTimeSeries);
        }
        return getToday(userTimeSeries);
    }

    public TimeSeries getToday(TimeSeries timeSeries) {
        Date now = Calendar.getInstance().getTime();
        String key = dateFormat.format(now);

        DayData dayData = timeSeries.dayData.get(key);
        TimeSeries ts = new TimeSeries();

        ts.dayData.put(key, dayData);
        return ts;
    }

    public TimeSeries getLastSevenDays(TimeSeries timeSeries) {
        final Calendar cal = Calendar.getInstance();
        TimeSeries ts = new TimeSeries();
        for (int i=0; i<=7; i++) {
            cal.add(Calendar.DATE, i);
            Date date = cal.getTime();
            String key = dateFormat.format(date);
            DayData dayData = timeSeries.dayData.get(key);
            ts.dayData.put(key, dayData);
        }
        return ts;
    }

    public TimeSeries getLastThirtyDays(TimeSeries timeSeries) {
        final Calendar cal = Calendar.getInstance();
        TimeSeries ts = new TimeSeries();
        for (int i=0; i<=30; i++) {
            cal.add(Calendar.DATE, i);
            Date date = cal.getTime();
            String key = dateFormat.format(date);
            DayData dayData = timeSeries.dayData.get(key);
            ts.dayData.put(key, dayData);
        }
        return ts;
    }

}
