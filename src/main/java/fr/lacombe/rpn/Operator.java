package fr.lacombe.rpn;

public enum Operator {
    ADDITION("+") {
        @Override
        int compute(int firstValue, int secondValue) {
            return firstValue + secondValue;
        }
    },
    SUBTRACTION("-") {
        @Override
        int compute(int firstValue, int secondValue) {
            return secondValue - firstValue;
        }
    },
    DIVISION("÷") {
        @Override
        int compute(int firstValue, int secondValue) {
            return secondValue / firstValue;
        }
    },
    MULTIPLICATION("×") {
        @Override
        int compute(int firstValue, int secondValue) {
            return firstValue * secondValue;
        }
    };

    private String operator;

    Operator(String operator) {
        this.operator = operator;
    }

    public static Operator of(String operator) {

        if (operator.equals(ADDITION.operator)) {
            return ADDITION;
        }
        if (operator.equals(SUBTRACTION.operator)) {
            return SUBTRACTION;
        }
        if (operator.equals(DIVISION.operator)) {
            return DIVISION;
        }
        if (operator.equals(MULTIPLICATION.operator)) {
            return MULTIPLICATION;
        }
        return null;
    }

    public static boolean isOperator(String input) {
        return input.equals(ADDITION.operator)
                || input.equals(SUBTRACTION.operator)
                || input.equals(DIVISION.operator)
                || input.equals(MULTIPLICATION.operator);
    }

    abstract int compute(int firstValue, int secondValue);
}
