package tourTicket;

import java.sql.Time;

public class Shopping extends Vacation {
    private String shops;
    public Shopping (String shops, String title, String transport, String location, int cost, int duration) {
        super(title, transport, location, cost, duration);
        this.shops = shops;
    }
    @Override
    public Shopping createCopy() {
        Shopping newVacation = new Shopping(shops, title, transport, location, cost, duration);
        newVacation.identificator = identificator;
        return newVacation;
    }
    @Override
    public String getFullInfo () {
        String res = super.getFullInfo();
        res += "\nShops: ";
        res += shops;
        return res;
    }
}
