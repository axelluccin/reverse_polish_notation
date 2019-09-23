package fr.lacombe.rpn;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ReversePolishNotationTest {
    @Test
    public void when_input_is_empty_then_compute_rpn_calculator_equals_0() {
        String input = "";
        ReversePolishNotation reversePolishNotation = new ReversePolishNotation();

        int resultRPN = reversePolishNotation.compute(input);

        assertThat(resultRPN).isEqualTo(0);
    }

    @Test
    public void when_input_contains_only_one_number_then_compute_rpn_calculator_equals_the_number() {
        String input = "6";
        ReversePolishNotation reversePolishNotation = new ReversePolishNotation();

        int resultRPN = reversePolishNotation.compute(input);

        assertThat(resultRPN).isEqualTo(6);
    }

    @Test
    public void when_input_contain_a_addition_then_compute_rpn_calculator_equals_the_sum() {
        String input = "5 3 +";
        ReversePolishNotation reversePolishNotation = new ReversePolishNotation();

        int resultRPN = reversePolishNotation.compute(input);

        assertThat(resultRPN).isEqualTo(8);
    }

    @Test
    public void name() {
    }
}
