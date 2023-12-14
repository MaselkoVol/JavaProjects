package user;

import tourTicket.Vacation;

import java.util.LinkedList;

public class UserTickets {
    private LinkedList<Vacation> userTickets;

    public UserTickets() {
        userTickets = new LinkedList<>();
    }
    public void add(Vacation vacation) {
        userTickets.add(vacation);
    }
    public boolean remove(Vacation vacation) {
        userTickets.remove(vacation);
        return true;
    }

    public LinkedList<Vacation> getUserTickets() {
        return userTickets;
    }

    @Override
    public String toString() {
        String res = "";
        int i = 1;
        for (Vacation vacation: userTickets) {
            res += i + ") " + vacation + "\n";
            i++;
        }
        return res;
    }
}
