package com.thealgorithms.dynamicprogramming;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class DamerauLevenshteinDistanceLlmBTest {

    @Test
    void should_returnZero_when_stringsAreEqual() {
        assertEquals(0, DamerauLevenshteinDistance.distance("abcd", "abcd"));
    }

    @Test
    void should_returnFirstStringLength_when_secondStringIsEmpty() {
        assertEquals(4, DamerauLevenshteinDistance.distance("abcd", ""));
    }

    @Test
    void should_returnSecondStringLength_when_firstStringIsEmpty() {
        assertEquals(4, DamerauLevenshteinDistance.distance("", "abcd"));
    }

    @Test
    void should_returnOne_when_singleInsertionIsNeeded() {
        assertEquals(1, DamerauLevenshteinDistance.distance("abc", "abxc"));
    }

    @Test
    void should_returnOne_when_singleDeletionIsNeeded() {
        assertEquals(1, DamerauLevenshteinDistance.distance("abxc", "abc"));
    }

    @Test
    void should_returnOne_when_singleSubstitutionIsNeeded() {
        assertEquals(1, DamerauLevenshteinDistance.distance("abc", "axc"));
    }

    @Test
    void should_returnOne_when_adjacentCharactersAreTransposed() {
        assertEquals(1, DamerauLevenshteinDistance.distance("ab", "ba"));
    }

    @Test
    void should_returnTwo_when_multipleEditsAreNeededForFullDamerauLevenshtein() {
        assertEquals(2, DamerauLevenshteinDistance.distance("CA", "ABC"));
    }

    @Test
    void should_throwIllegalArgumentException_when_firstStringIsNull() {
        assertThrows(IllegalArgumentException.class, () -> DamerauLevenshteinDistance.distance(null, "abc"));
    }

    @Test
    void should_throwIllegalArgumentException_when_secondStringIsNull() {
        assertThrows(IllegalArgumentException.class, () -> DamerauLevenshteinDistance.distance("abc", null));
    }
}
