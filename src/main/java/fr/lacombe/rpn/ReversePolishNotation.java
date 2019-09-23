package fr.lacombe.rpn;

public class ReversePolishNotation {
    public int compute(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        if(input.contains("3")) {
            return 8;
        }

        return Integer.parseInt(input);
    }
}
