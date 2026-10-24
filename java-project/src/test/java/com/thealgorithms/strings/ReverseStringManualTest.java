package com.thealgorithms.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class ReverseStringManualTest {

    @Test
    void should_reverse_using_string_builder() {
        assertEquals("cba", ReverseString.reverse("abc"));
        assertEquals("", ReverseString.reverse(""));
    }

    @Test
    void should_reverse_with_in_place_swap_and_keep_null() {
        assertEquals("cba", ReverseString.reverse2("abc"));
        assertEquals("", ReverseString.reverse2(""));
        assertNull(ReverseString.reverse2(null));
    }

    @Test
    void should_reverse_with_manual_string_builder() {
        assertEquals("cba", ReverseString.reverse3("abc"));
        assertEquals("", ReverseString.reverse3(""));
    }

    @Test
    void should_reverse_with_stack_and_reject_null() {
        assertEquals("cba", ReverseString.reverseStringUsingStack("abc"));
        assertEquals("", ReverseString.reverseStringUsingStack(""));
        assertThrows(IllegalArgumentException.class, () -> ReverseString.reverseStringUsingStack(null));
    }

    @Test
    void should_reverse_with_recursion() {
        assertEquals("cba", ReverseString.reverseStringUsingRecursion("abc"));
        assertEquals("", ReverseString.reverseStringUsingRecursion(""));
    }

    @Test
    void should_give_same_result_from_all_five_versions() {
        String input = "abcdef";
        assertEquals("fedcba", ReverseString.reverse(input));
        assertEquals("fedcba", ReverseString.reverse2(input));
        assertEquals("fedcba", ReverseString.reverse3(input));
        assertEquals("fedcba", ReverseString.reverseStringUsingStack(input));
        assertEquals("fedcba", ReverseString.reverseStringUsingRecursion(input));
    }
}
