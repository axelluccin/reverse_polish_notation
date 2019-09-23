package fr.lacombe.rpn;

import org.junit.Test;

import java.util.Map;

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
    public void when_input_contain_one_addition_then_compute_rpn_calculator_equals_the_sum_of_number() {
        String input = "5 3 +";
        ReversePolishNotation reversePolishNotation = new ReversePolishNotation();

        int resultRPN = reversePolishNotation.compute(input);

        assertThat(resultRPN).isEqualTo(8);
    }

    @Test
    public void when_input_contain_two_addition_then_compute_rpn_equals_the_sum_of_number() {
        String input = "5 4 3 + +";
        ReversePolishNotation reversePolishNotation = new ReversePolishNotation();

        int resultRPN = reversePolishNotation.compute(input);

        assertThat(resultRPN).isEqualTo(12);
    }

    @Test
    public void when_input_contain_one_subtraction_then_compute_rpn_calculator_equals_the_subtract_of_number() {
        String input = "7 4 -";
        ReversePolishNotation reversePolishNotation = new ReversePolishNotation();

        int resultRPN = reversePolishNotation.compute(input);

        assertThat(resultRPN).isEqualTo(3);
    }

    @Test
    public void when_input_contain_two_subtraction_then_compute_rpn_calculator_equals_the_subtract_of_number() {
        String input = "7 4 2 - -";
        ReversePolishNotation reversePolishNotation = new ReversePolishNotation();

        int resultRPN = reversePolishNotation.compute(input);

        assertThat(resultRPN).isEqualTo(1);
    }

    @Test
    public void when_input_contain_one_subtraction_and_one_addition_then_compute_rpn_calculator_equal_the_compute() {
        String input = "20 17 2 - +";
        ReversePolishNotation reversePolishNotation = new ReversePolishNotation();

        int resultRPN = reversePolishNotation.compute(input);

        assertThat(resultRPN).isEqualTo(5);
    }
}
