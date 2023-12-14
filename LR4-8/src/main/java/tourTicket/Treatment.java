package tourTicket;

import java.sql.Time;

public class Treatment extends VacationWithIngestion {
    private String procedures;
    public Treatment (String procedures, Ingestion[] mealSheadule, String title, String transport, String location, int cost, int duration) {
        super(title, transport, location, cost, duration);
        this.procedures = procedures;
        this.mealSheadule = mealSheadule;
    }
    public Treatment (String procedures, String title, String transport, String location, int cost, int duration) {
        super(title, transport, location, cost, duration);
        this.procedures = procedures;
    }
    @Override
    public Treatment createCopy() {
        Treatment newVacation = new Treatment(procedures,mealSheadule, title, transport, location, cost, duration);
        newVacation.identificator = identificator;
        return newVacation;
    }
    @Override
    public String getFullInfo () {
        String res = super.getFullInfo();
        res += "\nProcedures: ";
        res += procedures;
        return res;
    }
}
