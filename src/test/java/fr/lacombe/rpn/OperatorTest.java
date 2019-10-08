package fr.lacombe.rpn;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void when_input_contain_operator_plus_then_operator_should_be_addition() {
        String operator = "+";

        Operator resultOperator = Operator.of(operator);

        assertThat(resultOperator).isEqualTo(Operator.ADDITION);
    }

    @Test
    public void when_input_contain_operator_sub_then_operator_should_be_subtraction() {
        String operator = "-";

        Operator resultOperator = Operator.of(operator);

        assertThat(resultOperator).isEqualTo(Operator.SUBTRACTION);
    }
    @Test
    public void when_input_contain_operator_div_then_operator_should_be_division() {
        String operator = "÷";

        Operator resultOperator = Operator.of(operator);

        assertThat(resultOperator).isEqualTo(Operator.DIVISION);
    }

    @Test
    public void when_input_contain_operator_mul_then_operator_should_be_multiplication() {
        String operator = "×";

        Operator resultOperator = Operator.of(operator);

        assertThat(resultOperator).isEqualTo(Operator.MULTIPLICATION);
    }

    @Test
    public void when_operator_addition_compute_5_and_3_then_should_equal_to_8() {
        int resultRPN = Operator.ADDITION.compute(5, 3);

        assertThat(resultRPN).isEqualTo(8);
    }

    @Test
    public void when_operator_division_compute_25_and_5_then_should_equal_to_5() {
        int resultRPN = Operator.DIVISION.compute(5, 25);

        assertThat(resultRPN).isEqualTo(5);
    }
    @Test
    public void when_operator_subtraction_compute_5_and_3_then_should_equal_to_8() {
        int resultRPN = Operator.SUBTRACTION.compute(3, 5);

        assertThat(resultRPN).isEqualTo(2);
    }
    @Test
    public void when_operator_multiplication_compute_5_and_3_then_should_equal_to_8() {
        int resultRPN = Operator.MULTIPLICATION.compute(5, 3);

        assertThat(resultRPN).isEqualTo(15);
    }

    @Test
    public void when_input_contain_a_character_unrecognized_then_throw_an_exception() {
        String input = "g";
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Operator unrecognized");

        Operator.of(input);
    }
}
