import consoleMenu.ConsoleController;
import user.*;

public class Main {
    public static void main (String[] args) throws Exception {
        UserTickets userTickets = new UserTickets();
        ConsoleController consoleController = new ConsoleController(userTickets);
        consoleController.start();
    }
}
