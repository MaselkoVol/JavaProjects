package droidGame.droids;

public class LaserDroid extends Droid{
    public LaserDroid(String name) {
        super(name,"LaserDroid", "laser", "chainsaw", 100, 12, 8);
    }
    @Override public LaserDroid createCopy (String name) {
        return new LaserDroid(name);
    }
}
