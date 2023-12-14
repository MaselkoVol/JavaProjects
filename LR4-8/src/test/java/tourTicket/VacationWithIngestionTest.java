package tourTicket;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tourTicket.util.TicketExemplars;

class VacationWithIngestionTest {
    @Test
    void getFullInfoWorksCorrect() {
        Vacation restTwoDaysMonako = TicketExemplars.ticketExemplars.get("RestTwoDaysMonako").createCopy();
        Assertions.assertEquals(restTwoDaysMonako.getFullInfo(), "Title: Two days in beautifull Monako\n" +
                "Location: 1 Pl. du Palais, 98000 Monaco\n" +
                "Duration:  days2\n" +
                "Transport: plane, bus\n" +
                "Cost: 9000.0\n" +
                "Meal Sheadule: [LtourTicket.Ingestion;@48aaecc3");
    }
}