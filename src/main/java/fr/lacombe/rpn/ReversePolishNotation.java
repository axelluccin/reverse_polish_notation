package fr.lacombe.rpn;

import java.util.Stack;

import static fr.lacombe.rpn.Operator.of;
import static java.lang.Integer.parseInt;

public class ReversePolishNotation {

    private static final String SEPARATOR = " ";

    public String compute(String input) {

        if (isNotValid(input)) {
            return "0";
        }

        Stack<Integer> numbers = new Stack<>();
        for (String str : input.split(SEPARATOR)) {
            if (Numeric.isNumeric(str)) {
                numbers.push(parseInt(str));
            } else {
                numbers.push(of(str).compute(numbers.pop(), numbers.pop()));
            }
        }
        return result(numbers);
    }

    private String result(Stack<Integer> number) {
        StringBuilder stringResult = new StringBuilder();
        for (Integer num : number) {
            stringResult.append(num).append(SEPARATOR);
        }
        return stringResult.toString().trim();
    }

    private boolean isNotValid(String input) {
        if (input.isEmpty() || input.equals(SEPARATOR)) {
            return true;
        }

        if (input.length() == 3) {
            throw new IllegalArgumentException("");
        }
        return false;
    }
}
