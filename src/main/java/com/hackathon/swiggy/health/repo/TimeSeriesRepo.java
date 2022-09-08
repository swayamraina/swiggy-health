package com.hackathon.swiggy.health.repo;

import com.hackathon.swiggy.health.services.MockService;
import com.hackathon.swiggy.health.vo.TimeRange;
import com.hackathon.swiggy.health.vo.TimeSeries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class TimeSeriesRepo {

    private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    Map<String, TimeSeries> userIdToTimeSeries = new HashMap<>();

    @Autowired
    private MockService mockService;

    @PostConstruct
    public void init() throws IOException {
        TimeSeries timeSeries = mockService.getTimeSeriesDataFromMock("googlefit-daily");
        userIdToTimeSeries.put("1", timeSeries);
    }


    // day = yyyy-MM-dd
    public void add(String userId, String day, Integer dayData) {
        TimeSeries userTimeSeries = userIdToTimeSeries.get(userId);
        Integer steps = userTimeSeries.dayData.get(day);
        if (Objects.isNull(steps)) {
            steps = 0;
        }
        userTimeSeries.dayData.put(day, steps+dayData);
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

        int steps = timeSeries.dayData.get(key);
        TimeSeries ts = new TimeSeries();

        ts.dayData.put(key, steps);
        return ts;
    }

    public TimeSeries getLastSevenDays(TimeSeries timeSeries) {
        TimeSeries ts = new TimeSeries();
        for (int i=0; i<7; i++) {
            final Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, -i);
            Date date = cal.getTime();
            String key = dateFormat.format(date);
            int steps = timeSeries.dayData.get(key);
            ts.dayData.put(key, steps);
        }
        return ts;
    }

    public TimeSeries getLastThirtyDays(TimeSeries timeSeries) {
        TimeSeries ts = new TimeSeries();
        for (int i=0; i<30; i++) {
            final Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, -i);
            Date date = cal.getTime();
            String key = dateFormat.format(date);
            int steps = timeSeries.dayData.get(key);
            ts.dayData.put(key, steps);
        }
        return ts;
    }

}
