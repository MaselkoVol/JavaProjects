package tourTicket;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tourTicket.util.TicketExemplars;

class VacationTest {
    @Test
    void toStringWorksCorrectly () {
        Vacation vacation = TicketExemplars.ticketExemplars.get("RestTwoDaysMonako");
        Assertions.assertEquals(vacation.toString(), "Title: Two days in beautifull Monako");
    }
    @Test
    void createCopyReturnsNull () {
        Vacation vacation = new Vacation("hallo", "a", "aa", 100, 10);
        Assertions.assertEquals(vacation.createCopy(), null);
    }
    @Test
    void getCost100Returns100 () {
        Vacation vacation = new Vacation("hallo", "a", "aa", 100, 10);
        Assertions.assertEquals(vacation.getCost(), 100);
    }
    @Test
    void getDuration10Returns10 () {
        Vacation vacation = new Vacation("hallo", "a", "aa", 100, 10);
        Assertions.assertEquals(vacation.getDuration(), 10);
    }
    @Test
    void getIdentificator0Returns0 () {
        Vacation vacation = new Vacation("hallo", "a", "aa", 100, 10);
        Assertions.assertEquals(vacation.getIdentificator(), 0);
    }
}