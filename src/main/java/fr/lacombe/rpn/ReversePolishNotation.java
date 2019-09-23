package fr.lacombe.rpn;

public class ReversePolishNotation {

    private static final String SEPARATOR = " ";

    public int compute(String input) {

        if (input.length() == 1) {
            return Integer.parseInt(input);
        }

        int result = 0;
        for (String s: input.split(SEPARATOR)) {
            if (isNumericException(s)) {
                result += Integer.parseInt(s);
            }
        }

        return result;
    }

    private static boolean isNumericException(String str) {
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
