package fr.lacombe.rpn;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ReversePolishNotationTest {
    @Test
    public void when_input_is_empty_then_compute_rpn_calculator_equals_0() {
        String input = "";
        ReversePolishNotation reversePolishNotation = new ReversePolishNotation();

        String resultRPN = reversePolishNotation.compute(input);

        assertThat(resultRPN).isEqualTo("0");
    }

    @Test
    public void when_input_contains_only_one_number_then_compute_rpn_calculator_equals_the_number() {
        String input = "6";
        ReversePolishNotation reversePolishNotation = new ReversePolishNotation();

        String resultRPN = reversePolishNotation.compute(input);

        assertThat(resultRPN).isEqualTo("6");
    }

    @Test
    public void when_input_contain_one_addition_then_compute_rpn_calculator_equals_the_sum_of_number() {
        String input = "5 3 +";
        ReversePolishNotation reversePolishNotation = new ReversePolishNotation();

        String resultRPN = reversePolishNotation.compute(input);

        assertThat(resultRPN).isEqualTo("8");
    }

    @Test
    public void when_input_contain_two_addition_then_compute_rpn_equals_the_sum_of_number() {
        String input = "5 4 3 + +";
        ReversePolishNotation reversePolishNotation = new ReversePolishNotation();

        String resultRPN = reversePolishNotation.compute(input);

        assertThat(resultRPN).isEqualTo("12");
    }

    @Test
    public void when_input_contain_one_subtraction_then_compute_rpn_calculator_equals_the_subtract_of_number() {
        String input = "7 4 -";
        ReversePolishNotation reversePolishNotation = new ReversePolishNotation();

        String resultRPN = reversePolishNotation.compute(input);

        assertThat(resultRPN).isEqualTo("3");
    }

    @Test
    public void when_input_contain_two_subtraction_then_compute_rpn_calculator_equals_the_subtract_of_number() {
        String input = "7 4 2 - -";
        ReversePolishNotation reversePolishNotation = new ReversePolishNotation();

        String resultRPN = reversePolishNotation.compute(input);

        assertThat(resultRPN).isEqualTo("5");
    }

    @Test
    public void when_input_contain_one_subtraction_and_one_addition_then_compute_rpn_calculator_equal_the_compute() {
        String input = "20 17 - 2 +";
        ReversePolishNotation reversePolishNotation = new ReversePolishNotation();

        String resultRPN = reversePolishNotation.compute(input);

        assertThat(resultRPN).isEqualTo("5");
    }

    @Test
    public void when_input_contain_one_subtraction_and_two_addition_then_compute_rpn_calculator_equal_the_compute() {
        String input = "20 17 2 - 4 + +";

        ReversePolishNotation reversePolishNotation = new ReversePolishNotation();

        String resultRPN = reversePolishNotation.compute(input);

        assertThat(resultRPN).isEqualTo("39");
    }

    @Test
    public void when_input_contain_one_division_then_compute_rpn_calculator_equal_the_division_of_2_number() {
        String input = "25 5 ÷";
        ReversePolishNotation reversePolishNotation = new ReversePolishNotation();

        String resultRPN = reversePolishNotation.compute(input);

        assertThat(resultRPN).isEqualTo("5");
    }

    @Test
    public void when_input_contain_one_multiplication_then_compute_rpn_equal_the_multiplication_of_2_number() {
        String input = "2 3 ×";
        ReversePolishNotation reversePolishNotation = new ReversePolishNotation();

        String resultRPN = reversePolishNotation.compute(input);

        assertThat(resultRPN).isEqualTo("6");
    }

    @Test
    public void when_input_is_a_space_then_compute_rpn_calculator_equal_0() {
        String input = " ";
        ReversePolishNotation reversePolishNotation = new ReversePolishNotation();

        String resultTPN = reversePolishNotation.compute(input);

        assertThat(resultTPN).isEqualTo("0");
    }

    @Test
    public void when_input_contain_one_operator_and_4_number_then_compute_rpn_equal_the_compute_of_two_number_and_two_number() {
        String input = "7 2 - 3 4";
        ReversePolishNotation reversePolishNotation = new ReversePolishNotation();

        String resultRPN = reversePolishNotation.compute(input);

        assertThat(resultRPN).isEqualTo("5 3 4");
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_input_contain_1_operator_and_1_number_then_compute_rpn_throw_illegalArgumentException() {
        String input = "- 4";
        new ReversePolishNotation().compute(input);
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_input_contain_a_foreign_string_then_compute_rpn_throw_illegalArgumentException() {
        String input = "5 6 Y";
        new ReversePolishNotation().compute(input);
    }
}
