package droidGame.droids;

public class BazukaDroid extends Droid{
    public BazukaDroid (String name) {
        super(name,"BazukaDroid", "bazuka", "nothing", 100, 16, 0);
    }
    @Override public BazukaDroid createCopy (String name) {
        return new BazukaDroid(name);
    }
}
