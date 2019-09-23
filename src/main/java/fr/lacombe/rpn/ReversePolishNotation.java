package fr.lacombe.rpn;

public class ReversePolishNotation {

    private static final String SEPARATOR = " ";

    public int compute(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        String[] str = input.split(SEPARATOR);

        if(str.length > 1) {
            return Integer.parseInt(str[0]) + Integer.parseInt(str[1]);
        }

        return Integer.parseInt(input);
    }
}
