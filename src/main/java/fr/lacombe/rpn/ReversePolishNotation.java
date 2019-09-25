package fr.lacombe.rpn;

import java.util.Stack;

public class ReversePolishNotation {

    private static final String SEPARATOR = " ";

    public String compute(String input) {

        if (isNotValid(input)) {
            return "0";
        }

        Stack<Integer> numbers = new Stack<>();
        for (String str : input.split(SEPARATOR)) {
            if (isNumeric(str)) {
                numbers.push(Integer.parseInt(str));
            } else {
                numbers.push(Operator.of(str).compute(numbers.pop(), numbers.pop()));
            }
        }

        return result(numbers);
    }

    private String result(Stack<Integer> number) {
        String stringResult = "";
        for (Integer num : number) {
            stringResult += num + SEPARATOR;
        }
        return stringResult.trim();
    }

    private boolean isNotValid(String input) {
        if (input.isEmpty() || input.equals(SEPARATOR)) {
            return true;
        }

        if (input.length() == 3) {
            throw new IllegalArgumentException("Pas le bon nombre d'argument");
        }
        return false;
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
