package com.thealgorithms.maths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigInteger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class FibonacciLoopLlmATest {

    @Test
    void should_return_zero_when_n_is_zero() {
        assertEquals(BigInteger.ZERO, FibonacciLoop.compute(0));
    }

    @Test
    void should_return_one_when_n_is_one() {
        assertEquals(BigInteger.ONE, FibonacciLoop.compute(1));
    }

    @ParameterizedTest
    @CsvSource({
        "2, 1",
        "3, 2",
        "4, 3",
        "5, 5",
        "6, 8",
        "7, 13",
        "8, 21",
        "9, 34",
        "10, 55",
        "20, 6765",
        "50, 12586269025"
    })
    void should_return_expected_fibonacci_number_when_n_is_greater_than_one(int n, long expected) {
        assertEquals(BigInteger.valueOf(expected), FibonacciLoop.compute(n));
    }

    @Test
    void should_return_correct_fibonacci_number_when_result_exceeds_long_range() {
        BigInteger expected = new BigInteger("354224848179261915075");

        assertEquals(expected, FibonacciLoop.compute(100));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -10, Integer.MIN_VALUE})
    void should_throw_illegal_argument_exception_when_n_is_negative(int n) {
        assertThrows(IllegalArgumentException.class, () -> FibonacciLoop.compute(n));
    }
}
