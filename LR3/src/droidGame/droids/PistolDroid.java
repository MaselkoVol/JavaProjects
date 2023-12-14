package droidGame.droids;

public class PistolDroid extends Droid {
    public PistolDroid(String name) {
        super(name,"PistolDroid", "pistol", "bazuka", 100, 8, 4);
    }
    @Override
    public int attack (Droid droid) {
        if (super.attack(droid) == damage)
            return damage * 2;
        return damage;
    }
    @Override
    public PistolDroid createCopy (String name) {
        return new PistolDroid(name);
    }
}
