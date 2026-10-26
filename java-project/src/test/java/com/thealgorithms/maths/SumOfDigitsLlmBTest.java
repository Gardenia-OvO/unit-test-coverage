package com.thealgorithms.maths;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class SumOfDigitsLlmBTest {

    @ParameterizedTest
    @CsvSource({
        "0,0",
        "7,7",
        "123,6",
        "-123,6",
        "1001,2",
        "2147483647,46"
    })
    void should_returnDigitSum_when_callingSumOfDigits(int number, int expected) {
        assertEquals(expected, SumOfDigits.sumOfDigits(number));
    }

    @ParameterizedTest
    @CsvSource({
        "0,0",
        "7,7",
        "123,6",
        "-123,6",
        "1001,2",
        "2147483647,46"
    })
    void should_returnDigitSum_when_callingSumOfDigitsRecursion(int number, int expected) {
        assertEquals(expected, SumOfDigits.sumOfDigitsRecursion(number));
    }

    @ParameterizedTest
    @CsvSource({
        "0,0",
        "7,7",
        "123,6",
        "-123,6",
        "1001,2",
        "2147483647,46"
    })
    void should_returnDigitSum_when_callingSumOfDigitsFast(int number, int expected) {
        assertEquals(expected, SumOfDigits.sumOfDigitsFast(number));
    }
}
