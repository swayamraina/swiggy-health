package com.hackathon.swiggy.health.proprietry;

import com.hackathon.swiggy.health.repo.OrderRepo;
import com.hackathon.swiggy.health.repo.TimeSeriesRepo;
import com.hackathon.swiggy.health.vo.Order;
import com.hackathon.swiggy.health.vo.TimeRange;
import com.hackathon.swiggy.health.vo.TimeSeries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ScoreCalculator {

    @Autowired
    private TimeSeriesRepo timeSeriesRepo;

    @Autowired
    private OrderRepo orderRepo;

    public int getScore(String userId) {
        int steps = 0;
        TimeSeries timeSeries = timeSeriesRepo.get(userId, TimeRange.WEEK);
        for(Map.Entry<String, Integer> entry : timeSeries.dayData.entrySet()) {
            steps += entry.getValue();
        }

        List<Order> foodOrders = orderRepo.userIdToFoodOrdersMappings.get(userId);
        int foodOrdersCount = foodOrders==null ? 0 : foodOrders.size();

        List<Order> guiltfreeOrders = orderRepo.userIdToGuiltFreeOrdersMappings.get(userId);
        int guiltfreeOrdersCount = guiltfreeOrders==null ? 0 : guiltfreeOrders.size();

        return steps/500 - (foodOrdersCount - guiltfreeOrdersCount)*10;
    }

}
