package com.thealgorithms.sorts;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

class BubbleSortManualTest {

    private final BubbleSort bubbleSort = new BubbleSort();

    @Test
    void should_sort_unsorted_array_of_integers() {
        Integer[] input = {5, 3, 8, 1};
        assertArrayEquals(new Integer[] {1, 3, 5, 8}, bubbleSort.sort(input));
    }

    @Test
    void should_keep_already_sorted_array_unchanged() {
        Integer[] input = {1, 2, 3, 4};
        assertArrayEquals(new Integer[] {1, 2, 3, 4}, bubbleSort.sort(input));
    }

    @Test
    void should_handle_single_element_and_empty_array() {
        assertArrayEquals(new Integer[] {7}, bubbleSort.sort(new Integer[] {7}));
        assertArrayEquals(new Integer[] {}, bubbleSort.sort(new Integer[] {}));
    }

    @Test
    void should_sort_array_with_duplicates() {
        Integer[] input = {3, 1, 3, 2};
        assertArrayEquals(new Integer[] {1, 2, 3, 3}, bubbleSort.sort(input));
    }

    @Test
    void should_sort_strings_using_natural_order() {
        String[] input = {"pear", "apple", "orange"};
        assertArrayEquals(new String[] {"apple", "orange", "pear"}, bubbleSort.sort(input));
    }

    @Test
    void should_sort_reverse_sorted_array() {
        Integer[] input = {9, 7, 5, 3, 1};
        assertArrayEquals(new Integer[] {1, 3, 5, 7, 9}, bubbleSort.sort(input));
    }
}
