import consoleMenu.ConsoleController;
import org.junit.jupiter.api.Test;
import user.UserTickets;

import java.io.ByteArrayInputStream;

class MainTest {
    @Test
    void mainWorksFine() throws Exception {
        String inputText = "exit";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputText.getBytes());
        System.setIn(inputStream);
        UserTickets userTickets = new UserTickets();
        ConsoleController consoleController = new ConsoleController(userTickets);
        consoleController.start();
    }
}