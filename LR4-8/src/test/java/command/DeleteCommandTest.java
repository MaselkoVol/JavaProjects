package command;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import user.UserTickets;

import java.io.ByteArrayInputStream;

class DeleteCommandTest {

    @Test
    void CreateCopyOfClassEqualThatClass() {
        UserTickets userTickets = new UserTickets();
        DeleteCommand command = new DeleteCommand(userTickets);
        Assertions.assertInstanceOf(DeleteCommand.class, command.createCopy(userTickets));
    }
    @Test
    void CreateCopyOfClassNotEqualBasicObject() {
        UserTickets userTickets = new UserTickets();
        DeleteCommand command = new DeleteCommand(userTickets);
        DeleteCommand command1 = command.createCopy(userTickets);
        Assertions.assertNotEquals(command1, command);
    }
    @Test
    void CreateCopyThrows() {
        DeleteCommand command = null;
        Assertions.assertThrows(Exception.class, ()->command.createCopy(null));
    }
    @Test
    void ToStringEqualaddnameOfVacation() {
        UserTickets userTickets = new UserTickets();
        DeleteCommand command = new DeleteCommand(userTickets);
        Assertions.assertEquals("delete nameOfVacation", command.toString());
    }
    @Test
    void ToStringNotEqualNameOfVacation() {
        UserTickets userTickets = new UserTickets();
        DeleteCommand command = new DeleteCommand(userTickets);
        Assertions.assertNotEquals("nameOfVacation", command.toString());
    }
    @Test
    void RestTwoDaysMonakoExecuteGood() {
        String inputText = "RestTwoDaysMonako";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputText.getBytes());
        System.setIn(inputStream);
        UserTickets userTickets = new UserTickets();
        AddCommand command1 = new AddCommand(userTickets);
        command1.execute();

        inputText = "RestTwoDaysMonako";
        inputStream = new ByteArrayInputStream(inputText.getBytes());
        System.setIn(inputStream);
        DeleteCommand command = new DeleteCommand(userTickets);
        Assertions.assertEquals(true, command.execute());
    }
    @Test
    void RestOneDaysMonakoExecuteBad() {
        UserTickets userTickets = new UserTickets();
        String inputText = "RestOneDaysMonako";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputText.getBytes());
        System.setIn(inputStream);
        DeleteCommand command = new DeleteCommand(userTickets);
        Assertions.assertEquals(false, command.execute());
    }
    @Test
    void RestTwoDaysMonakoExecuteBadBacauseNoTicketInUserTickets() {
        UserTickets userTickets = new UserTickets();
        String inputText = "RestTwoDaysMonako";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputText.getBytes());
        System.setIn(inputStream);
        DeleteCommand command = new DeleteCommand(userTickets);
        Assertions.assertEquals(false, command.execute());
    }
}