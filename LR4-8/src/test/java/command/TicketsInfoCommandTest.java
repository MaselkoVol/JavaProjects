package command;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import user.UserTickets;

import java.io.ByteArrayInputStream;

public class TicketsInfoCommandTest {
    @Test
    void CreateCopyOfClassEqualThatClass() {
        UserTickets userTickets = new UserTickets();
        TicketInfoCommand command = new TicketInfoCommand(userTickets);
        Assertions.assertInstanceOf(TicketInfoCommand.class, command.createCopy(userTickets));
    }

    @Test
    void CreateCopyOfClassNotEqualBasicObject() {
        UserTickets userTickets = new UserTickets();
        TicketInfoCommand command = new TicketInfoCommand(userTickets);
        TicketInfoCommand command1 = command.createCopy(userTickets);
        Assertions.assertNotEquals(command1, command);
    }

    @Test
    void ToStringEqualaddnameOfVacation() {
        UserTickets userTickets = new UserTickets();
        TicketInfoCommand command = new TicketInfoCommand(userTickets);
        Assertions.assertEquals("add nameOfVacation", command.toString());
    }

    @Test
    void ToStringNotEqualNameOfVacation() {
        UserTickets userTickets = new UserTickets();
        TicketInfoCommand command = new TicketInfoCommand(userTickets);
        Assertions.assertNotEquals("nameOfVacation", command.toString());
    }
    @Test
    void executeCorrectly() {
        String inputText = "RestTwoDaysMonako";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputText.getBytes());
        System.setIn(inputStream);

        UserTickets userTickets = new UserTickets();
        TicketInfoCommand command = new TicketInfoCommand(userTickets);
        Assertions.assertEquals(true, command.execute());
    }
    @Test
    void executeNotCorrectly() {
        String inputText = "RestOneDaysMonako";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputText.getBytes());
        System.setIn(inputStream);

        UserTickets userTickets = new UserTickets();
        TicketInfoCommand command = new TicketInfoCommand(userTickets);
        Assertions.assertEquals(false, command.execute());
    }
}
