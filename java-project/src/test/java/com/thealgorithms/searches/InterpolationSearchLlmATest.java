package com.thealgorithms.searches;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class InterpolationSearchLlmATest {

    private final InterpolationSearch interpolationSearch = new InterpolationSearch();

    @Test
    void should_return_middle_index_when_key_is_present() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        assertEquals(4, interpolationSearch.find(array, 5));
    }

    @Test
    void should_return_zero_when_key_is_first_element() {
        int[] array = {10, 20, 30, 40};

        assertEquals(0, interpolationSearch.find(array, 10));
    }

    @Test
    void should_return_last_index_when_key_is_last_element() {
        int[] array = {10, 20, 30, 40};

        assertEquals(3, interpolationSearch.find(array, 40));
    }

    @Test
    void should_return_minus_one_when_key_is_absent_within_range() {
        int[] array = {1, 3, 5, 7, 9};

        assertEquals(-1, interpolationSearch.find(array, 4));
    }

    @Test
    void should_return_minus_one_when_key_is_below_minimum() {
        int[] array = {1, 3, 5, 7, 9};

        assertEquals(-1, interpolationSearch.find(array, 0));
    }

    @Test
    void should_return_minus_one_when_key_is_above_maximum() {
        int[] array = {1, 3, 5, 7, 9};

        assertEquals(-1, interpolationSearch.find(array, 10));
    }

    @Test
    void should_return_minus_one_when_array_is_empty() {
        int[] array = {};

        assertEquals(-1, interpolationSearch.find(array, 1));
    }

    @Test
    void should_return_zero_when_single_element_matches_key() {
        int[] array = {7};

        assertEquals(0, interpolationSearch.find(array, 7));
    }

    @Test
    void should_return_minus_one_when_single_element_does_not_match_key() {
        int[] array = {7};

        assertEquals(-1, interpolationSearch.find(array, 8));
    }

    @Test
    void should_return_index_when_distribution_is_not_uniform() {
        int[] array = {1, 2, 4, 8, 16, 32, 64};

        assertEquals(3, interpolationSearch.find(array, 8));
    }

    @Test
    void should_return_index_when_array_contains_negative_values() {
        int[] array = {-20, -10, 0, 10, 20};

        assertEquals(1, interpolationSearch.find(array, -10));
    }

    @Test
    void should_return_matching_index_when_array_contains_duplicates() {
        int[] array = {1, 2, 2, 2, 3};

        assertEquals(2, interpolationSearch.find(array, 2));
    }

    @Test
    void should_return_zero_when_all_elements_equal_key() {
        int[] array = {4, 4, 4, 4};

        assertEquals(0, interpolationSearch.find(array, 4));
    }

    @Test
    void should_throw_null_pointer_exception_when_array_is_null() {
        assertThrows(NullPointerException.class, () -> interpolationSearch.find(null, 1));
    }
}
