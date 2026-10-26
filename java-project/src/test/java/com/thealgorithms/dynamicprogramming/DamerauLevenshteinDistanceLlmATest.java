package com.thealgorithms.dynamicprogramming;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class DamerauLevenshteinDistanceLlmATest {

    @Test
    void should_returnZero_when_bothStringsAreEmpty() {
        assertEquals(0, DamerauLevenshteinDistance.distance("", ""));
    }

    @Test
    void should_returnZero_when_stringsAreIdentical() {
        assertEquals(0, DamerauLevenshteinDistance.distance("algorithm", "algorithm"));
    }

    @Test
    void should_returnSourceLength_when_targetStringIsEmpty() {
        assertEquals(6, DamerauLevenshteinDistance.distance("abcdef", ""));
    }

    @Test
    void should_returnTargetLength_when_sourceStringIsEmpty() {
        assertEquals(6, DamerauLevenshteinDistance.distance("", "abcdef"));
    }

    @Test
    void should_returnOne_when_singleCharacterIsInserted() {
        assertEquals(1, DamerauLevenshteinDistance.distance("abc", "abxc"));
    }

    @Test
    void should_returnOne_when_singleCharacterIsDeleted() {
        assertEquals(1, DamerauLevenshteinDistance.distance("abxc", "abc"));
    }

    @Test
    void should_returnOne_when_singleCharacterIsSubstituted() {
        assertEquals(1, DamerauLevenshteinDistance.distance("abc", "axc"));
    }

    @Test
    void should_returnOne_when_adjacentCharactersAreTransposed() {
        assertEquals(1, DamerauLevenshteinDistance.distance("abcd", "acbd"));
    }

    @Test
    void should_returnOne_when_repeatedCharactersAreTransposed() {
        assertEquals(1, DamerauLevenshteinDistance.distance("aab", "aba"));
    }

    @Test
    void should_returnTwo_when_transpositionAndInsertionAreBothRequired() {
        assertEquals(2, DamerauLevenshteinDistance.distance("CA", "ABC"));
    }

    @Test
    void should_returnThree_when_multipleDifferentEditsAreRequired() {
        assertEquals(3, DamerauLevenshteinDistance.distance("kitten", "sitting"));
    }

    @Test
    void should_returnOne_when_charactersDifferOnlyByCase() {
        assertEquals(1, DamerauLevenshteinDistance.distance("abc", "Abc"));
    }

    @Test
    void should_returnSameDistance_when_inputStringsAreSwapped() {
        int originalDistance = DamerauLevenshteinDistance.distance("CA", "ABC");
        int reversedDistance = DamerauLevenshteinDistance.distance("ABC", "CA");

        assertEquals(originalDistance, reversedDistance);
    }

    @Test
    void should_throwIllegalArgumentException_when_firstStringIsNull() {
        assertThrows(IllegalArgumentException.class,
            () -> DamerauLevenshteinDistance.distance(null, "abc"));
    }

    @Test
    void should_throwIllegalArgumentException_when_secondStringIsNull() {
        assertThrows(IllegalArgumentException.class,
            () -> DamerauLevenshteinDistance.distance("abc", null));
    }

    @Test
    void should_throwIllegalArgumentException_when_bothStringsAreNull() {
        assertThrows(IllegalArgumentException.class,
            () -> DamerauLevenshteinDistance.distance(null, null));
    }
}
