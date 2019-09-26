package fr.lacombe.rpn;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class InputVerificationTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void when_input_contain_a_empty_string_then_throw_an_exception() {
        String input = "";
        InputVerification verification = new InputVerification();
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Input should not be empty");

        verification.verify(input);
    }

    @Test
    public void when_input_contain_a_space_then_throw_an_exception() {
        String input = " ";
        InputVerification verification = new InputVerification();
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Input should not contain just a space");

        verification.verify(input);
    }
}
