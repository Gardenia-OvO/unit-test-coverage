package com.thealgorithms.maths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class SieveOfEratosthenesLlmATest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1})
    void should_returnEmptyList_when_limitIsZeroOrOne(int n) {
        assertTrue(SieveOfEratosthenes.findPrimes(n).isEmpty());
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -100})
    void should_throwIllegalArgumentException_when_findPrimesReceivesNegativeLimit(int n) {
        assertThrows(IllegalArgumentException.class, () -> SieveOfEratosthenes.findPrimes(n));
    }

    @Test
    void should_returnOnlyTwo_when_limitIsTwo() {
        assertEquals(Arrays.asList(2), SieveOfEratosthenes.findPrimes(2));
    }

    @Test
    void should_includeUpperLimit_when_upperLimitIsPrime() {
        assertEquals(Arrays.asList(2, 3, 5, 7), SieveOfEratosthenes.findPrimes(7));
    }

    @Test
    void should_returnAllPrimesInAscendingOrder_when_limitIsThirty() {
        assertEquals(
                Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29),
                SieveOfEratosthenes.findPrimes(30));
    }

    @ParameterizedTest
    @CsvSource({
        "0, 0",
        "1, 0",
        "2, 1",
        "10, 4",
        "30, 10",
        "100, 25"
    })
    void should_returnPrimeCount_when_limitIsNonNegative(int n, int expectedCount) {
        assertEquals(expectedCount, SieveOfEratosthenes.countPrimes(n));
    }

    @Test
    void should_throwIllegalArgumentException_when_countPrimesReceivesNegativeLimit() {
        assertThrows(IllegalArgumentException.class, () -> SieveOfEratosthenes.countPrimes(-1));
    }
}
