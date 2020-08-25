package be.vdab.command;

import be.vdab.domain.Order;
import be.vdab.exceptions.NotFoundException;
import be.vdab.services.OrderService;

import java.util.List;
import java.util.Scanner;

public class DeleteOrderCommand implements Command {
    private OrderService orderService = new OrderService();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void execute() {
        System.out.println("Type in order number to delete");
        List<Order> orders = orderService.getOrder();
        orders.stream().forEach(order -> System.out.printf("OrderNr: %s Name: %s", order.getOrderNumber(), order.getName()));

        String chosenNumber = scanner.next();
        try {
            Order order = orders.stream().filter(order1 -> order1.getOrderNumber().equals(chosenNumber.toUpperCase())).findFirst()
                    .orElseThrow(() -> new NotFoundException("order not found"));
            orderService.deleteOrder(order);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
    }
}
