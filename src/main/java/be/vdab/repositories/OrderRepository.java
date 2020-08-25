package be.vdab.repositories;

import be.vdab.domain.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderRepository {
    private List<Order> orders = new ArrayList<Order>();

    public List<Order> getOrders() {
        return orders;
    }
    public void addOrder(Order order){
        orders.add(order);
    }

    public void deleteOrder(Order order) {
        orders.remove(order);
    }

    public void update(Order order) {
        orders = orders.stream().map(order1 -> {
            if (order1.getOrderNumber().equals(order.getOrderNumber())) {
                order1.setPrice(order.getPrice());
                order1.setName(order.getName());
            }
            return order1;
        }).collect(Collectors.toList());

    }
}
