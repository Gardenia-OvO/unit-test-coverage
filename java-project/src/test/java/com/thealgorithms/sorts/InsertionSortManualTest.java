package com.thealgorithms.sorts;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class InsertionSortManualTest {

    private final InsertionSort insertionSort = new InsertionSort();

    @Test
    void should_sort_unsorted_array() {
        assertArrayEquals(new Integer[] {1, 3, 5, 8}, insertionSort.sort(new Integer[] {5, 3, 8, 1}));
    }

    @Test
    void should_sort_reverse_sorted_array() {
        assertArrayEquals(new Integer[] {1, 2, 3, 4}, insertionSort.sort(new Integer[] {4, 3, 2, 1}));
    }

    @Test
    void should_keep_sorted_array_and_single_element_unchanged() {
        assertArrayEquals(new Integer[] {1, 2, 3}, insertionSort.sort(new Integer[] {1, 2, 3}));
        assertArrayEquals(new Integer[] {7}, insertionSort.sort(new Integer[] {7}));
        assertArrayEquals(new Integer[] {}, insertionSort.sort(new Integer[] {}));
    }

    @Test
    void should_sort_array_with_duplicates() {
        assertArrayEquals(new Integer[] {1, 2, 2, 3}, insertionSort.sort(new Integer[] {2, 3, 2, 1}));
    }

    @Test
    void should_sort_only_the_requested_subarray() {
        Integer[] input = {9, 4, 3, 2, 1, 9};
        insertionSort.sort(input, 1, 5);
        assertArrayEquals(new Integer[] {9, 1, 2, 3, 4, 9}, input);
    }

    @Test
    void should_sort_with_sentinel_variant() {
        assertArrayEquals(new Integer[] {1, 3, 5, 8}, insertionSort.sentinelSort(new Integer[] {5, 3, 8, 1}));
        assertArrayEquals(new Integer[] {2, 2, 3}, insertionSort.sentinelSort(new Integer[] {3, 2, 2}));
    }

    @Test
    void should_return_null_when_sentinel_sort_gets_null() {
        assertNull(insertionSort.sentinelSort(null));
    }

    @Test
    void should_return_input_when_subarray_bounds_are_invalid() {
        Integer[] input = {3, 1, 2};
        insertionSort.sort(input, 2, 2);
        assertArrayEquals(new Integer[] {3, 1, 2}, input);
    }
}
