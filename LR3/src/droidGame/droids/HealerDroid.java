package droidGame.droids;

public class HealerDroid extends Droid{
    public HealerDroid (String name) {
        super(name,"HealerDroid", "hammer", "knife", 100, 8, 4);
    }
    @Override public int takeDamage(int damage) {
        int takenDamage = super.takeDamage(damage);
        if (takenDamage > 4)
            health += 4;
        if (health > maxHealth)
            health = maxHealth;
        return takenDamage;
    }
    @Override public HealerDroid createCopy (String name) {
        return new HealerDroid(name);
    }
    @Override public String getFullInfo () {
        String result = super.getFullInfo();
        result += "\nEvery round regenerates 2 hp";
        return result;
    }

}
