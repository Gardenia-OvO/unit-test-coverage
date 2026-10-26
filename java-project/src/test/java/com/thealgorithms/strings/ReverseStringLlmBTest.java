package com.thealgorithms.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ReverseStringLlmBTest {

    @ParameterizedTest
    @CsvSource({
        "abc, cba",
        "hello, olleh",
        "a, a",
        "ab, ba",
        "12345, 54321"
    })
    void should_returnReversedString_when_reverseIsCalledWithNonEmptyString(String input, String expected) {
        assertEquals(expected, ReverseString.reverse(input));
    }

    @Test
    void should_returnEmptyString_when_reverseIsCalledWithEmptyString() {
        assertEquals("", ReverseString.reverse(""));
    }

    @Test
    void should_throwNullPointerException_when_reverseIsCalledWithNull() {
        assertThrows(NullPointerException.class, () -> ReverseString.reverse(null));
    }

    @ParameterizedTest
    @CsvSource({
        "abc, cba",
        "hello, olleh",
        "a, a",
        "ab, ba",
        "12345, 54321"
    })
    void should_returnReversedString_when_reverse2IsCalledWithNonEmptyString(String input, String expected) {
        assertEquals(expected, ReverseString.reverse2(input));
    }

    @Test
    void should_returnNull_when_reverse2IsCalledWithNull() {
        assertNull(ReverseString.reverse2(null));
    }

    @Test
    void should_returnEmptyString_when_reverse2IsCalledWithEmptyString() {
        assertEquals("", ReverseString.reverse2(""));
    }

    @ParameterizedTest
    @CsvSource({
        "abc, cba",
        "hello, olleh",
        "a, a",
        "ab, ba",
        "12345, 54321"
    })
    void should_returnReversedString_when_reverse3IsCalledWithNonEmptyString(String input, String expected) {
        assertEquals(expected, ReverseString.reverse3(input));
    }

    @Test
    void should_returnEmptyString_when_reverse3IsCalledWithEmptyString() {
        assertEquals("", ReverseString.reverse3(""));
    }

    @Test
    void should_throwNullPointerException_when_reverse3IsCalledWithNull() {
        assertThrows(NullPointerException.class, () -> ReverseString.reverse3(null));
    }

    @ParameterizedTest
    @CsvSource({
        "abc, cba",
        "hello, olleh",
        "a, a",
        "ab, ba",
        "12345, 54321"
    })
    void should_returnReversedString_when_reverseStringUsingStackIsCalledWithNonEmptyString(String input, String expected) {
        assertEquals(expected, ReverseString.reverseStringUsingStack(input));
    }

    @Test
    void should_returnEmptyString_when_reverseStringUsingStackIsCalledWithEmptyString() {
        assertEquals("", ReverseString.reverseStringUsingStack(""));
    }

    @Test
    void should_throwIllegalArgumentException_when_reverseStringUsingStackIsCalledWithNull() {
        assertThrows(IllegalArgumentException.class, () -> ReverseString.reverseStringUsingStack(null));
    }

    @ParameterizedTest
    @CsvSource({
        "abc, cba",
        "hello, olleh",
        "a, a",
        "ab, ba",
        "12345, 54321"
    })
    void should_returnReversedString_when_reverseStringUsingRecursionIsCalledWithNonEmptyString(String input, String expected) {
        assertEquals(expected, ReverseString.reverseStringUsingRecursion(input));
    }

    @Test
    void should_returnEmptyString_when_reverseStringUsingRecursionIsCalledWithEmptyString() {
        assertEquals("", ReverseString.reverseStringUsingRecursion(""));
    }

    @Test
    void should_throwNullPointerException_when_reverseStringUsingRecursionIsCalledWithNull() {
        assertThrows(NullPointerException.class, () -> ReverseString.reverseStringUsingRecursion(null));
    }
}
