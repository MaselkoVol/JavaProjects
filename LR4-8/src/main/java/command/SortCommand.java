package command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import tourTicket.Vacation;
import tourTicket.util.TicketExemplars;
import user.UserTickets;

import java.util.HashMap;
import java.util.Scanner;


public class SortCommand implements Command {
    private static org.apache.logging.log4j.core.Logger logger = (Logger) LogManager.getLogger(SortCommand.class);

    Scanner scan = new Scanner(System.in);
    private HashMap<String, Vacation> ticketExemplars = TicketExemplars.ticketExemplars;
    private String sortName;

    public SortCommand (UserTickets userTickets) {
    }
    @Override
    public boolean execute() {
        System.out.println("Sort by (cost, duration, name): ");
        sortName = scan.nextLine().trim();
        switch (sortName) {
            case "cost":
                sortByCost();
                return true;
            case "duration":
                sortByDuration();
                return true;
            case "name":
                sortByName();
                return true;
        }
        logger.error("Can't sort by this parameter");
        return false;
    }
    private void sortByCost () {
            String[][] ticketExemplarsList = new String[ticketExemplars.size()][2];
        int i = 0, k = 0;

        String arg1, arg2;
            for (HashMap.Entry<String, Vacation> entry : ticketExemplars.entrySet()) {
                ticketExemplarsList[i][0] = String.valueOf(entry.getKey());
                ticketExemplarsList[i][1] = String.valueOf(entry.getValue().getCost());
                i++;
            }
            for (i = 1; i < ticketExemplarsList.length; i++) {
                arg1 = ticketExemplarsList[i][0];
                arg2 = ticketExemplarsList[i][1];
                for (k = i - 1; k >= 0 && Integer.valueOf(ticketExemplarsList[k][1]) > Integer.valueOf(arg2); k--) {
                    ticketExemplarsList[k + 1][0] = ticketExemplarsList[k][0];
                    ticketExemplarsList[k + 1][1] = ticketExemplarsList[k][1];
                }
                ticketExemplarsList[k + 1][0] = arg1;
                ticketExemplarsList[k + 1][1] = arg2;
            }
            for (i = 0; i < ticketExemplarsList.length; i++) {
                System.out.println(i + 1 + ") " + ticketExemplarsList[i][0] + ". " + Double.valueOf(ticketExemplarsList[i][1]));
            }

    }
    private void sortByDuration () {
            String[][] ticketExemplarsList = new String[ticketExemplars.size()][2];
            int i = 0, k = 0;
        String arg1, arg2;
            for (HashMap.Entry<String, Vacation> entry : ticketExemplars.entrySet()) {
                ticketExemplarsList[i][0] = String.valueOf(entry.getKey());
                ticketExemplarsList[i][1] = String.valueOf(entry.getValue().getDuration());
                i++;
            }
            for (i = 1; i < ticketExemplarsList.length; i++) {
                arg1 = ticketExemplarsList[i][0];
                arg2 = ticketExemplarsList[i][1];
                for (k = i - 1; k >= 0 && Integer.valueOf(ticketExemplarsList[k][1]) > Integer.valueOf(arg2); k--) {
                    ticketExemplarsList[k + 1][0] = ticketExemplarsList[k][0];
                    ticketExemplarsList[k + 1][1] = ticketExemplarsList[k][1];
                }
                ticketExemplarsList[k + 1][0] = arg1;
                ticketExemplarsList[k + 1][1] = arg2;
            }

            for (i = 0; i < ticketExemplarsList.length; i++) {
                System.out.println(i + 1 + ") " + ticketExemplarsList[i][0] + ". " + ticketExemplarsList[i][1] + " days");
            }
    }
    private void sortByName () {
        String[] ticketExemplarsList = new String[ticketExemplars.size()];
        int i = 0, k = 0;
        String arg;
        for (HashMap.Entry<String, Vacation> entry : ticketExemplars.entrySet()) {
            ticketExemplarsList[i] = String.valueOf(entry.getKey());
            i++;
        }
        for (i = 1; i < ticketExemplarsList.length; i++) {
            arg = ticketExemplarsList[i];
            for (k = i - 1; k >= 0 && ticketExemplarsList[k].compareTo(arg) == 1; k--) {
                ticketExemplarsList[k + 1] = ticketExemplarsList[k];
            }
            ticketExemplarsList[k + 1] = arg;
        }
        for(i = 0; i < ticketExemplarsList.length; i++) {
            System.out.println(i + 1 + ") " + ticketExemplarsList[i]);
        }
    }


    @Override
    public SortCommand createCopy(UserTickets userTickets) {
        return new SortCommand(userTickets);
    }
    @Override
    public String toString () {
        String s = "add nameOfVacation";
        return s;
    }

}
