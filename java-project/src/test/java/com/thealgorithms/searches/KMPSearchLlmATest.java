package com.thealgorithms.searches;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class KMPSearchLlmATest {

    private final KMPSearch searcher = new KMPSearch();

    @Test
    void should_returnZero_whenPatternEqualsText() {
        Assertions.assertEquals(0, searcher.kmpSearch("ABC", "ABC"));
    }

    @Test
    void should_returnStartIndex_whenPatternOccursWithinText() {
        Assertions.assertEquals(6, searcher.kmpSearch("WORLD", "HELLO WORLD"));
    }

    @Test
    void should_returnFirstMatchIndex_whenPatternOccursMultipleTimes() {
        Assertions.assertEquals(0, searcher.kmpSearch("ABA", "ABABA"));
    }

    @Test
    void should_returnMatchIndex_whenFallbackIsNeededAfterPartialMatch() {
        Assertions.assertEquals(2, searcher.kmpSearch("AAAB", "AAAAAB"));
    }

    @Test
    void should_returnMinusOne_whenPatternDoesNotOccurInText() {
        Assertions.assertEquals(-1, searcher.kmpSearch("XYZ", "ABCABC"));
    }

    @Test
    void should_returnMinusOne_whenPatternIsLongerThanText() {
        Assertions.assertEquals(-1, searcher.kmpSearch("ABCDEF", "ABC"));
    }

    @Test
    void should_returnMinusOne_whenTextIsEmpty() {
        Assertions.assertEquals(-1, searcher.kmpSearch("A", ""));
    }

    @Test
    void should_throwArrayIndexOutOfBoundsException_whenPatternIsEmpty() {
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class,
            () -> searcher.kmpSearch("", "ABC"));
    }

    @Test
    void should_computeLongestPrefixSuffixLengths_whenPatternHasPrefixSuffixOverlaps() {
        String pattern = "AAACAAAA";
        int[] lps = new int[pattern.length()];

        searcher.computeLPSArray(pattern, pattern.length(), lps);

        Assertions.assertArrayEquals(new int[] {0, 1, 2, 0, 1, 2, 3, 3}, lps);
    }

    @Test
    void should_computeZeroLengths_whenPatternHasNoPrefixSuffixOverlap() {
        String pattern = "ABCDEF";
        int[] lps = new int[pattern.length()];

        searcher.computeLPSArray(pattern, pattern.length(), lps);

        Assertions.assertArrayEquals(new int[] {0, 0, 0, 0, 0, 0}, lps);
    }

    @Test
    void should_computeIncreasingLengths_whenPatternContainsOneRepeatedCharacter() {
        String pattern = "AAAA";
        int[] lps = new int[pattern.length()];

        searcher.computeLPSArray(pattern, pattern.length(), lps);

        Assertions.assertArrayEquals(new int[] {0, 1, 2, 3}, lps);
    }
}
