package tourTicket.util;

import tourTicket.*;

import java.util.HashMap;

public class TicketExemplars {
    private static Rest REST_TWO_DAYS_MONAKO = new Rest("Two days in beautifull Monako", "plane, bus", "1 Pl. du Palais, 98000 Monaco", 900000, 2);
    private static Rest REST_WEEK_LOS_ANGELES = new Rest("A Week in beautifull Los Angeles", "plane, bus", "1 Pico Blvd, Santa Monica, CA 90405", 1100000, 7);
    private static Treatment TREATMENT_TWO_WEEKS_KARPATY = new Treatment("Yoga, running and others", "Two weeks in our recovery center and you will forget about pain in back", "hiking, bus", "вул. Івана Котляревського, 13б, Либохора, Львівська область, 82633", 400000, 14);
    private static Treatment TREATMENT_FIVE_DAYS_WARSHAVA = new Treatment("Talking with other old people, and making socks and scarfs","Very good choice to make your granny happy", "bus", "Towarowa 3, 00-811 Warszawa", 600000, 5);
    private static Shopping SHOPPING_TOKYO = new Shopping("Shinjuku - One of Tokyo's largest shopping and entertainment districts, Shibuya - Center of youth fashion", "If you wanna to buy every brand clothes in the world. You go here", "plane, bus", "Японія, 〒100-0005 Tokyo, Chiyoda City, Marunouchi, 1 Chome−9−1 東京ステーションホテル 2F", 1000000, 2);
    private static Shopping SHOPPING_OTTAWA = new Shopping("CF Rideau Centre, Tanger Outlets, Ottawa’s shopping districts and neighbourhoods", "Very good choice to by some sweety cothes", "plane, bus", "1053 Carling Ave, Ottawa, ON K1Y 4E9", 900000, 3);
    private static Excursion EXCURSION_LVIV = new Excursion("Площа Ринок, львівська Ратуша", "If you don't know history of Lviv you should by this excursion", "bus", "вул. Площа ринок м. Львів", 100000, 1);
    private static Excursion EXCURSION_BERLIN = new Excursion("Prussian, Imperial, Nazi, Cold War and modern eras", "Discover Berlin Half-Day Walking Tour", "bus", "Kirchstraße 13, 10557 Berlin", 400000, 3);
    static {
        REST_TWO_DAYS_MONAKO.setIngestion(IngestionExemplars.BREAKFAST_3, IngestionExemplars.DINNER_1, IngestionExemplars.SUPPER_3);
        REST_WEEK_LOS_ANGELES.setIngestion(IngestionExemplars.BREAKFAST_3, IngestionExemplars.DINNER_1, IngestionExemplars.SUPPER_3);
        TREATMENT_TWO_WEEKS_KARPATY.setIngestion(IngestionExemplars.BREAKFAST_2, IngestionExemplars.DINNER_1, IngestionExemplars.SUPPER_2);
        TREATMENT_FIVE_DAYS_WARSHAVA.setIngestion(IngestionExemplars.BREAKFAST_1, IngestionExemplars.DINNER_2, IngestionExemplars.SUPPER_3);

        REST_TWO_DAYS_MONAKO.setUniqueIdentificator();
        REST_WEEK_LOS_ANGELES.setUniqueIdentificator();
        TREATMENT_TWO_WEEKS_KARPATY.setUniqueIdentificator();
        TREATMENT_FIVE_DAYS_WARSHAVA.setUniqueIdentificator();
        SHOPPING_TOKYO.setUniqueIdentificator();
        SHOPPING_OTTAWA.setUniqueIdentificator();
        EXCURSION_LVIV.setUniqueIdentificator();
        EXCURSION_BERLIN.setUniqueIdentificator();

    }
    public static HashMap<String, Vacation> ticketExemplars = new HashMap<>();
    static {
        ticketExemplars.put("RestTwoDaysMonako", REST_TWO_DAYS_MONAKO);
        ticketExemplars.put("RestWeekLosAngeles", REST_WEEK_LOS_ANGELES);
        ticketExemplars.put("TreatmentTwoWeeksKarpaty", TREATMENT_TWO_WEEKS_KARPATY);
        ticketExemplars.put("TreatmentFiveDaysWarshava", TREATMENT_FIVE_DAYS_WARSHAVA);
        ticketExemplars.put("ShoppingTokyo", SHOPPING_TOKYO);
        ticketExemplars.put("ShoppingOttawa", SHOPPING_OTTAWA);
        ticketExemplars.put("ExcursionLviv", EXCURSION_LVIV);
        ticketExemplars.put("ExcursionBerlin", EXCURSION_BERLIN);
    }
}
