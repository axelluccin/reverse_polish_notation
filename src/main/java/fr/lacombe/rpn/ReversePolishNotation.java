package fr.lacombe.rpn;

import java.util.Stack;

public class ReversePolishNotation {

    private static final String SEPARATOR = " ";

    public String compute(String input) {

        if (!isValid(input)) {
            return "0";
        }

        Stack<Integer> number = new Stack<>();
        for (String str : input.split(SEPARATOR)) {
            if (isNumeric(str)) {
                number.push(Integer.parseInt(str));
            } else {
                number.push(Operator.of(str).compute(number.pop(), number.pop()));
            }
        }

        return result(number);
    }

    private String result(Stack<Integer> number) {
        String str = "";
        for(Integer num: number)
        {
            str += num + " ";
        }
        return str.trim();
    }

    private boolean isValid(String input) {
        return !(input.equals("") || input.equals(" "));
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
