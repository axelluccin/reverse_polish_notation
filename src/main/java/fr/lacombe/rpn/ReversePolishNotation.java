package fr.lacombe.rpn;

public class ReversePolishNotation {
    public int compute(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(input);
    }
}
