package command;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import user.UserTickets;

import java.io.ByteArrayInputStream;

class AddCommandTest {

    @Test
    void CreateCopyOfClassEqualThatClass() {
        UserTickets userTickets = new UserTickets();
        AddCommand addCommand = new AddCommand(userTickets);
        Assertions.assertInstanceOf(AddCommand.class, addCommand.createCopy(userTickets));
    }

    @Test
    void CreateCopyOfClassNotEqualBasicObject() {
        UserTickets userTickets = new UserTickets();
        AddCommand addCommand = new AddCommand(userTickets);
        AddCommand addCommand1 = addCommand.createCopy(userTickets);
        Assertions.assertNotEquals(addCommand1, addCommand);
    }
    @Test
    void ToStringEqualaddnameOfVacation() {
        UserTickets userTickets = new UserTickets();
        AddCommand addCommand = new AddCommand(userTickets);
        Assertions.assertEquals("add nameOfVacation", addCommand.toString());
    }
    @Test
    void ToStringNotEqualNameOfVacation() {
        UserTickets userTickets = new UserTickets();
        AddCommand addCommand = new AddCommand(userTickets);
        Assertions.assertNotEquals("nameOfVacation", addCommand.toString());
    }

    @Test
    void RestTwoDaysMonakoExecuteGood() {
        String inputText = "RestTwoDaysMonako";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputText.getBytes());
        System.setIn(inputStream);
        UserTickets userTickets = new UserTickets();
        AddCommand addCommand = new AddCommand(userTickets);
        Assertions.assertEquals(true, addCommand.execute());
    }
    @Test
    void RestOneDaysMonakoExecuteNotGood() {
        String inputText = "RestOneDaysMonako";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputText.getBytes());
        System.setIn(inputStream);
        UserTickets userTickets = new UserTickets();
        AddCommand addCommand = new AddCommand(userTickets);
        Assertions.assertEquals(false, addCommand.execute());
    }
}