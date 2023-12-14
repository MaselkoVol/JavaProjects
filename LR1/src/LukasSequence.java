import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Generate first n Lukas numbers and remember them during the program.
 * It uses ArrayList to save numbers in a single copy.
 * Each number is a BigInteger.
 */
public class LukasSequence {
    // static array list of lukas numbers with big integer values
    private static List<BigInteger> sequence = new ArrayList<BigInteger>(2);

    // length you need
    private int length;

    // adds first two value to Lukas numbers when class is initializated first time
    static {
        sequence.add(new BigInteger("2"));
        sequence.add(new BigInteger("1"));
    }

    /**
     * adds numbers to the static array by need.
     * @param length length of cur sequence
     */
    public LukasSequence(int length) {
        this.length = length;
        this.addNumbersByNeed(length);
    }

    /**
     * create sequence with 0 length
     */
    public LukasSequence() {
        length = 0;
    }

    /**
     * prints first n Lukas numbers
     */
    public void print() {
        int i;
        for (i = 0; i < length - 1; i++) {
            System.out.print(sequence.get(i) + ", ");
        }
        System.out.println(sequence.get(i));
    }
    /**
     * prints first n Lukas numbers that ends with certain digit
     * @param digit last digit of some numbers in Lukas sequence
     */
    public void printLastDigit (int digit) {
        // k is needed to remember last number
        int k = -1;
        for (int i = 0; i < length; i++) {
            // num % 10 == your digit
            if (sequence.get(i).remainder(BigInteger.valueOf(10)).compareTo(BigInteger.valueOf(digit)) == 0 ) {
                if (k != -1) System.out.print(k + 1 + ") " + sequence.get(k) + ", ");
                k = i;
            }
        }
        if (k != -1) {
            System.out.println(k + 1 + ") " + sequence.get(k));
        } else {
            System.out.println("There is no number ends with this digit");
        }
    }
    public int getLength() {
        return length;
    }

    // adds Lukas numbers to end of static array list
    // n - last index of Lukas number
    private void addNumbersByNeed (int n) {
        if (sequence.size() < n) {
            for (int i = sequence.size(); i < n; i++) {
                sequence.add(new BigInteger((sequence.get(i - 2).add(sequence.get(i - 1))).toString()));
            }
        }
    }

}
