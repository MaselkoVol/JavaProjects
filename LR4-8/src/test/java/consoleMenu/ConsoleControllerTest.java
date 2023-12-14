package consoleMenu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import user.UserTickets;

import java.io.ByteArrayInputStream;

class ConsoleControllerTest {
    @Test
    void startProperly () throws Exception {
        String inputText = "exit";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputText.getBytes());
        System.setIn(inputStream);
        UserTickets userTickets = new UserTickets();
        ConsoleController consoleController = new ConsoleController(userTickets);
        consoleController.start();
    }
    @Test
    void startNotProperly () throws Exception {
        String inputText = "edxit";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputText.getBytes());
        System.setIn(inputStream);
        UserTickets userTickets = new UserTickets();
        ConsoleController consoleController = new ConsoleController(userTickets);
        Assertions.assertEquals(false, consoleController.start());
    }
}