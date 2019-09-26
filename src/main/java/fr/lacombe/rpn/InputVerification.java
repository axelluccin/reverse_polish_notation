package fr.lacombe.rpn;

public class InputVerification {
    public boolean verify(String input) {
        emptyString(input);
        if (input.equals(" "))
            throw new IllegalArgumentException("Input should not contain just a space");
        throw new IllegalArgumentException("Input should not contain just one operator");
    }

    private void emptyString(String input) {
        if (input.equals(""))
            throw new IllegalArgumentException("Input should not be empty");
    }
}
