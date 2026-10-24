package com.thealgorithms.searches;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class LinearSearchManualTest {

    private final LinearSearch search = new LinearSearch();

    @Test
    void should_find_value_in_unsorted_array() {
        Integer[] array = {5, 3, 8, 1, 9};
        assertEquals(2, search.find(array, 8));
        assertEquals(0, search.find(array, 5));
        assertEquals(4, search.find(array, 9));
    }

    @Test
    void should_return_minus_one_when_value_is_absent() {
        assertEquals(-1, search.find(new Integer[] {5, 3, 8}, 7));
    }

    @Test
    void should_return_minus_one_for_null_or_empty_array() {
        assertEquals(-1, search.find(null, 1));
        assertEquals(-1, search.find(new Integer[] {}, 1));
    }

    @Test
    void should_return_minus_one_when_searched_value_is_null() {
        assertEquals(-1, search.find(new Integer[] {1, 2, 3}, null));
    }

    @Test
    void should_skip_null_elements_inside_array() {
        Integer[] array = {1, null, 3};
        assertEquals(2, search.find(array, 3));
    }

    @Test
    void should_find_string_values() {
        String[] words = {"pear", "apple", "orange"};
        assertEquals(1, search.find(words, "apple"));
        assertEquals(-1, search.find(words, "banana"));
    }
}
