package tourTicket;
import java.sql.Time;
public class Ingestion {
    private String description;
    private Time time;
    public Ingestion (String description, Time time) {
        this.description = description;
        this.time = time;
    }

}
