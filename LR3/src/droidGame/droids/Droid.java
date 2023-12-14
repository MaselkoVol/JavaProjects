package droidGame.droids;

public class Droid {
    protected String name;
    protected String type;
    protected String weaponType;
    protected String defenseType;
    protected final int maxHealth;
    protected int health;
    protected int damage;
    protected int defense;

    protected Droid (String name, String type, String weaponType, String defenseType, int maxHealth, int damage, int defense) {
        this.name = name;
        this.type = type;
        this.weaponType = weaponType;
        this.defenseType = defenseType;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.damage = damage;
        this.defense = defense;
    }
    public String getName () {
        return name;
    }
    public String getType() {
        return type;
    }
    public int getHealth () {
        return health;
    }
    public void setMaxHealth () {
        health = maxHealth;
    }
    public int attack (Droid droid) { // ENUM
        int harm = damage;
        if (weaponType.equals(droid.defenseType) || droid.defenseType.equals("everything"))
            harm -= droid.defense;
        if (harm < 2)
            harm = 2;
        return harm;
    }
    public int takeDamage(int damage) {
        int initHealth = health;
        health -= damage;
        if (health < 0)
            health = 0;
        return initHealth - health;
    }
    public Droid createCopy (String name) {
        return new Droid(name, type, weaponType, defenseType, maxHealth, damage, defense);
    }
    public String getFullInfo () {
        return "Type: " + type +
                "\nWeapon: " + weaponType +
                "\nHas defense from: " + defenseType +
                "\nHealth: " + health +
                "\nDamage: " + damage +
                "\nDefense: " + defense;
    }
    @Override public String toString () {
        return "Name: " + name + ", Hp:" + health;
    }
}
