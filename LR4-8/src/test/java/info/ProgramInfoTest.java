package info;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProgramInfoTest {
    @Test
    void showAllTicketsWorksFine() {
        ProgramInfo programInfo = new ProgramInfo();
        Assertions.assertEquals(true, programInfo.showAllTickets());
    }
    @Test
    void showAllCommandsWorksFine() {
        ProgramInfo programInfo = new ProgramInfo();
        Assertions.assertEquals(true, programInfo.showAllCommands());
    }
    @Test
    void showAllInfoWorksFine() {
        ProgramInfo programInfo = new ProgramInfo();
        programInfo.showAllInfo();
    }
}