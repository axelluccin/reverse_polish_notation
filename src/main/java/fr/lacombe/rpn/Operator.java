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
        throw new IllegalArgumentException("Operator unrecognized");
    }

    public static boolean isOperator(String input) {
        return input.equals("+")
                || input.equals("-")
                || input.equals("÷")
                || input.equals("×");
    }

    abstract int compute(int firstValue, int secondValue);
}
