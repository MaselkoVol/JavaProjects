import jdk.dynalink.beans.StaticClass;

import java.util.ArrayList;
import java.util.HashMap;

public class Operators {
    public static String SEND = "📩";
    public static String E = "e";
    public static String PI = "π";
    public static String POWER = "^";
    public static String ROOT = "√";
    public static String PLUS = "+";
    public static String MINUS = "-";
    public static String MULTIPLY = "*";
    public static String DIVIDE = "/";
    public static String DOT = ".";
    public static String EQUAL = "=";
    public static String DELETE = "✖";
    public static String CLEAR = "AC";
    public static String LEFT_PARENTHESIS = "(";
    public static String RIGHT_PARENTHESIS = ")";

    public static ArrayList<String> SIGNIFICANCE_1 = new ArrayList<String>();
    public static ArrayList<String> SIGNIFICANCE_2 = new ArrayList<String>();
    public static ArrayList<String> SIGNIFICANCE_3 = new ArrayList<String>();
    static {
        SIGNIFICANCE_1.add(PLUS);
        SIGNIFICANCE_1.add(MINUS);

        SIGNIFICANCE_2.add(MULTIPLY);
        SIGNIFICANCE_2.add(DIVIDE);

        SIGNIFICANCE_3.add(POWER);
        SIGNIFICANCE_3.add(ROOT);
    }
    public static ArrayList[] SIGNIFICANCE = new ArrayList[]{SIGNIFICANCE_1, SIGNIFICANCE_2, SIGNIFICANCE_3};
    public static HashMap<String, String> OPERATORS_NAME = new HashMap<>();
    static {
        OPERATORS_NAME.put(PLUS, "plus");
        OPERATORS_NAME.put(MINUS, "minus");
        OPERATORS_NAME.put(DIVIDE, "divide");
        OPERATORS_NAME.put(MULTIPLY, "multiply");
        OPERATORS_NAME.put("~", "unaryMinus");
        OPERATORS_NAME.put(POWER, "power");
        OPERATORS_NAME.put(ROOT, "root");
    }
}
