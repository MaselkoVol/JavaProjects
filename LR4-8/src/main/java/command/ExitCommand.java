package command;

import user.UserTickets;

import java.util.Scanner;


public class ExitCommand implements Command {
    private Scanner scan = new Scanner(System.in);
    private String ticketName;
    private UserTickets userTickets;
    public ExitCommand (UserTickets userTickets) {
        this.userTickets = userTickets;
    }
    public boolean execute() {
        System.out.println("See you soon");
        System.exit(0);
        return true;
    }

    @Override
    public ExitCommand createCopy(UserTickets userTickets) {
        return new ExitCommand(userTickets);
    }
    @Override
    public String toString () {
        return "exit comamnd";
    }

}
