package command;

import info.ProgramInfo;
import user.UserTickets;


public class InfoCommand implements Command {
    private ProgramInfo programInfo;
    private UserTickets userTickets;
    public InfoCommand (UserTickets userTickets) {
        this.userTickets = userTickets;
        programInfo = new ProgramInfo();
    }
    @Override
    public boolean execute() {
        programInfo.showAllInfo();
        return true;
    }

    @Override
    public InfoCommand createCopy(UserTickets userTickets) {
        return new InfoCommand(userTickets);
    }
    @Override
    public String toString () {
        return "info";
    }

}
