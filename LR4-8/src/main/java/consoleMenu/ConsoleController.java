package consoleMenu;

import command.Command;
import command.util.CommandExemplars;
import info.ProgramInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import tourTicket.util.TicketExemplars;
import user.SendEmail;
import user.UserTickets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class ConsoleController {
    private static Logger logger = (Logger) LogManager.getLogger(ConsoleController.class);
    private HashMap<String, Command> commandExemplars;
    private UserTickets userTickets;
    public Scanner sc = new Scanner(System.in);
    private Command command;
    private ProgramInfo programInfo;
    public ConsoleController (UserTickets userTickets) {
        commandExemplars = CommandExemplars.commands;
        this.userTickets = userTickets;
        programInfo = new ProgramInfo();
    }
    public boolean start () throws Exception {
        String FILE_PATH = "C:\\Users\\User\\IdeaProjects\\PP\\LR4-8\\testInfo.txt";
        loadFromFile(FILE_PATH, userTickets);
        programInfo.showAllInfo();
        while (true) {
            String commandLine = sc.nextLine().trim();
            if (commandExemplars.containsKey(commandLine)) {
                command = commandExemplars.get(commandLine).createCopy(userTickets);
                command.execute();
                logger.info("Command executed: " + command.toString());
            }
            else {
                System.out.println("There is no command like this");
                logger.fatal("There is no command like this");
                SendEmail.sendMessage("There is no command like this: " + commandLine);
                return false;
            }
        }
    }
    private void loadFromFile (String filePath, UserTickets userTickets) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Read each line from the file
            while (true) {
                if ((line = reader.readLine()) == null)
                    break;
                if (TicketExemplars.ticketExemplars.containsKey(line)) {
                    userTickets.add(TicketExemplars.ticketExemplars.get(line).createCopy());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
