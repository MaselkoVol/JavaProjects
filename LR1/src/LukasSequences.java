import java.util.Scanner;

/**
 * Create array from Lukas sequences.
 */
public class LukasSequences {
    Value[] sequences;

    /**
     * If there is no arguments you will input Lukas sequences by keyboard, else sequences will be created by console
     *
     * @param args console arguments
     */
    LukasSequences(String[] args) {
        if (args.length == 0) {
            inputKeyboard();
        } else {
            inputConsole(args);
        }
    }

    /**
     * input from keyboard
     */
    LukasSequences() {
        inputKeyboard();
    }

    /**
     * prints all Lukas sequences
     */
    public void print() {
        for (int i = 0; i < sequences.length; i++) {
            System.out.println("first " + sequences[i].getSequence().getLength() + " numbers. Last digit is " + sequences[i].getLastDigit());
            System.out.print("#" + (i + 1) + ":\t");
            sequences[i].getSequence().print();
            System.out.print("\t");
            sequences[i].getSequence().printLastDigit(sequences[i].getLastDigit());
            System.out.println("");
        }
    }

    /**
     * create Lukas sequences by keyboard. For each sequence you need to input: sequenceLength lastDigit
     */
    private void inputKeyboard() {
        Scanner scan = new Scanner(System.in);
        System.out.print("How many Lukas sequences do you want: ");
        int sequenceslen = scan.nextInt();
        scan.nextLine();

        sequences = new Value[sequenceslen];
        System.out.println("first n Lukas numbers and last digit (len last)");
        String[] tmp;
        int lastDigit, seqLen;
        for (int i = 0; i < sequenceslen; i++) {
            System.out.print("#" + (i + 1) + ": ");

            tmp = scan.nextLine().split(" ");
            if (tmp.length < 2) {
                System.out.println("Input like that: 20 4, it means length of sequence is 20, last digit is 4");
                System.exit(0);
            }
            lastDigit = Integer.parseInt(tmp[1]);
            seqLen = Integer.parseInt(tmp[0]);
            if (!validateValue(seqLen, lastDigit)) {
                System.out.println("Your input is wrong");
                System.exit(0);
            }
            sequences[i] = new Value(new LukasSequence(seqLen), lastDigit);
        }
    }

    /**
     * for console you need to input: sequence1Length lastDigit1 sequence2Length lastDigit2...
     *
     * @param args argument from main method
     */
    private void inputConsole(String[] args) {
        sequences = new Value[(int) Math.ceil((double) args.length / 2)];
        int seqLen, lastDigit;
        for (int i = 0; i < sequences.length; i++) {
            seqLen = Integer.parseInt(args[2 * i]);
            if (2 * i + 1 < args.length) {
                lastDigit = Integer.parseInt(args[2 * i + 1]);
            } else {
                lastDigit = 1;
            }
            if (!validateValue(seqLen, lastDigit)) System.exit(0);

            sequences[i] = new Value(new LukasSequence(seqLen), lastDigit);
        }
    }

    // seqLen - one sequence length
    private boolean validateValue(int seqLen, int lastDigit) {
        if (seqLen < 0) return false;
        if (lastDigit < 0 || lastDigit > 9) return false;
        return true;
    }
}

/**
 * contain sequence and last digit.
 * By this last digit you can find all numbers in sequence that have this digit
 */

class Value {
    private LukasSequence sequnece;
    private int lastDigit;

    Value(LukasSequence sequnece, int lastDigit) {
        this.sequnece = sequnece;
        this.lastDigit = lastDigit;
    }

    public LukasSequence getSequence() {
        return sequnece;
    }

    public int getLastDigit() {
        return lastDigit;
    }
}
