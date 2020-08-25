package be.vdab.command;

import be.vdab.App;
import be.vdab.domain.Order;
import be.vdab.services.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class AddOrderCommand implements Command{
    Scanner scanner = new Scanner(System.in);
    OrderService orderService = new OrderService();


    @Override
    public void execute() {
        Logger logger = LoggerFactory.getLogger(App.class);
        logger.info("AddOrderCommand invoked");
        System.out.println("give in price");
        double price = scanner.nextDouble();
        System.out.println("Give in name");
        String name = scanner.next();

        orderService.addOrder(new Order(name, price));
        orderService.getOrder().stream().forEach(order -> {
            System.out.printf("order: %s , price: %f\n" , order.getName(), order.getPrice());
        });
    }

}
