package be.vdab.services;

import be.vdab.domain.Order;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import org.junit.Assert.*;

public class OrderServiceITTest {
    private OrderService orderService = new OrderService();

    @Test
    public void addOrder() {
        Order order = new Order("test",88.0);
        orderService.addOrder(order);

        Assert.assertEquals(1,orderService.getOrder().size());
    }

    @Test
    public void assertPrice(){
        Order order = new Order("test",88.0);
        orderService.addOrder(order);

        Assert.assertEquals(32.2,order.getPrice(),0);
    }


}