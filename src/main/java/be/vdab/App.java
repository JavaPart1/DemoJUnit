package be.vdab;

import be.vdab.command.Command;
import be.vdab.command.Worker;
import be.vdab.exceptions.NotFoundException;
import be.vdab.services.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Scanner;

public class App {
    //OrderService orderService = new OrderService();
    Logger logger = LoggerFactory.getLogger(App.class);
    Scanner scanner = new Scanner(System.in);
    private Worker worker = new Worker();
    public static void main(String[] args) {
        new App().start();

    }
    private void start() {
        String programName = "OrderApp";
        logger.info("{} started", programName);

        while (true) {
            try {
                Command command = getCommand();
                if (command == null) {
                    System.out.println("Shutting down");
                    break;
                }
                worker.execute(command);
            } catch (NotFoundException e) {
                System.err.println("give in correct number: " + e.getMessage());
            }
        }
    }

    private Command getCommand() throws NotFoundException {
        System.out.println("give command");
        Arrays.stream(Worker.Commands.values()).forEach(commands -> System.out.println(commands.ordinal() + " :" + commands.getDescription()));
        if (scanner.hasNextInt()) {
            int nrCommand = scanner.nextInt();
            if (nrCommand == 99) {
                return null;
            }
            return Arrays.stream(Worker.Commands.values()).filter(commands -> commands.ordinal() == nrCommand)
                    .findFirst().orElseThrow(() -> new NotFoundException("Command not found")).getCommand();
        }
        scanner.next(); // we need the cursor in the scanner to progress to the next line
        throw new NotFoundException("wrong format number");

    }
}

