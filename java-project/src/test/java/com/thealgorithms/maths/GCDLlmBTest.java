package com.thealgorithms.maths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GCDLlmBTest {

    @ParameterizedTest
    @CsvSource({"48,18,6", "18,48,6", "1071,462,21", "17,13,1", "100,10,10"})
    void should_returnGcd_when_bothNumbersArePositive(int num1, int num2, int expected) {
        assertEquals(expected, GCD.gcd(num1, num2));
    }

    @ParameterizedTest
    @CsvSource({"0,5,5", "5,0,5"})
    void should_returnAbsoluteDifference_when_exactlyOneNumberIsZero(int num1, int num2, int expected) {
        assertEquals(expected, GCD.gcd(num1, num2));
    }

    @Test
    void should_returnZero_when_bothNumbersAreZero() {
        assertEquals(0, GCD.gcd(0, 0));
    }

    @ParameterizedTest
    @CsvSource({"-1,5", "5,-1", "-1,-5", "-1,0", "0,-1"})
    void should_throwArithmeticException_when_anyNumberIsNegative(int num1, int num2) {
        assertThrows(ArithmeticException.class, () -> GCD.gcd(num1, num2));
    }

    @Test
    void should_returnGcdOfAllNumbers_when_multiplePositiveNumbersAreGiven() {
        assertEquals(6, GCD.gcd(48, 18, 30));
    }

    @Test
    void should_returnGivenNumber_when_singlePositiveNumberIsGiven() {
        assertEquals(7, GCD.gcd(7));
    }

    @Test
    void should_returnZero_when_noNumbersAreGiven() {
        assertEquals(0, GCD.gcd());
    }

    @Test
    void should_returnZero_when_allNumbersAreZero() {
        assertEquals(0, GCD.gcd(0, 0, 0));
    }

    @Test
    void should_returnGcd_when_arrayContainsZeroAndPositiveNumbers() {
        assertEquals(4, GCD.gcd(0, 8, 12));
    }

    @Test
    void should_throwArithmeticException_when_arrayContainsNegativeNumber() {
        assertThrows(ArithmeticException.class, () -> GCD.gcd(12, -8, 4));
    }

    @Test
    void should_returnGcd_when_arrayIsPassedAsVarargsArray() {
        assertEquals(6, GCD.gcd(new int[] {48, 18, 30}));
    }
}
