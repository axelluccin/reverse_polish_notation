package fr.lacombe.rpn;

public class InputVerification {
    public boolean verify(String input) {
        emptyString(input);
        justASpace(input);
        onlyOperator(input);
        throw new IllegalArgumentException("Operator should not be at this place");
    }

    private void onlyOperator(String input) {
        if (!Numeric.isNumeric(input.split(" ")[0])) {
            throw new IllegalArgumentException("Input should not contain just one operator");
        }
    }

    private void justASpace(String input) {
        if (input.equals(" "))
            throw new IllegalArgumentException("Input should not contain just a space");
    }

    private void emptyString(String input) {
        if (input.equals(""))
            throw new IllegalArgumentException("Input should not be empty");
    }
}