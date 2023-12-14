package tourTicket;


public class Rest extends VacationWithIngestion {
    public Rest (Ingestion [] mealSheadule,String title, String transport, String location, int cost, int duration) {
        super(title, transport, location, cost, duration);
        this.mealSheadule = mealSheadule;
    }
    public Rest (String title, String transport, String location, int cost, int duration) {
        super(title, transport, location, cost, duration);
    }
    @Override
    public Rest createCopy() {
        Rest newVacation = new Rest(mealSheadule, title, transport, location, cost, duration);
        newVacation.identificator = identificator;
        return newVacation;
    }
}
