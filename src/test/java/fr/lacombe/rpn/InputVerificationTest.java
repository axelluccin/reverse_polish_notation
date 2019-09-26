package fr.lacombe.rpn;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class InputVerificationTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    private InputVerification verification = new InputVerification();

    @Test
    public void when_input_contain_a_empty_string_then_throw_an_exception() {
        String input = "";
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Input should not be empty");

        verification.verify(input);
    }

    @Test
    public void when_input_contain_a_space_then_throw_an_exception() {
        String input = " ";
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Input should not contain just a space");

        verification.verify(input);
    }

    @Test
    public void when_input_contain_just_one_operator_then_throw_an_exception() {
        String input = "+";
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Input should not contain just one operator");

        verification.verify(input);
    }


    @Test
    public void when_input_contain_one_operator_at_the_second_place_then_throw_an_exception() {
        String input = "2 + 4";
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Operator should not be at this place");

        verification.verify(input);
    }

    @Test
    public void when_input_contain_more_operators_than_number_should_throw_an_exception() {
        String input = "3 4 + + ×";
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("there is more operators than numbers");

        verification.verify(input);
    }

    @Test
    public void when_input_contain_a_character_unrecognized_then_throw_an_exception() {
        String input = "2 7 + g";
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("There is a character unrecognized");

        verification.verify(input);
    }
}
