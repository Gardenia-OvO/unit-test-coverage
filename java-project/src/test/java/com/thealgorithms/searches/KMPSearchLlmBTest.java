package com.thealgorithms.searches;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class KMPSearchLlmBTest {

    @Test
    void should_returnIndexOfFirstOccurrence_when_patternFound() {
        KMPSearch searcher = new KMPSearch();

        assertEquals(2, searcher.kmpSearch("abc", "xxabcx"));
    }

    @Test
    void should_returnMinusOne_when_patternNotFound() {
        KMPSearch searcher = new KMPSearch();

        assertEquals(-1, searcher.kmpSearch("abc", "xxabx"));
    }

    @Test
    void should_returnZero_when_patternStartsAtBeginning() {
        KMPSearch searcher = new KMPSearch();

        assertEquals(0, searcher.kmpSearch("abc", "abcabc"));
    }

    @Test
    void should_returnExpectedIndex_when_patternAtEnd() {
        KMPSearch searcher = new KMPSearch();

        assertEquals(2, searcher.kmpSearch("abc", "xxabc"));
    }

    @Test
    void should_returnMinusOne_when_patternLongerThanText() {
        KMPSearch searcher = new KMPSearch();

        assertEquals(-1, searcher.kmpSearch("abcdef", "abc"));
    }

    @Test
    void should_returnFirstOverlappingIndex_when_patternRepeats() {
        KMPSearch searcher = new KMPSearch();

        assertEquals(0, searcher.kmpSearch("aa", "aaa"));
    }

    @Test
    void should_returnFallbackMatchIndex_when_partialMatchOccurs() {
        KMPSearch searcher = new KMPSearch();

        assertEquals(1, searcher.kmpSearch("aab", "aaab"));
    }

    @Test
    void should_throwArrayIndexOutOfBoundsException_when_patternIsEmpty() {
        KMPSearch searcher = new KMPSearch();

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> searcher.kmpSearch("", "abc"));
    }

    @Test
    void should_computeExpectedLps_when_patternIsAbabac() {
        KMPSearch searcher = new KMPSearch();
        int[] lps = new int[6];

        searcher.computeLPSArray("ABABAC", 6, lps);

        assertArrayEquals(new int[] {0, 0, 1, 2, 3, 0}, lps);
    }

    @Test
    void should_computeExpectedLps_when_patternIsAaacaaaa() {
        KMPSearch searcher = new KMPSearch();
        int[] lps = new int[8];

        searcher.computeLPSArray("AAACAAAA", 8, lps);

        assertArrayEquals(new int[] {0, 1, 2, 0, 1, 2, 3, 3}, lps);
    }

    @Test
    void should_computeSingleElementLps_when_patternHasOneCharacter() {
        KMPSearch searcher = new KMPSearch();
        int[] lps = new int[1];

        searcher.computeLPSArray("A", 1, lps);

        assertArrayEquals(new int[] {0}, lps);
    }
}
