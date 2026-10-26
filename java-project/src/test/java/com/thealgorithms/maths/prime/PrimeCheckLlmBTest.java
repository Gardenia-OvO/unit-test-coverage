package com.thealgorithms.maths.prime;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.thealgorithms.maths.Prime.PrimeCheck;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PrimeCheckLlmBTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 97})
    void should_returnTrue_when_nIsPrime(int n) {
        assertTrue(PrimeCheck.isPrime(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {-10, -1, 0, 1})
    void should_returnFalse_when_nIsLessThanTwo(int n) {
        assertFalse(PrimeCheck.isPrime(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 6, 8, 9, 10, 12, 14, 15, 21, 25, 49})
    void should_returnFalse_when_nIsComposite(int n) {
        assertFalse(PrimeCheck.isPrime(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 97})
    void should_returnTrue_when_nIsPrimeForFermatPrimeChecking(int n) {
        assertTrue(PrimeCheck.fermatPrimeChecking(n, 5));
    }

    @Test
    void should_returnFalse_when_nIsCompositeForFermatPrimeChecking() {
        assertFalse(PrimeCheck.fermatPrimeChecking(4, 1));
    }

    @Test
    void should_returnTrue_when_iterationIsZeroForFermatPrimeChecking() {
        assertTrue(PrimeCheck.fermatPrimeChecking(15, 0));
    }
}
