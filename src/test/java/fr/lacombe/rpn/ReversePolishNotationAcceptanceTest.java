package fr.lacombe.rpn;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ReversePolishNotationAcceptanceTest {

    @Test
    public void reverse_polish_notation_calculation() {
        String input = "15 7 1 1 + - ÷ 3 × 2 1 1 + + -";
        ReversePolishNotation reversePolishNotation = new ReversePolishNotation();

        String resultRPN = reversePolishNotation.compute(input);

        assertThat(resultRPN).isEqualTo("5");
    }
}
