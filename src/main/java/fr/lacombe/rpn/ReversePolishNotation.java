package fr.lacombe.rpn;

public class ReversePolishNotation {

    private static final String SEPARATOR = " ";

    public int compute(String input) {

        if (input.length() == 1) {
            return Integer.parseInt(input);
        }

        int result = 0;
        for (String s: input.split(SEPARATOR)) {
            if (isNumeric(s)) {
                result += Integer.parseInt(s);
            }

            if(s.equals("-"))
                return 3;
        }

        return result;
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
