package tourTicket;

public class VacationWithIngestion extends Vacation{
    protected Ingestion [] mealSheadule;
    public VacationWithIngestion(String title, String transport, String location, int cost, int duration) {
        super( title,  transport,  location,  cost,  duration);
    }
    public void setIngestion(Ingestion breakfast, Ingestion dinner, Ingestion supper) {
        mealSheadule = new Ingestion[3];
        mealSheadule[0] = breakfast;
        mealSheadule[1] = dinner;
        mealSheadule[2] = supper;
    }
    @Override
    public String getFullInfo () {
        String res = super.getFullInfo();
        res += "\nMeal Sheadule: ";
        res += mealSheadule;
        return res;
    }
}
