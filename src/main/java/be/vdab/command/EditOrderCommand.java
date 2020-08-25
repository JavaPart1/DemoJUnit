package be.vdab.command;

import be.vdab.domain.Order;
import be.vdab.exceptions.NotFoundException;
import be.vdab.services.OrderService;

import java.util.List;
import java.util.Scanner;

public class EditOrderCommand implements Command {
    private Scanner scanner = new Scanner(System.in);
    private OrderService orderService = new OrderService();

    @Override
    public void execute() {
        System.out.println("Type in order number to Edit");
        List<Order> orders = orderService.getOrder();
        orders.forEach(order -> System.out.printf("OrderNr: %s Name: %s", order.getOrderNumber(), order.getName()));
        String chosenNumber = scanner.next();
        try {
            Order order = orders.stream().filter(order1 -> order1.getOrderNumber().equals(chosenNumber.toUpperCase())).findFirst()
                    .orElseThrow(() -> new NotFoundException("order not found"));
            editOrder(order);
            orderService.update(order);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
    }

    private void editOrder(Order order) {
        System.out.println("give in price");
        double price = scanner.nextDouble();
        System.out.println("Give in name");
        String name = scanner.next();
        order.setName(name);
        order.setPrice(price);
    }

}
