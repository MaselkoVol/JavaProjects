package command;


import user.UserTickets;


public interface Command {
    boolean execute ();
    Command createCopy(UserTickets userTickets);
}

