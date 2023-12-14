package droidGame.util;

import droidGame.droids.*;

public class Util {
    public static final String RECOMMENDATION_FILE = "botsInputLR3.txt";
    public static final String RECOMMENDATION_FILE_TO_WRITE = "fileRaderLR3.txt";
    public static final String RED_COLOR = "\u001b[31m"; // Червоний
    public static final String greenColor = "\u001b[32m"; // Зелений
    public static final String resetColor = "\u001b[0m"; // Скидання до стандартного кольору

    public static final BazukaDroid bazukaDroid = new BazukaDroid("test");
    public static final ChainsawDroid chainsawDroid = new ChainsawDroid("test");
    public static final HealerDroid healerDroid = new HealerDroid("test");
    public static final LaserDroid laserDroid = new LaserDroid("test");
    public static final PistolDroid pistolDroid = new PistolDroid("test");
    public static final TankDroid tankDroid = new TankDroid("test");
    public static final Droid[] droidExemplars = {bazukaDroid, chainsawDroid, healerDroid, laserDroid, pistolDroid, tankDroid};
}
