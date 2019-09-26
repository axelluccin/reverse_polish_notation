package fr.lacombe.rpn;

public class InputVerification {
    public boolean verify(String input) {
        emptyString(input);
        throw new IllegalArgumentException("Input should not contain just a space");
    }

    private void emptyString(String input) {
        if (input.equals(""))
            throw new IllegalArgumentException("Input should not be empty");
    }
}
