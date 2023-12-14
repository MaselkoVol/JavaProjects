package user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tourTicket.Vacation;
import tourTicket.util.TicketExemplars;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class UserTicketsTest {
    @Test
    void RemoveExcursionLviv() {
        UserTickets userTickets = new UserTickets();
        Vacation vacation = TicketExemplars.ticketExemplars.get("ExcursionLviv").createCopy();
        userTickets.add(vacation);
        Assertions.assertEquals(true, userTickets.remove(vacation));
    }
    @Test
    void ReturnUserTickets() {
        UserTickets userTickets = new UserTickets();
        LinkedList<Vacation> userTickets1= userTickets.getUserTickets();
        assertEquals(userTickets1, userTickets.getUserTickets());

    }
    @Test
    void toStringCorrect() {
        UserTickets userTickets = new UserTickets();
        Vacation vacation = TicketExemplars.ticketExemplars.get("ExcursionLviv").createCopy();
        userTickets.add(vacation);
        assertEquals(userTickets.toString(), "1) Title: If you don't know history of Lviv you should by this excursion\n");

    }
}