package fr.lacombe.rpn;

public class InputVerification {
    public void verify(String input) {
        emptyString(input);
        justASpace(input);
        onlyOperator(input);
        operatorPosition(input);
        moreOperatorsThanNumber(input);
        throw new IllegalArgumentException("There is a character unrecognized");
    }

    private void moreOperatorsThanNumber(String input) {
        int numbers = 0;
        int operator = 0;

        for (String stringTemp : input.split(" ")) {
            if (Numeric.isNumeric(stringTemp)) {
                numbers++;
            }
            else {
                operator++;
            }
        }

        if (operator > numbers) {
            throw new IllegalArgumentException("there is more operators than numbers");
        }
    }

    private void operatorPosition(String input) {
        if (input.length() > 3 && !Numeric.isNumeric(input.split(" ")[1])) {
            throw new IllegalArgumentException("Operator should not be at this place");
        }
    }

    private void onlyOperator(String input) {
        if (input.length() == 1 && !Numeric.isNumeric(input.split(" ")[0])) {
            throw new IllegalArgumentException("Input should not contain just one operator");
        }
    }

    private void justASpace(String input) {
        if (input.equals(" ")) {
            throw new IllegalArgumentException("Input should not contain just a space");
        }
    }

    private void emptyString(String input) {
        if (input.equals("")) {
            throw new IllegalArgumentException("Input should not be empty");
        }
    }
}
