package be.vdab.services;

import be.vdab.domain.Order;
import be.vdab.repositories.OrderRepository;

import java.util.List;

public class OrderService {
    OrderRepository orderRepository = new OrderRepository();

    public List<Order> getOrder(){
        return orderRepository.getOrders();
    }
    public void addOrder(Order order) {
        calculateReduction(order);
        order.setOrderNumber(String.valueOf((int) (Math.random() * 100) + "ABC"));
        orderRepository.addOrder(order);
    }

    private void calculateReduction(Order order) {
        order.setPrice(order.getPrice()-(order.getPrice()*(35.0/100.0)));
    }
}
