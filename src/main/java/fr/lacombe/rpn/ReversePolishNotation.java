package fr.lacombe.rpn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReversePolishNotation {

    private static final String SEPARATOR = " ";

    public int compute(String input) {

        if (input.equals("")) {
            return 0;
        }
        if (input.length() == 1) {
            return Integer.parseInt(input);
        }

        List<Integer> numbers = getNumbers(input);
        List<String> operators = getOperators(input);
        int result = numbers.get(0);
        numbers.remove(0);
        for (Integer number : numbers) {
            if (operators.get(0).equals("+")) {
                result += number;
            } else if (operators.get(0).equals("-")) {
                result -= number;
            }
        }

        return result;
    }

    private List<String> getOperators(String input) {
        List<String> operators = new ArrayList<>();
        for (String s : input.split(SEPARATOR)) {
            if (!isNumeric(s)) {
                operators.add(s);
            }
        }
        Collections.reverse(operators);
        return operators;
    }

    private List<Integer> getNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (String s : input.split(SEPARATOR)) {
            if (isNumeric(s)) {
                numbers.add(Integer.parseInt(s));
            }
        }
        return numbers;
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
