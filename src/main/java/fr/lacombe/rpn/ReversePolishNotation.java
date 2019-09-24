package fr.lacombe.rpn;

import java.util.Stack;

public class ReversePolishNotation {

    private static final String SEPARATOR = " ";

    public int compute(String input) {

        if (input.equals("")) {
            return 0;
        }

        Stack<Integer> number = new Stack<>();
        for (String str : input.split(SEPARATOR)) {
            if (isNumeric(str)) {
                number.push(Integer.parseInt(str));
            } else {
                number.push(Operator.of(str).compute(number.pop(), number.pop()));
            }
        }

        return number.pop();
    }

    private static boolean isNumeric(String str) {
        if (str == null)
            return false;
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
