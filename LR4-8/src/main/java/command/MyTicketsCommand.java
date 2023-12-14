package command;

import user.UserTickets;


public class MyTicketsCommand implements Command {
    private String ticketName;
    private UserTickets userTickets;
    public MyTicketsCommand(UserTickets userTickets) {
        this.userTickets = userTickets;
    }
    @Override
    public boolean execute() {
        System.out.println(userTickets);
        return true;
    }


    public MyTicketsCommand createCopy(UserTickets userTickets) {
        return new MyTicketsCommand(userTickets);
    }
    @Override
    public String toString () {
        return "myTickets";
    }
}
