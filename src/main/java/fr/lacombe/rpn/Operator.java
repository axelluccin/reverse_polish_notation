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
    };

    private String operator;

    Operator(String operator) {
        this.operator = operator;
    }

    public static Operator of(String operator) {
        if(operator.compareTo(ADDITION.operator) == 0) {
            return ADDITION;
        }

        return SUBTRACTION;
    }

    abstract int compute(int firstValue, int secondValue);
}
