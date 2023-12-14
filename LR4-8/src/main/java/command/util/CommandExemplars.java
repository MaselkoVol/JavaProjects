package command.util;

import command.*;

import java.util.HashMap;

public class CommandExemplars {
    public static HashMap<String, Command> commands = new HashMap<>();;
    static {
        commands.put("add", new AddCommand(null));
        commands.put("delete", new DeleteCommand(null));
        commands.put("myTickets", new MyTicketsCommand(null));
        commands.put("info", new InfoCommand(null));
        commands.put("ticketInfo", new TicketInfoCommand(null));
        commands.put("sort", new SortCommand(null));
        commands.put("exit", new ExitCommand(null));
    }
}
