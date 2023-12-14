package command;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import user.UserTickets;

public class ExitCommandTest {
    @Test
    void CreateCopyOfClassEqualThatClass() {
        UserTickets userTickets = new UserTickets();
        ExitCommand command = new ExitCommand(userTickets);
        Assertions.assertInstanceOf(ExitCommand.class, command.createCopy(userTickets));
    }

    @Test
    void CreateCopyOfClassNotEqualBasicObject() {
        UserTickets userTickets = new UserTickets();
        ExitCommand command = new ExitCommand(userTickets);
        ExitCommand command1 = command.createCopy(userTickets);
        Assertions.assertNotEquals(command1, command);
    }

    @Test
    void ToStringEqualaddnameOfVacation() {
        UserTickets userTickets = new UserTickets();
        ExitCommand command = new ExitCommand(userTickets);
        Assertions.assertEquals("exit comamnd", command.toString());
    }

    @Test
    void ToStringNotEqualNameOfVacation() {
        UserTickets userTickets = new UserTickets();
        ExitCommand command = new ExitCommand(userTickets);
        Assertions.assertNotEquals("nameOfVacation", command.toString());
    }
    @Test
    void executeCorrectly () {
        UserTickets userTickets = new UserTickets();
        ExitCommand command = new ExitCommand(userTickets);
        Assertions.assertEquals(0, command.execute());

    }
}
