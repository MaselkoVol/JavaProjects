package tourTicket;

import java.sql.Time;

public class Excursion extends Vacation {
    private String attractions;
    public Excursion (String attractions, String title, String transport, String location, int cost, int duration) {
        super(title, transport, location, cost, duration);
        this.attractions = attractions;
    }
    @Override
    public Excursion createCopy() {
        Excursion newVacation = new Excursion(attractions, title, transport, location, cost, duration);
        newVacation.identificator = identificator;
        return newVacation;
    }
    @Override
    public String getFullInfo () {
        String res = super.getFullInfo();
        res += "\nAttractions: ";
        res += attractions;
        return res;
    }
}
