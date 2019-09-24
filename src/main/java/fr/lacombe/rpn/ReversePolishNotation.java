package fr.lacombe.rpn;

import java.util.ArrayList;
import java.util.List;

public class ReversePolishNotation {

    private static final String SEPARATOR = " ";

    public int compute(String input) {

        if (input.equals("")) {
            return 0;
        }

        List<Integer> number = new ArrayList<>();
        for (String str : input.split(SEPARATOR)) {
            if (isNumeric(str)) {
                number.add(Integer.parseInt(str));
            } else {
                int result = Operator.of(str).compute(number.get(number.size() - 2), number.get(number.size() - 1));
                number.remove(number.size() - 1);
                number.remove(number.size() - 1);
                number.add(result);
            }
        }

        return number.get(0);
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
