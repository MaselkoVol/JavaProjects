package tourTicket;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tourTicket.util.TicketExemplars;

import static org.junit.jupiter.api.Assertions.*;

class ExcursionTest {

    @Test
    void getfullInfo() {
        Vacation vacation = TicketExemplars.ticketExemplars.get("ExcursionLviv").createCopy();
        Assertions.assertEquals(vacation.getFullInfo(), "Title: Two weeks in our recovery center and you will forget about pain in back\n" +
                "Location: вул. Івана Котляревського, 13б, Либохора, Львівська область, 82633\n" +
                "Duration:  days14\n" +
                "Transport: hiking, bus\n" +
                "Cost: 4000.0\n" +
                "Meal Sheadule: [LtourTicket.Ingestion;@60d8c9b7\n" +
                "Procedures: Yoga, running and others");
    }
}