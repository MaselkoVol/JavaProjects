package tourTicket;

public class Vacation {
    private static int globalIdentificator = 0;
    protected int identificator;
    protected String title;
    protected String transport;
    protected String location;
    protected int cost;
    protected int duration;
    public Vacation (String title, String transport, String location, int cost, int duration) {
        this.title = title;
        this.transport = transport;
        this.location = location;
        if (cost > 0)
            this.cost = cost;
        if (duration > 0)
            this.duration = duration;
    }
    public void setUniqueIdentificator () {
        identificator = globalIdentificator;
        globalIdentificator++;
    }
    public Vacation createCopy() {
        return null;
    }
    @Override
    public String toString () {
        String res = "";
        res += "Title: ";
        res += title;
        return res;
    }
    public String getFullInfo () {
        String res = "";
        res += "Title: ";
        res += title;
        res += "\nLocation: ";
        res += location;
        res += "\nDuration: " + " days";
        res += duration;
        res += "\nTransport: ";
        res += transport;
        res += "\nCost: ";
        res += ((double) cost) / 100;
        return res;
    }

    public int getCost() {
        return cost;
    }

    public int getDuration() {
        return duration;
    }

    public int getIdentificator() {
        return identificator;
    }
}
