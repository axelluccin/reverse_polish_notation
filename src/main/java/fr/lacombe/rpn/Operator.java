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
            return firstValue - secondValue;
        }
    },
    DIVISION("÷") {
        @Override
        int compute(int firstValue, int secondValue) {
            return firstValue / secondValue;
        }
    };

    private String operator;

    Operator(String operator) {
        this.operator = operator;
    }

    public static Operator of(String operator) {
        if(operator.equals(ADDITION.operator)) {
            return ADDITION;
        }
        if (operator.equals(SUBTRACTION.operator)) {
            return SUBTRACTION;
        }
        return DIVISION;
    }

    abstract int compute(int firstValue, int secondValue);
}
