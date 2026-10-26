package com.thealgorithms.sorts;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InsertionSortLlmBTest {
    private final InsertionSort insertionSort = new InsertionSort();

    @Test
    void should_sortIntegerArrayInAscendingOrder_when_arrayUnsorted() {
        Integer[] array = {5, -1, 3, 0, 2};
        Integer[] expected = {-1, 0, 2, 3, 5};
        assertArrayEquals(expected, insertionSort.sort(array));
    }

    @Test
    void should_sortStringArrayInAscendingOrder_when_arrayUnsorted() {
        String[] array = {"banana", "apple", "cherry"};
        String[] expected = {"apple", "banana", "cherry"};
        assertArrayEquals(expected, insertionSort.sort(array));
    }

    @Test
    void should_preserveDuplicateElementsInSortedOrder_when_arrayHasDuplicates() {
        Integer[] array = {2, 1, 2, 0, 1};
        Integer[] expected = {0, 1, 1, 2, 2};
        assertArrayEquals(expected, insertionSort.sort(array));
    }

    @Test
    void should_throwNullPointerException_when_sortCalledWithNullArray() {
        assertThrows(NullPointerException.class, () -> {
            insertionSort.sort((Integer[]) null);
        });
    }

    @Test
    void should_sortOnlySpecifiedRange_when_startAndEndProvided() {
        Integer[] array = {9, 5, 3, 7, 1, 4};
        Integer[] expected = {9, 1, 3, 5, 7, 4};
        assertArrayEquals(expected, insertionSort.sort(array, 1, 5));
    }

    @Test
    void should_returnSameArray_when_startIndexEqualsEndIndex() {
        Integer[] array = {4, 2, 3};
        assertSame(array, insertionSort.sort(array, 1, 1));
    }

    @Test
    void should_returnNull_when_sortRangeCalledWithNullArray() {
        assertNull(insertionSort.sort((Integer[]) null, 0, 1));
    }

    @Test
    void should_sortArrayInAscendingOrder_when_sentinelSortCalledWithUnsortedArray() {
        Integer[] array = {5, 3, 1, 4, 2};
        Integer[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, insertionSort.sentinelSort(array));
    }

    @Test
    void should_returnNull_when_sentinelSortCalledWithNullArray() {
        assertNull(insertionSort.sentinelSort((Integer[]) null));
    }

    @Test
    void should_returnSameArray_when_sentinelSortCalledWithEmptyArray() {
        Integer[] empty = new Integer[0];
        assertSame(empty, insertionSort.sentinelSort(empty));
    }

    @Test
    void should_preserveDuplicateElementsInSortedOrder_when_sentinelSortCalledWithDuplicates() {
        Integer[] array = {2, 1, 2, 0, 1};
        Integer[] expected = {0, 1, 1, 2, 2};
        assertArrayEquals(expected, insertionSort.sentinelSort(array));
    }
}
