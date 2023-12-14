package command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import tourTicket.util.TicketExemplars;
import user.UserTickets;

import java.util.Scanner;


public class TicketInfoCommand implements Command {
    private static org.apache.logging.log4j.core.Logger logger = (Logger) LogManager.getLogger(TicketInfoCommand.class);

    Scanner scan = new Scanner(System.in);
    private String ticketName;
    private UserTickets userTickets;
    public TicketInfoCommand(UserTickets userTickets) {
        this.userTickets = userTickets;
    }
    @Override
    public boolean execute() {
        System.out.println("Enter Vacation name: ");
        ticketName = scan.nextLine();

        if (TicketExemplars.ticketExemplars.containsKey(ticketName)) {
            System.out.println(TicketExemplars.ticketExemplars.get(ticketName).getFullInfo());
            logger.info(TicketExemplars.ticketExemplars.get(ticketName).getFullInfo());
            return true;
        } else {
            System.out.println("Ticket doesn't exist");
            logger.error("Ticket doesn't exist");
            return false;
        }

    }

    @Override
    public TicketInfoCommand createCopy(UserTickets userTickets) {
        return new TicketInfoCommand(userTickets);
    }
    @Override
    public String toString () {
        return "add nameOfVacation";
    }

}
