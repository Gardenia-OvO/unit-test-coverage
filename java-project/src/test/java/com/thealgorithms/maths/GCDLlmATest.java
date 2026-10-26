package com.thealgorithms.maths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class GCDLlmATest {

    @Test
    void should_returnGcd_when_bothNumbersArePositive() {
        assertEquals(6, GCD.gcd(48, 18));
    }

    @Test
    void should_returnGcd_when_numbersAreProvidedInReverseOrder() {
        assertEquals(6, GCD.gcd(18, 48));
    }

    @Test
    void should_returnOne_when_numbersAreCoprime() {
        assertEquals(1, GCD.gcd(17, 13));
    }

    @Test
    void should_returnSameNumber_when_bothNumbersAreEqual() {
        assertEquals(12, GCD.gcd(12, 12));
    }

    @Test
    void should_returnSecondNumber_when_firstNumberIsZero() {
        assertEquals(18, GCD.gcd(0, 18));
    }

    @Test
    void should_returnFirstNumber_when_secondNumberIsZero() {
        assertEquals(18, GCD.gcd(18, 0));
    }

    @Test
    void should_returnZero_when_bothNumbersAreZero() {
        assertEquals(0, GCD.gcd(0, 0));
    }

    @Test
    void should_throwArithmeticException_when_firstNumberIsNegative() {
        assertThrows(ArithmeticException.class, () -> GCD.gcd(-48, 18));
    }

    @Test
    void should_throwArithmeticException_when_secondNumberIsNegative() {
        assertThrows(ArithmeticException.class, () -> GCD.gcd(48, -18));
    }

    @Test
    void should_returnGcd_when_multipleNumbersAreProvided() {
        assertEquals(6, GCD.gcd(48, 18, 30));
    }

    @Test
    void should_returnGcd_when_varargsContainZeros() {
        assertEquals(6, GCD.gcd(new int[] {0, 48, 0, 18, 0}));
    }

    @Test
    void should_returnOnlyNumber_when_varargsContainSingleNumber() {
        assertEquals(42, GCD.gcd(42));
    }

    @Test
    void should_returnZero_when_varargsAreEmpty() {
        assertEquals(0, GCD.gcd());
    }

    @Test
    void should_throwArithmeticException_when_varargsContainNegativeNumber() {
        assertThrows(ArithmeticException.class, () -> GCD.gcd(new int[] {48, -18, 30}));
    }
}
