package command;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import user.UserTickets;

public class MyTicketsCommandTest {
    @Test
    void CreateCopyOfClassEqualThatClass() {
        UserTickets userTickets = new UserTickets();
        MyTicketsCommand command = new MyTicketsCommand(userTickets);
        Assertions.assertInstanceOf(MyTicketsCommand.class, command.createCopy(userTickets));
    }

    @Test
    void CreateCopyOfClassNotEqualBasicObject() {
        UserTickets userTickets = new UserTickets();
        MyTicketsCommand command = new MyTicketsCommand(userTickets);
        MyTicketsCommand command1 = command.createCopy(userTickets);
        Assertions.assertNotEquals(command1, command);
    }

    @Test
    void ToStringEqualaddnameOfVacation() {
        UserTickets userTickets = new UserTickets();
        MyTicketsCommand command = new MyTicketsCommand(userTickets);
        Assertions.assertEquals("myTickets", command.toString());
    }

    @Test
    void ToStringNotEqualNameOfVacation() {
        UserTickets userTickets = new UserTickets();
        MyTicketsCommand command = new MyTicketsCommand(userTickets);
        Assertions.assertNotEquals("nameOfVacation", command.toString());
    }
    @Test
    void executeCorrectly() {
        UserTickets userTickets = new UserTickets();
        MyTicketsCommand command = new MyTicketsCommand(userTickets);
        Assertions.assertEquals(true, command.execute());
    }
}
