package com.hackathon.swiggy.health.repo;

import com.hackathon.swiggy.health.Errors;
import com.hackathon.swiggy.health.vo.Order;
import com.hackathon.swiggy.health.vo.OrderType;

import java.util.*;

public class OrderRepo {

    Map<String, List<Order>> userIdToFoodOrdersMappings = new HashMap<>();
    Map<String, List<Order>> userIdToIMOrdersMappings = new HashMap<>();
    Map<String, List<Order>> userIdToGuiltFreeOrdersMappings = new HashMap<>();

    Map<String, Order> orderIdToOrderMapping=  new HashMap<>();
    Map<String, List<Order>> userIdToOrdersMappings = new HashMap<>();

    Map<String, List<Order>> orderIdToNextOrderAdditionMapping=  new HashMap<>();

    public void create(String userId, Order order) {
        // add to overall orders
        orderIdToOrderMapping.put(order.ID, order);

        // add to user orders
        addToOrderMapping(userId, order, userIdToOrdersMappings);

        // add to specific list
        Map<String, List<Order>> userIdToTypeXOrdersMapping = getMap(order.type);
        addToOrderMapping(userId, order, userIdToTypeXOrdersMapping);
    }

    public Order get(String orderId) {
        Order order = orderIdToOrderMapping.get(orderId);
        if (Objects.isNull(order)) {
            throw new Errors.OrderNotFound("order" + orderId + "not found");
        }
        return order;
    }

    public void addToNextOrder(String userId, Order order) {
        addToOrderMapping(userId, order, orderIdToNextOrderAdditionMapping);
    }




    ///// private methods

    private Map<String, List<Order>> getMap(OrderType type) {
        switch (type) {
            case IM: return userIdToIMOrdersMappings;
            case FOOD: return userIdToFoodOrdersMappings;
            case GUILT_FREE: return userIdToGuiltFreeOrdersMappings;

            default: return userIdToIMOrdersMappings;
        }
    }

    private void addToOrderMapping(String userId, Order order, Map<String, List<Order>> userIdToTypeXOrdersMapping) {
        List<Order> xOrders = userIdToTypeXOrdersMapping.get(userId);
        if (Objects.isNull(xOrders)) {
            xOrders = new ArrayList<>();
        }
        xOrders.add(order);
        userIdToTypeXOrdersMapping.put(userId, xOrders);
    }

}
