package fr.lacombe.rpn;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ReversePolishNotationTest {
    @Test
    public void when_input_is_empty_then_compute_rpn_calculator_equals_0() {
        String input = "";
        ReversePolishNotation reversePolishNotation = new ReversePolishNotation();
        int resultRpn = reversePolishNotation.compute(input);
        assertThat(resultRpn).isEqualTo(0);
    }
}
