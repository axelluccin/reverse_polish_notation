package fr.lacombe.rpn;

import static fr.lacombe.rpn.Operator.isOperator;

public class InputVerification {

    private static final String SPACE_SEPARATION = " ";

    public void verify(String input) {
        emptyString(input);
        isASpace(input);
        onlyOperator(input);
        badOperatorPosition(input);
        characterUnrecognized(input);
        moreOperatorsThanNumber(input);
    }

    private void characterUnrecognized(String input) {
        for (String strTemp : input.split(SPACE_SEPARATION)) {
            if (!Numeric.isNumeric(strTemp) && !isOperator(strTemp)) {
                throw new IllegalArgumentException("There is a character unrecognized");
            }
        }
    }

    private void moreOperatorsThanNumber(String input) {
        int numbers = 0;
        int operators = 0;

        for (String stringTemp : input.split(SPACE_SEPARATION)) {
            if (Numeric.isNumeric(stringTemp)) {
                numbers++;
            } else {
                operators++;
            }
        }

        if (operators > numbers) {
            throw new IllegalArgumentException("there is more operators than numbers");
        }
    }

    private void badOperatorPosition(String input) {
        if (operatorAtTheFirstPlace(input) || operatorAtTheSecondPlace(input)) {
            throw new IllegalArgumentException("Operator should not be at this place");
        }
    }

    private boolean operatorAtTheFirstPlace(String input) {
        return isOperator(input.split(SPACE_SEPARATION)[0]);
    }

    private boolean operatorAtTheSecondPlace(String input) {
        return input.length() > 3 && isOperator(input.split(SPACE_SEPARATION)[1]);
    }

    private void onlyOperator(String input) {
        if (input.length() == 1 && !Numeric.isNumeric(input.split(SPACE_SEPARATION)[0])) {
            throw new IllegalArgumentException("Input should not contain just one operator");
        }
    }

    private void isASpace(String input) {
        if (input.equals(SPACE_SEPARATION)) {
            throw new IllegalArgumentException("Input should not contain just a space");
        }
    }

    private void emptyString(String input) {
        if (input.equals("")) {
            throw new IllegalArgumentException("Input should not be empty");
        }
    }
}
