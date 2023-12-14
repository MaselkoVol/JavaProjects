package command;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import user.UserTickets;

import java.io.ByteArrayInputStream;

class SortCommandTest {
    @Test
    void CreateCopyOfClassEqualThatClass() {
        UserTickets userTickets = new UserTickets();
        SortCommand addCommand = new SortCommand(userTickets);
        Assertions.assertInstanceOf(SortCommand.class, addCommand.createCopy(userTickets));
    }
    @Test
    void CreateCopyOfClassNotEqualBasicObject() {
        UserTickets userTickets = new UserTickets();
        SortCommand command = new SortCommand(userTickets);
        SortCommand command1 = command.createCopy(userTickets);
        Assertions.assertNotEquals(command1, command);
    }
    @Test
    void ToStringEqualaddnameOfVacation() {
        UserTickets userTickets = new UserTickets();
        SortCommand command = new SortCommand(userTickets);
        Assertions.assertEquals("add nameOfVacation", command.toString());
    }
    @Test
    void ToStringNotEqualNameOfVacation() {
        UserTickets userTickets = new UserTickets();
        SortCommand command = new SortCommand(userTickets);
        Assertions.assertNotEquals("nameOfVacation", command.toString());
    }
    @Test
    void executeSortByCostReturnsTrue () {
        String inputText = "cost";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputText.getBytes());
        System.setIn(inputStream);
        UserTickets userTickets = new UserTickets();
        SortCommand command = new SortCommand(userTickets);
        Assertions.assertEquals(true, command.execute());
    }
    @Test
    void executeSortByDurationReturnsTrue () {
        String inputText = "duration";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputText.getBytes());
        System.setIn(inputStream);
        UserTickets userTickets = new UserTickets();
        SortCommand command = new SortCommand(userTickets);
        Assertions.assertEquals(true, command.execute());
    }
    @Test
    void executeSortByNameReturnsTrue () {
        String inputText = "name";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputText.getBytes());
        System.setIn(inputStream);
        UserTickets userTickets = new UserTickets();
        SortCommand command = new SortCommand(userTickets);
        Assertions.assertEquals(true, command.execute());
    }
    @Test
    void executeSortByNanameReturnsFalse () {
        String inputText = "naname";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputText.getBytes());
        System.setIn(inputStream);
        UserTickets userTickets = new UserTickets();
        SortCommand command = new SortCommand(userTickets);
        Assertions.assertEquals(false, command.execute());
    }
}