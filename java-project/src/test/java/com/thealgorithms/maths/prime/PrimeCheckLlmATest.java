package com.thealgorithms.maths.prime;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.thealgorithms.maths.Prime.PrimeCheck;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PrimeCheckLlmATest {

    @Test
    void should_returnTrue_when_numberIsTwo() {
        assertTrue(PrimeCheck.isPrime(2));
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 5, 7, 11, 13, 17, 19, 97})
    void should_returnTrue_when_numberIsOddPrime(int number) {
        assertTrue(PrimeCheck.isPrime(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {-9, -1, 0, 1})
    void should_returnFalse_when_numberIsLessThanTwo(int number) {
        assertFalse(PrimeCheck.isPrime(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 6, 8, 100})
    void should_returnFalse_when_numberIsEvenAndGreaterThanTwo(int number) {
        assertFalse(PrimeCheck.isPrime(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {9, 15, 21, 25, 49, 91})
    void should_returnFalse_when_numberIsOddComposite(int number) {
        assertFalse(PrimeCheck.isPrime(number));
    }

    @Test
    void should_returnTrue_when_fermatCheckReceivesPrimeNumber() {
        assertTrue(PrimeCheck.fermatPrimeChecking(5, 20));
    }

    @Test
    void should_returnFalse_when_fermatCheckReceivesCompositeNumber() {
        assertFalse(PrimeCheck.fermatPrimeChecking(4, 20));
    }
}
