package info;

import command.Command;
import command.util.CommandExemplars;
import tourTicket.Vacation;
import tourTicket.util.TicketExemplars;

import java.util.HashMap;

public class ProgramInfo {
    public boolean showAllTickets () {
        System.out.println("All available tickets:");
        int i = 1;
        HashMap<String, Vacation> ticketExemplars = TicketExemplars.ticketExemplars;
        for (HashMap.Entry<String, Vacation> entry : ticketExemplars.entrySet()) {
            System.out.println(i + ") " + entry.getKey() + ". " + entry.getValue());
            i++;
        }
        return true;
    }
    public boolean showAllCommands () {
        System.out.println("All commands:");
        int i = 1;
        HashMap<String, Command> commandExemplars = CommandExemplars.commands;
        for (HashMap.Entry<String, Command> entry : commandExemplars.entrySet()) {
            System.out.println(i + ") " + entry.getKey() + ": " + entry.getValue());
            i++;
        }
        return true;
    }
    public void showAllInfo () {
        showAllTickets();
        System.out.println();
        showAllCommands();
    }

}
