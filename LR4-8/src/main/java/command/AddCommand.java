package command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import tourTicket.Vacation;
import tourTicket.util.TicketExemplars;
import user.UserTickets;

import java.util.Scanner;


public class AddCommand implements Command {
    private static org.apache.logging.log4j.core.Logger logger = (Logger) LogManager.getLogger(AddCommand.class);
    Scanner scan = new Scanner(System.in);
    private String ticketName;
    private UserTickets userTickets;
    public AddCommand (UserTickets userTickets) {
        this.userTickets = userTickets;
    }
    @Override
    public boolean execute() {
        System.out.println("Enter Vacation name: ");
        ticketName = scan.nextLine();

        if (TicketExemplars.ticketExemplars.containsKey(ticketName)) {
            Vacation ticket = TicketExemplars.ticketExemplars.get(ticketName);
            userTickets.add(ticket.createCopy());
            System.out.println("Ticket was added succefully");
            logger.info("Ticket was added succefully");
            return true;
        }
        System.out.println("Ticket wasn't added");
        logger.error("Ticket wasn't added");
        return false;
    }

    @Override
    public AddCommand createCopy(UserTickets userTickets) {
        return new AddCommand(userTickets);
    }
    @Override
    public String toString () {
        return "add nameOfVacation";
    }

}
