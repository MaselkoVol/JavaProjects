package droidGame.DroidGame;
import droidGame.droids.*;

import java.io.*;
import java.util.Scanner;
import java.util.LinkedList;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import droidGame.util.Util;
public class DroidGame {
    Scanner scanner = new Scanner(System.in);
    private int droidSubIndex; // використувається при створенні дроїдів, тобто номер партії
    private final LinkedList<Droid> droids = new LinkedList<Droid>();
    private final LinkedList<Droid> team1 = new LinkedList<Droid>();
    private final LinkedList<Droid> team2 = new LinkedList<Droid>();
    public DroidGame() {
        droidSubIndex = 1;
        menu();
    }
    private void menu () {
        while (true) {
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃                                            MENU                                             ┃");
            System.out.println("┃ 0 - add droids              3 - fight team vs team           6 - fight team vs team to file ┃");
            System.out.println("┃ 1 - show all droids         4 - add droids from file         7 - Info                       ┃");
            System.out.println("┃ 2 - fight 1 vs 1            5 - fight 1 vs 1 to file                                        ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

            int mode = -1;
            String modeStr = scanner.nextLine();
            if (modeStr.trim().isEmpty())
                break;
            try {
                mode = Integer.parseInt(modeStr);
            } catch (Exception e) {
                continue;
            }
            switch (mode) {
                case 0 -> enterDroids();
                case 1 -> System.out.println(this);
                case 2 -> singleBattle();
                case 3 -> teamBattleConsole();
                case 4 -> addDroidsFromFile();
                case 5 -> singleBattleToFile();
                case 6 -> teamBattleToFile();
                case 7 -> printInfo();
            }
        }
    }
    private void printInfo() {
        for (int i = 0; i < Util.droidExemplars.length; i++) {
            System.out.println("━━━━━━━━━━━━━━━━ " + (i + 1) + " ━━━━━━━━━━━━━━━━━━━");
            System.out.println(Util.droidExemplars[i].getFullInfo());
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        }
    }
    private File enterFileName() {
        File file;
        String fileName;
        printInfo("Recommendation: " + Util.RECOMMENDATION_FILE_TO_WRITE);
        copyToClipboard(Util.RECOMMENDATION_FILE_TO_WRITE);
        while (true) {
            System.out.print("Enter file name: ");
            fileName = scanner.nextLine();
            try {
                file = new File(fileName);
                if (file.createNewFile()) {
                    System.out.println("The file was created sucsesfully");
                } else {
                    System.out.println("Data from this file will be delited, to confirm Enter \"yes\"");
                    if (!scanner.nextLine().trim().equals("yes"))
                        continue;
                }
            } catch (Exception e) {
                System.out.println("Coudn't create file");
                continue;
            }
            break;
        }
        return file;
    }
    private Droid fight (Droid droid1, Droid droid2, String [] fightInfo) {
        int i = 1;
        String fightResult = "";
        String winnerResult = "";
        int droid1TakenDamage, droid2TakenDamage;
        do {
            fightResult += "┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n";
            fightResult += "┃                         round " + String.format("%-5d", i) + "                      ┃\n";
            fightResult += "┃ " + String.format("%-56s", droid1) + " ┃\n";
            fightResult += "┃ " + String.format("%-56s", droid2) + " ┃\n";
            droid2TakenDamage = droid2.takeDamage(droid1.attack(droid2));
            droid1TakenDamage = droid1.takeDamage(droid2.attack(droid1));
            fightResult += "┃ "+ String.format("%-18s",droid1.getName()) +" damaged "+ String.format("%-18s",droid2.getName()) +" by " + String.format("%4d",droid2TakenDamage) + " hp ┃\n";
            fightResult += "┃ "+ String.format("%-18s",droid2.getName()) +" damaged "+ String.format("%-18s",droid1.getName()) +" by " + String.format("%4d",droid1TakenDamage) + " hp ┃\n";
            fightResult += "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n";
            i++;
            System.out.println(fightResult);

        }while (droid1.getHealth() > 0 && droid2.getHealth() > 0);

        winnerResult += "┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n";
        Droid winner = null;
        if (droid1.getHealth() <= 0 && droid2.getHealth() <= 0) {
            winnerResult += "┃ " + String.format("%-35s", "Droids killed each other") + " ┃\n";
            team1.remove(droid1);
            team2.remove(droid2);
        } else if (droid1.getHealth() <= 0) {
            winner = droid2;
            winnerResult += "┃ " + String.format("%-35s", "Droid " + droid2.getName() + " won") + " ┃\n";
            winnerResult += "┃ " + String.format("%-35s", "Droid " + droid1.getName() + " is dead") + " ┃\n";
            team1.remove(droid1);
        } else {
            winner = droid1;
            winnerResult += "┃ " + String.format("%-35s", "Droid " + droid1.getName() + " won") + " ┃\n";
            winnerResult += "┃ " + String.format("%-35s", "Droid " + droid2.getName() + " is dead") + " ┃\n";
            team2.remove(droid2);
        }
        winnerResult += "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛";
        fightInfo[0] = fightResult;
        fightInfo[1] = winnerResult;
        return winner;
    }
    private void endOfBattle () {
        Droid droid;
        for (int i = team1.size() -1; i >= 0; i--) { // регенерую всім дроїдам здоров'я і повертаю до бази
            droid = team1.getLast();
            droid.setMaxHealth();
            droids.add(droid);
            team1.removeLast();
        }
        for (int i = team2.size() -1; i >= 0; i--) {
            droid = team2.getLast();
            droid.setMaxHealth();
            droids.add(droid);
            team2.removeLast();
        }
    }
    private int getRandIndex(int size) {
        return (int) (Math.random() * (size - 1));
    }
    private void formTeams () {
        int droidsSize = droids.size();
        int randomElemIndex;
        Droid randomDroid;
        while (droidsSize > 1) {
            randomElemIndex = getRandIndex(droidsSize);
            randomDroid = droids.get(randomElemIndex);
            team1.add(randomDroid);
            droids.remove(randomDroid);

            randomElemIndex = getRandIndex(droidsSize);
            randomDroid = droids.get(randomElemIndex);
            team2.add(randomDroid);
            droids.remove(randomDroid);
            droidsSize -= 2;
        }
    }
    private String teamBattle () {
        String battleInfo = "";
        formTeams();
        String fightInfo[] = new String[2];
        String fightersResult;
        String teamBattleResult = "";
        Droid team1RandDroid, team2RandDroid;
        int i = 1;
        while (!team1.isEmpty() && !team2.isEmpty()) {
            team1RandDroid = team1.get(getRandIndex(team1.size()));
            team2RandDroid = team2.get(getRandIndex(team2.size()));
            battleInfo +=listToString(team1, "team 1") + "\n";
            battleInfo +=listToString(team2, "team 2") + "\n";
            fightersResult = "┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n";
            fightersResult += "┃            Battle " + String.format("%-5d", i) + "        ┃\n";
            fightersResult += "┃ " + String.format("%-30s", team1RandDroid) + " ┃\n";
            fightersResult += "┃ " + String.format("%-30s", team2RandDroid) + " ┃\n";
            fightersResult += "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n";
            fight(team1RandDroid, team2RandDroid, fightInfo);
            battleInfo += fightersResult;
            battleInfo += fightInfo[1] + "\n";
            i++;
        }

        teamBattleResult = "\n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n";
        if (team1.isEmpty() && team2.isEmpty()) {
            teamBattleResult += "┃ " + String.format("%-25s", "All teams are dead") + " ┃\n";
        } else if (team1.isEmpty()) {
            teamBattleResult += "┃ " + String.format("%-25s", "team2 won") + " ┃\n";
        } else {
            teamBattleResult += "┃ " + String.format("%-25s", "team1 won") + " ┃\n";
        }
        teamBattleResult += "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n";
        battleInfo += teamBattleResult;
        endOfBattle();
        return battleInfo;
    }
    private void teamBattleConsole () {
        String battleInfo = teamBattle();
        System.out.println(battleInfo);
    }
    private void teamBattleToFile () {
        File file = enterFileName();
        FileWriter fw;
        FileReader fileReader;
        BufferedReader fr;
        String battleResult = teamBattle();
        try {
            fw = new FileWriter(file);
            fw.write(battleResult);
            fw.close();
            fileReader = new FileReader(file);
            fr = new BufferedReader(fileReader);
            String line;
            while ((line = fr.readLine()) != null) {
                System.out.println(line);
            }
            fr.close();
        } catch (Exception e) {
        }
    }
    private Droid chooseDroid() {
        int i;
        String type;
        while (true) {
            System.out.print("type: ");
            type = scanner.nextLine();
            if (type == "")
                return null;
            i = 0;
            for (Droid droid: droids) {
                if (droid.getType().equals(type))
                    break;
                i++;
            }
            if (i != droids.size())
                break;
            printError("You haven't droids with this type");
        }
        return droids.get(i);
    }
    private Droid[] enterTwoDroids() {
        Droid [] twoDroids = new Droid[2];
        System.out.println(this);
        System.out.println("Choose droid types");
        System.out.print("Droid #1 ");
        twoDroids[0] = chooseDroid();
        if (twoDroids[0] == null)
            return null;
        team1.add(twoDroids[0]);
        droids.remove(twoDroids[0]);
        System.out.print("Droid #2 ");
        twoDroids[1] = chooseDroid();
        if (twoDroids[1] == null)
            return null;
        team2.add(twoDroids[1]);
        droids.remove(twoDroids[1]);
        return twoDroids;
    }
    private void singleBattleToFile () {
        File file = enterFileName();
        Droid[] twoDroids = enterTwoDroids();
        if (twoDroids == null)
            return;
        String []fightInfo = new String[2];
        Droid winner = fight(team1.getFirst(), team2.getFirst(), fightInfo);
        FileWriter fw;
        FileReader fileReader;
        BufferedReader fr;
        try {
            fw = new FileWriter(file);
            fw.write(fightInfo[0]);
            fw.write(fightInfo[1]);
            fw.close();
            fileReader = new FileReader(file);
            fr = new BufferedReader(fileReader);
            String line;
            while ((line = fr.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            return;
        }
        endOfBattle();
    }
    private void singleBattle () {
        Droid[] twoDroids = enterTwoDroids();
        if (twoDroids == null)
            return;
        String []fightInfo = new String[2];
        Droid winner = fight(team1.getFirst(), team2.getFirst(), fightInfo);
        System.out.println(fightInfo[0]);
        System.out.println(fightInfo[1]);
        endOfBattle();
    }
    private void printError(String str) {
        System.out.println(Util.RED_COLOR + str + Util.resetColor);
    }
    private void printInfo(String str) {
        System.out.println(Util.greenColor + str + Util.resetColor);
    }
    private void printAllTypesOfDroids () {
        String result = "";
        for (int i = 0; i < 3; i++) { // вивести всі типи дроїдів
            int k = i;
            while (k < Util.droidExemplars.length) {
                result += String.format("%d - %-24s",k + 1, Util.droidExemplars[k].getType());
                k+= 3;
            }
            if (i != 2)
                result += "\n";
        }
        printInfo(result);
    }
    private void enterDroids () {

        printAllTypesOfDroids();

        int amount; // кількість дроїдів
        String type;
        Droid exemplar;
        String [] dataValues; // зберігає кількість і тип дроїда
        int isCorrectData;
        while (true) {
            System.out.print("droids batch #" + droidSubIndex + " ");
            while (true) {
                System.out.print("(amount : type): ");
                dataValues = scanner.nextLine().split(":");
                isCorrectData = checkLineToAddDroids(dataValues);
                if (isCorrectData == -1)
                    return;
                else if (isCorrectData == 0) {
                    printError("incorect data");
                    continue;
                }
                amount = Integer.parseInt(dataValues[0]);
                type = dataValues[1].trim();
                exemplar = addDroidsByType(amount, type);
                if (exemplar != null)
                    break;
                printError("incorect data");
            }
            droidSubIndex++;
        }
    }
    private int checkLineToAddDroids(String[] dataValues){
        if (dataValues[0].trim().equals("")) // перестати вводити
            return -1;
        if (dataValues.length == 1)
            return 0;

        int amount;
        try {
            amount = Integer.parseInt(dataValues[0]);
        } catch (Exception e) {
            return 0;
        }
        if (amount <= 0) {
            return 0;
        }

        return 1;
    }
    private Droid addDroidsByType(int amount, String type) {
        Droid exemplar = null;
        for (int i = 0; i < Util.droidExemplars.length; i++) {
            if (Util.droidExemplars[i].getType().equals(type))
                exemplar = Util.droidExemplars[i];
        }
        if (exemplar == null)
            return null;
        String name = exemplar.getType() + Integer.toString(droidSubIndex);
        for (int i = 0; i < amount; i++) {
            droids.add(exemplar.createCopy(name + i));
        }
        return exemplar;
    }
    private void addDroidsFromFile () {
        BufferedReader br;
        FileReader file;
        while (true) {
            printInfo("Recommendation: " + Util.RECOMMENDATION_FILE);
            copyToClipboard(Util.RECOMMENDATION_FILE);
            System.out.print("Enter file name: ");
            String fileName = scanner.nextLine().trim();
            try {
                file = new FileReader(fileName);
            } catch (Exception e) {
                printError("There is no file with this name");
                continue;
            }
            break;
        }
        br = new BufferedReader(file);
        String line;
        String [] dataValues;
        int amount; // кількість дроїдів
        String type;
        Droid exemplar;
        int isCorrectData;
        try {
            while ((line = br.readLine()) != null) {
                dataValues = line.split(":");
                isCorrectData = checkLineToAddDroids(dataValues);
                if (isCorrectData == -1)
                    return;
                else if (isCorrectData == 0) {
                    continue;
                }
                amount = Integer.parseInt(dataValues[0]);
                type = dataValues[1].trim();
                exemplar = addDroidsByType(amount, type);
                if (exemplar != null)
                    droidSubIndex++;
            }
        } catch (Exception e) {
            return;
        }
    }
    private int countDroidsWithType(LinkedList<Droid> arrList, String type) {
        int counter = 0;
        for (Droid droid: arrList) {
            if (droid.getType().equals(type))
                counter++;
        }
        return counter;
    }
    private String listToString (LinkedList<Droid> arrList, String message) {
        String result =   "┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n";
        result +=         "┃          " + String.format("%-8s", message) +"          ┃\n";
        int counter = 0;
        for (int i = 0; i < Util.droidExemplars.length; i++) {
            counter = countDroidsWithType(arrList, Util.droidExemplars[i].getType());
            if (counter != 0)
                result += "┃ "+ String.format("%4d: ", counter) + String.format("%-20s", Util.droidExemplars[i].getType()) + " ┃\n";
        }
        result +=         "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛";
        return result;
    }
    @Override public String toString () {
        return listToString(droids, "You have");
    }
    private void copyToClipboard(String text) {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection selection = new StringSelection(text);
        clipboard.setContents(selection, null);
    }
}
