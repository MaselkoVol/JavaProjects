import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.Stack;
public class OperationManager {
    public LinkedList<String> converToPolish (String expression) {
        try {
            LinkedList<String> polishExpression = new LinkedList<>();
            polishExpression.add(expression);
            int pos;

            // a loop to go deeper in spliting operations
            while (true) {
                int count = 0;
                // going through linked list with partly splited operations
                for (int i = 0; i < polishExpression.size(); i++) {
                    expression = polishExpression.get(i);
                    // deleting parenthesis in expression if it is full covered by them
                    if (expression.substring(expression.length() - 1).equals(Operators.RIGHT_PARENTHESIS) && findEndOfRightParenthesis(expression, expression.length() - 1) == 0) {
                        polishExpression.set(i, expression.substring(1, expression.length() - 1));
                    }
                    // if it is operator, the current expression is already splited
                    if (getOperatorSignificance(polishExpression.get(i)) == -1) {
                        pos = findPositionOfRightLeastValuableOperator(polishExpression.get(i));
                        if (pos == -1) {
                            count++;
                            continue;
                        }
                        // inserting into linked list operator and operands instead of expression (operands can be expressions)
                        insertSplitedExpression(polishExpression, i, pos);
                    } else {
                        count++;
                    }
                }
                if (count == polishExpression.size())
                    break;
            }
            for (int i = 0; i < polishExpression.size(); i++) {
                System.out.println(polishExpression.get(i));
            }
            return polishExpression;
        } catch (Exception e) {
            return null;
        }
    }
    private int findEndOfRightParenthesis(String expression, int i) {
        int pos = i;
        int parenthesisCounter = 1;
        while (parenthesisCounter != 0 && i >= 0) {
            i--;
            if (expression.substring(i, i + 1).equals(Operators.RIGHT_PARENTHESIS)) {
                parenthesisCounter++;
            } else if (expression.substring(i, i + 1).equals(Operators.LEFT_PARENTHESIS)) {
                parenthesisCounter--;
            }
            pos = i;
        }
        return pos;
    }
    private void insertSplitedExpression(LinkedList<String> polishExpression, int i, int pos) {
        String expression = polishExpression.get(i);
        if (unaryMinusCheck(expression, pos)) {
            polishExpression.set(i, "~");
        } else {
            polishExpression.set(i, expression.substring(pos, pos + 1));
        }
        if (expression.substring(pos, pos + 1).equals(Operators.ROOT) ||
            unaryMinusCheck(expression, pos)) {
            polishExpression.add(i + 1, expression.substring(pos + 1));
        } else {
            polishExpression.add(i + 1, expression.substring(0, pos));
            polishExpression.add(i + 2, expression.substring(pos + 1));
        }

    }
    private int getOperatorSignificance (String expression) {
        for (int k = 0; k < Operators.SIGNIFICANCE.length; k++) {
            for (int j = 0; j < Operators.SIGNIFICANCE[k].size(); j++) {
                if (expression.equals(Operators.SIGNIFICANCE[k].get(j))) {
                    return k;
                }
            }
        }
        return -1;
    }
    private int findPositionOfRightLeastValuableOperator(String expression) {
        int pos = -1;
        int leastIndex = Operators.SIGNIFICANCE.length;

        for (int i = expression.length() - 1; i >= 0 && leastIndex != 0; i--) {
            String curChar = expression.substring(i, i + 1);
            // if there is parenthesis in expression - skip it
            if (curChar.equals(Operators.RIGHT_PARENTHESIS)) {
                int parenthesisCounter = 1;
                while (parenthesisCounter != 0) {
                    i--;
                    if (expression.substring(i, i + 1).equals(Operators.RIGHT_PARENTHESIS)) {
                        parenthesisCounter++;
                    } else if (expression.substring(i, i + 1).equals(Operators.LEFT_PARENTHESIS)) {
                        parenthesisCounter--;
                    }
                }
            }
            for (int k = 0; k < Operators.SIGNIFICANCE.length; k++) {
                for (int j = 0; j < Operators.SIGNIFICANCE[k].size(); j++) {
                    if (curChar.equals(Operators.SIGNIFICANCE[k].get(j)) && leastIndex > k) {
                        //check on unary minus
                        if (unaryMinusCheck(expression, i) && leastIndex == Operators.SIGNIFICANCE.length) {
                            pos = i;
                            continue;
                        }
                        leastIndex = k;
                        pos = i;
                    }
                }
            }
            // check on unary minus
            if (curChar.equals(Operators.MINUS) && (i == 0 || expression.substring(i - 1, i).equals(Operators.LEFT_PARENTHESIS)) ) {
                if (leastIndex == Operators.SIGNIFICANCE.length) {
                    pos = i;
                }
            }
        }
        return pos;
    }
    public boolean unaryMinusCheck(String expression, int pos) {
        if (pos == -1)
            return false;
        if (expression.substring(pos, pos + 1).equals(Operators.MINUS) && (pos == 0 || expression.substring(pos - 1, pos).equals(Operators.LEFT_PARENTHESIS))) {
            return true;
        }
        return false;
    }
    public String calculatePolish(LinkedList<String> polishExpression) {
        if (polishExpression == null) {
            return "Error";
        }
        try {
            Stack<Double> stack = new Stack<>();
            double operand1, operand2;
            for (int i = polishExpression.size() - 1; i >= 0; i--) {
                String token = polishExpression.get(i);

                if (token.equals(Operators.PLUS)) {
                    operand1 = stack.pop();
                    operand2 = stack.pop();
                    stack.push(operand1 + operand2);
                } else if (token.equals(Operators.MINUS)) {
                    operand1 = stack.pop();
                    operand2 = stack.pop();
                    stack.push(operand1 - operand2);
                } else if (token.equals(Operators.MULTIPLY)) {
                    operand1 = stack.pop();
                    operand2 = stack.pop();
                    stack.push(operand1 * operand2);
                } else if (token.equals(Operators.DIVIDE)) {
                    operand1 = stack.pop();
                    operand2 = stack.pop();
                    stack.push(operand1 / operand2);
                } else if (token.equals(Operators.POWER)) {
                    operand1 = stack.pop();
                    operand2 = stack.pop();
                    stack.push(Math.pow(operand1, operand2));
                } else if (token.equals(Operators.ROOT)) {
                    operand1 = stack.pop();
                    stack.push(Math.sqrt(operand1));
                } else if (token.equals("~")) {
                    operand1 = stack.pop();
                    stack.push(-operand1);
                } else if (token.equals(Operators.PI)) {
                    stack.push(Math.PI);
                } else if (token.equals(Operators.E)) {
                    stack.push(Math.E);
                } else {
                    stack.push(Double.parseDouble(token));
                }
            }
            String result = String.valueOf(stack.pop());
            if (result.substring(result.length() - 2).equals(".0"))
                return result.substring(0, result.length() -2);
            return result;
        } catch (Exception e) {
            return "Error";
        }
    }
    public String convertPolishToURL (LinkedList<String> polishExpression) {
        String result = "";
        String curElement;
        for (int i = 0; i < polishExpression.size(); i++) {
            curElement = polishExpression.get(i);
            if (Operators.OPERATORS_NAME.containsKey(curElement)) {
                result = result.concat(Operators.OPERATORS_NAME.get(curElement)).concat("+");
                continue;
            }
            result = result.concat(curElement).concat("+");
            curElement = polishExpression.get(i);
        }
        return result.substring(0, result.length() - 1);
    }
}
