package be.vdab;

import be.vdab.command.Command;
import be.vdab.command.Worker;
import be.vdab.services.OrderService;

import java.util.Arrays;
import java.util.Scanner;

public class App {
    //OrderService orderService = new OrderService();
    Scanner scanner = new Scanner(System.in);
    private Worker worker = new Worker();
    public static void main(String[] args) {
        new App().start();

    }
    private void start() {
        worker.execute(getCommand());
    }
    private Command getCommand() {
        System.out.println("give command");
        Arrays.stream(Worker.Commands.values()).forEach(commands -> System.out.println(commands.ordinal() + " :" + commands.getDescription()));
        int nrCommand = scanner.nextInt();
        return Arrays.stream(Worker.Commands.values()).filter(commands -> commands.ordinal() == nrCommand)
                .findFirst().get().getCommand();
    }
}

