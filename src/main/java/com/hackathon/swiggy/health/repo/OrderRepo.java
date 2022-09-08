package com.hackathon.swiggy.health.repo;

import com.hackathon.swiggy.health.Errors;
import com.hackathon.swiggy.health.vo.Order;
import com.hackathon.swiggy.health.vo.OrderType;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class OrderRepo {

    public static Object lock = new Object();

    public Map<String, List<Order>> userIdToFoodOrdersMappings = new HashMap<>();
    Map<String, List<Order>> userIdToIMOrdersMappings = new HashMap<>();
    public Map<String, List<Order>> userIdToGuiltFreeOrdersMappings = new HashMap<>();

    Map<String, Order> orderIdToOrderMapping=  new HashMap<>();
    Map<String, List<Order>> userIdToOrdersMappings = new HashMap<>();

    Map<String, List<Order>> userIdToNextOrderAdditionMapping=  new HashMap<>();

    public void create(String userId, Order order) {
        // add freebies: order already in cart
        List<Order> next = userIdToNextOrderAdditionMapping.get(userId);
        if (!Objects.isNull(next)) {
            next.forEach(x -> order.items.addAll(x.items));
        }
        // clear freebies
        userIdToNextOrderAdditionMapping.remove(userId);

        // add to overall orders
        orderIdToOrderMapping.put(order.Id, order);

        // add to user orders
        addToOrderMapping(userId, order, userIdToOrdersMappings);

        // add to specific list
        Map<String, List<Order>> userIdToTypeXOrdersMapping = getMap(order.type);
        addToOrderMapping(userId, order, userIdToTypeXOrdersMapping);
    }

    public String getID() {
        String id;
        synchronized (lock) {
            id = String.valueOf(System.currentTimeMillis());
        }
        return id;
    }

    public Order get(String userId, String orderId) {
        Order order = orderIdToOrderMapping.get(orderId);
        if (Objects.isNull(order)) {
            List<Order> next = userIdToNextOrderAdditionMapping.get(userId);
            Optional<Order> found = next.stream().filter(x -> x.Id.equals(orderId)).findFirst();
            if (found.isPresent()) {
                throw new Errors.OrderNotFound("order " + orderId + " currently present in cart");
            } else {
                throw new Errors.OrderNotFound("order " + orderId + " not found");
            }
        }
        return order;
    }

    public void addToNextOrder(String userId, Order order) {
        addToOrderMapping(userId, order, userIdToNextOrderAdditionMapping);
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
