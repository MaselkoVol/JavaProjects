package droidGame.droids;

public class ChainsawDroid extends Droid {
    public ChainsawDroid(String name) {
        super(name,"ChainsawDroid", "chainsaw", "lazer", 100, 12, 4);
    }
    @Override public ChainsawDroid createCopy (String name) {
        return new ChainsawDroid(name);
    }
}
