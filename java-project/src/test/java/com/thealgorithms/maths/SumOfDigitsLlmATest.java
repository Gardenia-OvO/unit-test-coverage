package com.thealgorithms.maths;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SumOfDigitsLlmATest {

    @Test
    void should_returnZero_when_sumOfDigitsIsCalledWithZero() {
        assertEquals(0, SumOfDigits.sumOfDigits(0));
    }

    @Test
    void should_returnDigitSum_when_sumOfDigitsIsCalledWithPositiveNumber() {
        assertEquals(15, SumOfDigits.sumOfDigits(12345));
    }

    @Test
    void should_returnDigitSum_when_sumOfDigitsIsCalledWithNegativeNumber() {
        assertEquals(15, SumOfDigits.sumOfDigits(-12345));
    }

    @Test
    void should_returnDigitSum_when_sumOfDigitsIsCalledWithNumberContainingZeros() {
        assertEquals(6, SumOfDigits.sumOfDigits(1002003));
    }

    @Test
    void should_returnZero_when_sumOfDigitsRecursionIsCalledWithZero() {
        assertEquals(0, SumOfDigits.sumOfDigitsRecursion(0));
    }

    @Test
    void should_returnDigitSum_when_sumOfDigitsRecursionIsCalledWithPositiveNumber() {
        assertEquals(15, SumOfDigits.sumOfDigitsRecursion(12345));
    }

    @Test
    void should_returnDigitSum_when_sumOfDigitsRecursionIsCalledWithNegativeNumber() {
        assertEquals(15, SumOfDigits.sumOfDigitsRecursion(-12345));
    }

    @Test
    void should_returnDigitSum_when_sumOfDigitsRecursionIsCalledWithNumberContainingZeros() {
        assertEquals(6, SumOfDigits.sumOfDigitsRecursion(1002003));
    }

    @Test
    void should_returnZero_when_sumOfDigitsFastIsCalledWithZero() {
        assertEquals(0, SumOfDigits.sumOfDigitsFast(0));
    }

    @Test
    void should_returnDigitSum_when_sumOfDigitsFastIsCalledWithPositiveNumber() {
        assertEquals(15, SumOfDigits.sumOfDigitsFast(12345));
    }

    @Test
    void should_returnDigitSum_when_sumOfDigitsFastIsCalledWithNegativeNumber() {
        assertEquals(15, SumOfDigits.sumOfDigitsFast(-12345));
    }

    @Test
    void should_returnDigitSum_when_sumOfDigitsFastIsCalledWithNumberContainingZeros() {
        assertEquals(6, SumOfDigits.sumOfDigitsFast(1002003));
    }
}
