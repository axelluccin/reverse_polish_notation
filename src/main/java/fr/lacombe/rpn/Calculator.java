package fr.lacombe.rpn;

public class Calculator {
    private final String operator;

    public Calculator(String operator) {
        this.operator = operator;
    }

    public int calculate(Integer first, Integer second) {
        if(operator.equals("+")) {
            return first + second;
        }
        else
            return first - second;
    }
}
