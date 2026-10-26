package com.thealgorithms.maths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigInteger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class FibonacciLoopLlmBTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1})
    void should_return_input_value_when_n_is_zero_or_one(int n) {
        assertEquals(BigInteger.valueOf(n), FibonacciLoop.compute(n));
    }

    @ParameterizedTest
    @CsvSource({
        "2, 1",
        "3, 2",
        "4, 3",
        "5, 5",
        "6, 8",
        "10, 55",
        "15, 610"
    })
    void should_return_expected_fibonacci_number_when_n_is_positive(int n, String expected) {
        assertEquals(new BigInteger(expected), FibonacciLoop.compute(n));
    }

    @Test
    void should_return_large_fibonacci_number_when_n_is_100() {
        assertEquals(new BigInteger("354224848179261915075"), FibonacciLoop.compute(100));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -100})
    void should_throw_IllegalArgumentException_when_n_is_negative(int n) {
        assertThrows(IllegalArgumentException.class, () -> FibonacciLoop.compute(n));
    }
}
