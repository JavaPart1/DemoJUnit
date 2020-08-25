package be.vdab.services;

import be.vdab.domain.Order;
import be.vdab.repositories.OrderRepository;

import java.util.List;
import java.util.UUID;

public class OrderService {
    OrderRepository orderRepository = new OrderRepository();

    public List<Order> getOrder(){
        return orderRepository.getOrders();
    }
    public void addOrder(Order order) {
        calculateReduction(order);
        order.setOrderNumber(UUID.randomUUID().toString());
        //order.setOrderNumber(String.valueOf((int) (Math.random() * 100) + "ABC"));
        orderRepository.addOrder(order);
    }

    private void calculateReduction(Order order) {
        order.setPrice(order.getPrice()-(order.getPrice()*(35.0/100.0)));
    }

    public void deleteOrder(Order order) {
        orderRepository.deleteOrder(order);
    }

    public void update(Order order) {
        orderRepository.update(order);
    }
}
