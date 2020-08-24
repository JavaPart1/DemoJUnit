package be.vdab.command;

import be.vdab.domain.Order;
import be.vdab.services.OrderService;

import java.util.Scanner;

public class AddOrderCommand implements Command{
    Scanner scanner = new Scanner(System.in);
    OrderService orderService = new OrderService();


    @Override
    public void execute() {
        System.out.println("give in price");
        double price = scanner.nextDouble();
        orderService.addOrder(new Order("Cookies", price));
        orderService.getOrder().stream().forEach(order -> {
            System.out.printf("order: %s , price: %f\n" , order.getName(), order.getPrice());
        });
    }

}
