package droidGame.droids;

public class TankDroid extends Droid {
    public TankDroid (String name) {
        super(name,"TankDroid", "knife", "everything", 300, 4, 2);
    }
    @Override public TankDroid createCopy (String name) {
        return new TankDroid(name);
    }
}

