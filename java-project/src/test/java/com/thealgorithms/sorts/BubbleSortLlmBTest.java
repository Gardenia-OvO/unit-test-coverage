package com.thealgorithms.sorts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BubbleSortLlmBTest {

    private final BubbleSort bubbleSort = new BubbleSort();

    @Test
    public void should_sortIntegerArray_when_arrayIsUnsorted() {
        Integer[] array = {5, 1, 4, 2, 3};
        Integer[] expected = {1, 2, 3, 4, 5};

        Integer[] actual = bubbleSort.sort(array);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void should_sortStringArray_when_arrayIsUnsorted() {
        String[] array = {"banana", "apple", "cherry", "date"};
        String[] expected = {"apple", "banana", "cherry", "date"};

        String[] actual = bubbleSort.sort(array);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void should_keepEmptyArray_when_arrayIsEmpty() {
        Integer[] array = {};
        Integer[] expected = {};

        Integer[] actual = bubbleSort.sort(array);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void should_keepSingleElementArray_when_arrayHasOneElement() {
        Integer[] array = {42};
        Integer[] expected = {42};

        Integer[] actual = bubbleSort.sort(array);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void should_keepAlreadySortedArray_when_arrayIsSorted() {
        Integer[] array = {1, 2, 3, 4, 5};
        Integer[] expected = {1, 2, 3, 4, 5};

        Integer[] actual = bubbleSort.sort(array);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void should_sortArrayWithDuplicates_when_arrayContainsDuplicates() {
        Integer[] array = {3, 1, 3, 2, 1};
        Integer[] expected = {1, 1, 2, 3, 3};

        Integer[] actual = bubbleSort.sort(array);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void should_sortArrayWithNegativeNumbers_when_arrayIsUnsorted() {
        Integer[] array = {3, -1, 0, -5, 2};
        Integer[] expected = {-5, -1, 0, 2, 3};

        Integer[] actual = bubbleSort.sort(array);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void should_throwNullPointerException_when_arrayIsNull() {
        Assertions.assertThrows(NullPointerException.class, () -> bubbleSort.sort((Integer[]) null));
    }
}
