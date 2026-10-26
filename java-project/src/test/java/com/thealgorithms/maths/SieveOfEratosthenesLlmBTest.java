package com.thealgorithms.maths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

class SieveOfEratosthenesLlmBTest {

    @Test
    void should_returnEmptyList_when_nIsZero() {
        assertEquals(Collections.emptyList(), SieveOfEratosthenes.findPrimes(0));
    }

    @Test
    void should_returnEmptyList_when_nIsOne() {
        assertEquals(Collections.emptyList(), SieveOfEratosthenes.findPrimes(1));
    }

    @Test
    void should_returnListContainingTwo_when_nIsTwo() {
        List<Integer> expected = Arrays.asList(2);
        assertEquals(expected, SieveOfEratosthenes.findPrimes(2));
    }

    @Test
    void should_returnPrimesUpToTen_when_nIsTen() {
        List<Integer> expected = Arrays.asList(2, 3, 5, 7);
        assertEquals(expected, SieveOfEratosthenes.findPrimes(10));
    }

    @Test
    void should_returnPrimesUpToThirty_when_nIsThirty() {
        List<Integer> expected = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        assertEquals(expected, SieveOfEratosthenes.findPrimes(30));
    }

    @Test
    void should_throwIllegalArgumentException_when_findPrimesInputIsNegative() {
        assertThrows(IllegalArgumentException.class, () -> SieveOfEratosthenes.findPrimes(-1));
    }

    @Test
    void should_returnZeroPrimeCount_when_nIsZero() {
        assertEquals(0, SieveOfEratosthenes.countPrimes(0));
    }

    @Test
    void should_returnZeroPrimeCount_when_nIsOne() {
        assertEquals(0, SieveOfEratosthenes.countPrimes(1));
    }

    @Test
    void should_returnOnePrimeCount_when_nIsTwo() {
        assertEquals(1, SieveOfEratosthenes.countPrimes(2));
    }

    @Test
    void should_returnFourPrimeCount_when_nIsTen() {
        assertEquals(4, SieveOfEratosthenes.countPrimes(10));
    }

    @Test
    void should_throwIllegalArgumentException_when_countPrimesInputIsNegative() {
        assertThrows(IllegalArgumentException.class, () -> SieveOfEratosthenes.countPrimes(-1));
    }
}
