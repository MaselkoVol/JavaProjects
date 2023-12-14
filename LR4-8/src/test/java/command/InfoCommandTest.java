package command;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import user.UserTickets;

public class InfoCommandTest {
    @Test
    void CreateCopyOfClassEqualThatClass() {
        UserTickets userTickets = new UserTickets();
        InfoCommand command = new InfoCommand(userTickets);
        Assertions.assertInstanceOf(InfoCommand.class, command.createCopy(userTickets));
    }

    @Test
    void CreateCopyOfClassNotEqualBasicObject() {
        UserTickets userTickets = new UserTickets();
        InfoCommand command = new InfoCommand(userTickets);
        InfoCommand command1 = command.createCopy(userTickets);
        Assertions.assertNotEquals(command1, command);
    }

    @Test
    void ToStringEqualaddnameOfVacation() {
        UserTickets userTickets = new UserTickets();
        InfoCommand command = new InfoCommand(userTickets);
        Assertions.assertEquals("info", command.toString());
    }

    @Test
    void ToStringNotEqualNameOfVacation() {
        UserTickets userTickets = new UserTickets();
        InfoCommand command = new InfoCommand(userTickets);
        Assertions.assertNotEquals("nameOfVacation", command.toString());
    }
    @Test
    void executeCorrectly() {
        UserTickets userTickets = new UserTickets();
        InfoCommand command = new InfoCommand(userTickets);
        Assertions.assertEquals(true, command.execute());
    }
}
