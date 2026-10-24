package com.thealgorithms.dynamicprogramming;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class DamerauLevenshteinDistanceManualTest {

    @Test
    void should_return_zero_for_identical_strings() {
        assertEquals(0, DamerauLevenshteinDistance.distance("abc", "abc"));
        assertEquals(0, DamerauLevenshteinDistance.distance("", ""));
    }

    @Test
    void should_count_insertions_for_empty_first_string() {
        assertEquals(3, DamerauLevenshteinDistance.distance("", "abc"));
        assertEquals(3, DamerauLevenshteinDistance.distance("abc", ""));
    }

    @Test
    void should_count_one_substitution() {
        assertEquals(1, DamerauLevenshteinDistance.distance("cat", "cut"));
        assertEquals(3, DamerauLevenshteinDistance.distance("cat", "dog"));
    }

    @Test
    void should_count_adjacent_transposition_as_one_edit() {
        assertEquals(1, DamerauLevenshteinDistance.distance("abc", "acb"));
    }

    @Test
    void should_handle_known_textbook_cases() {
        assertEquals(3, DamerauLevenshteinDistance.distance("kitten", "sitting"));
        assertEquals(2, DamerauLevenshteinDistance.distance("CA", "ABC"));
    }

    @Test
    void should_be_symmetric() {
        assertEquals(
            DamerauLevenshteinDistance.distance("banana", "bandana"),
            DamerauLevenshteinDistance.distance("bandana", "banana"));
    }

    @Test
    void should_throw_when_any_input_is_null() {
        assertThrows(IllegalArgumentException.class, () -> DamerauLevenshteinDistance.distance(null, "abc"));
        assertThrows(IllegalArgumentException.class, () -> DamerauLevenshteinDistance.distance("abc", null));
    }
}
