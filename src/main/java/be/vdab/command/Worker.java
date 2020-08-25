package be.vdab.command;

public class Worker {

    public enum Commands{
        ADD_ORDER("Add an order",new AddOrderCommand()),
        DELETE_ORDER("Delete an order", new DeleteOrderCommand());

        private String description;
        private Command command;

        Commands(String description, Command command) {
            this.description = description;
            this.command = command;
        }
        public String getDescription() {
            return description;
        }

        public Command getCommand() {
            return command;
        }
    }

    public void execute(Command command){
        command.execute();
    }
}
