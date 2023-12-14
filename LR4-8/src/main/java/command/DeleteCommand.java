package command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import tourTicket.Vacation;
import tourTicket.util.TicketExemplars;
import user.UserTickets;

import java.util.Scanner;

public class DeleteCommand implements Command {
    private static org.apache.logging.log4j.core.Logger logger = (Logger) LogManager.getLogger(DeleteCommand.class);
    Scanner scan = new Scanner(System.in);
    private String ticketName;
    private UserTickets userTickets;
    public DeleteCommand(UserTickets userTickets) {
        this.userTickets = userTickets;
    }
    @Override
    public boolean execute() {
        System.out.println("Enter Vacation name: ");
        ticketName = scan.nextLine();

        if (!TicketExemplars.ticketExemplars.containsKey(ticketName)) {
            System.out.println("Ticket wasn't removed");
            logger.error("Ticket wasn't removed");
            return false;
        }
        boolean res = false;
        Vacation ticket = TicketExemplars.ticketExemplars.get(ticketName);
        for (Vacation curTicket : userTickets.getUserTickets())
            if (curTicket.getIdentificator() == ticket.getIdentificator()) {
                userTickets.remove(curTicket);
                res = true;
                break;
            }
        if (res == true) {
            System.out.println("Ticket was removed succesfully");
            logger.info("Ticket was removed succesfully");
            return res;
        } else {
            System.out.println("Ticket wasn't removed");
            logger.error("Ticket wasn't removed");
            return res;
        }
    }
    @Override
    public DeleteCommand createCopy(UserTickets userTickets) {
        return new DeleteCommand(userTickets);
    }

    @Override
    public String toString () {
        return "delete nameOfVacation";
    }

}