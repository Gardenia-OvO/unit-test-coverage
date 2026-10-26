package com.thealgorithms.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReverseStringLlmATest {

    @Test
    void should_return_reversed_text_when_reverse_receives_non_empty_text() {
        Assertions.assertEquals("dcba", ReverseString.reverse("abcd"));
    }

    @Test
    void should_return_empty_text_when_reverse_receives_empty_text() {
        Assertions.assertEquals("", ReverseString.reverse(""));
    }

    @Test
    void should_throw_null_pointer_exception_when_reverse_receives_null() {
        Assertions.assertThrows(NullPointerException.class, () -> ReverseString.reverse(null));
    }

    @Test
    void should_return_reversed_text_when_reverse2_receives_non_empty_text() {
        Assertions.assertEquals("dcba", ReverseString.reverse2("abcd"));
    }

    @Test
    void should_return_empty_text_when_reverse2_receives_empty_text() {
        Assertions.assertEquals("", ReverseString.reverse2(""));
    }

    @Test
    void should_return_null_when_reverse2_receives_null() {
        Assertions.assertNull(ReverseString.reverse2(null));
    }

    @Test
    void should_return_reversed_text_when_reverse3_receives_non_empty_text() {
        Assertions.assertEquals("dcba", ReverseString.reverse3("abcd"));
    }

    @Test
    void should_return_empty_text_when_reverse3_receives_empty_text() {
        Assertions.assertEquals("", ReverseString.reverse3(""));
    }

    @Test
    void should_throw_null_pointer_exception_when_reverse3_receives_null() {
        Assertions.assertThrows(NullPointerException.class, () -> ReverseString.reverse3(null));
    }

    @Test
    void should_return_reversed_text_when_stack_reversal_receives_non_empty_text() {
        Assertions.assertEquals("dcba", ReverseString.reverseStringUsingStack("abcd"));
    }

    @Test
    void should_return_empty_text_when_stack_reversal_receives_empty_text() {
        Assertions.assertEquals("", ReverseString.reverseStringUsingStack(""));
    }

    @Test
    void should_throw_illegal_argument_exception_when_stack_reversal_receives_null() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> ReverseString.reverseStringUsingStack(null));
    }

    @Test
    void should_return_reversed_text_when_recursive_reversal_receives_non_empty_text() {
        Assertions.assertEquals("dcba", ReverseString.reverseStringUsingRecursion("abcd"));
    }

    @Test
    void should_return_empty_text_when_recursive_reversal_receives_empty_text() {
        Assertions.assertEquals("", ReverseString.reverseStringUsingRecursion(""));
    }

    @Test
    void should_throw_null_pointer_exception_when_recursive_reversal_receives_null() {
        Assertions.assertThrows(NullPointerException.class, () -> ReverseString.reverseStringUsingRecursion(null));
    }
}
