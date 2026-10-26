package com.thealgorithms.sorts;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class InsertionSortLlmATest {

    private final InsertionSort insertionSort = new InsertionSort();

    @Test
    void should_sort_elements_when_array_is_unsorted() {
        Integer[] array = {5, 2, 9, 1, 5, 6};

        Integer[] result = insertionSort.sort(array);

        assertArrayEquals(new Integer[] {1, 2, 5, 5, 6, 9}, result);
    }

    @Test
    void should_sort_elements_when_array_is_reverse_sorted() {
        Integer[] array = {5, 4, 3, 2, 1};

        Integer[] result = insertionSort.sort(array);

        assertArrayEquals(new Integer[] {1, 2, 3, 4, 5}, result);
    }

    @Test
    void should_sort_strings_when_array_contains_strings() {
        String[] array = {"banana", "apple", "cherry", "apple"};

        String[] result = insertionSort.sort(array);

        assertArrayEquals(new String[] {"apple", "apple", "banana", "cherry"}, result);
    }

    @Test
    void should_return_empty_array_when_array_is_empty() {
        Integer[] array = {};

        Integer[] result = insertionSort.sort(array);

        assertArrayEquals(new Integer[] {}, result);
    }

    @Test
    void should_return_same_array_when_array_has_one_element() {
        Integer[] array = {42};

        Integer[] result = insertionSort.sort(array);

        assertSame(array, result);
    }

    @Test
    void should_throw_null_pointer_exception_when_sort_array_is_null() {
        assertThrows(NullPointerException.class, () -> insertionSort.sort((Integer[]) null));
    }

    @Test
    void should_sort_only_subarray_when_start_and_end_indices_are_provided() {
        Integer[] array = {9, 4, 3, 2, 8};

        Integer[] result = insertionSort.sort(array, 1, 4);

        assertArrayEquals(new Integer[] {9, 2, 3, 4, 8}, result);
    }

    @Test
    void should_leave_array_unchanged_when_subarray_range_is_empty() {
        Integer[] array = {3, 1, 2};

        Integer[] result = insertionSort.sort(array, 1, 1);

        assertArrayEquals(new Integer[] {3, 1, 2}, result);
    }

    @Test
    void should_return_null_when_subarray_array_is_null() {
        Integer[] result = insertionSort.sort((Integer[]) null, 0, 1);

        assertNull(result);
    }

    @Test
    void should_sort_elements_when_sentinel_sort_receives_unsorted_array() {
        Integer[] array = {5, -1, 3, -1, 2, 0};

        Integer[] result = insertionSort.sentinelSort(array);

        assertArrayEquals(new Integer[] {-1, -1, 0, 2, 3, 5}, result);
    }

    @Test
    void should_sort_elements_when_sentinel_sort_receives_two_elements() {
        Integer[] array = {2, 1};

        Integer[] result = insertionSort.sentinelSort(array);

        assertArrayEquals(new Integer[] {1, 2}, result);
    }

    @Test
    void should_sort_strings_when_sentinel_sort_receives_strings() {
        String[] array = {"pear", "apple", "orange", "banana"};

        String[] result = insertionSort.sentinelSort(array);

        assertArrayEquals(new String[] {"apple", "banana", "orange", "pear"}, result);
    }

    @Test
    void should_return_same_array_when_sentinel_sort_receives_empty_array() {
        Integer[] array = {};

        Integer[] result = insertionSort.sentinelSort(array);

        assertSame(array, result);
    }

    @Test
    void should_return_same_array_when_sentinel_sort_receives_single_element() {
        Integer[] array = {7};

        Integer[] result = insertionSort.sentinelSort(array);

        assertSame(array, result);
    }

    @Test
    void should_return_null_when_sentinel_sort_receives_null() {
        Integer[] result = insertionSort.sentinelSort((Integer[]) null);

        assertNull(result);
    }
}
