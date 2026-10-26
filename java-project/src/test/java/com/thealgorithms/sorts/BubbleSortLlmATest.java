package com.thealgorithms.sorts;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class BubbleSortLlmATest {

    private final BubbleSort bubbleSort = new BubbleSort();

    @Test
    void should_sortIntegers_when_arrayIsUnsorted() {
        Integer[] array = {5, 1, 4, 2, 8};

        Integer[] result = bubbleSort.sort(array);

        assertArrayEquals(new Integer[] {1, 2, 4, 5, 8}, result);
    }

    @Test
    void should_keepArrayUnchanged_when_arrayIsAlreadySorted() {
        Integer[] array = {1, 2, 3, 4, 5};

        Integer[] result = bubbleSort.sort(array);

        assertArrayEquals(new Integer[] {1, 2, 3, 4, 5}, result);
    }

    @Test
    void should_sortIntegers_when_arrayContainsDuplicatesAndNegativeNumbers() {
        Integer[] array = {3, -1, 3, 0, -5, 0};

        Integer[] result = bubbleSort.sort(array);

        assertArrayEquals(new Integer[] {-5, -1, 0, 0, 3, 3}, result);
    }

    @Test
    void should_sortStrings_when_arrayContainsUnsortedStrings() {
        String[] array = {"banana", "apple", "cherry", "apple"};

        String[] result = bubbleSort.sort(array);

        assertArrayEquals(new String[] {"apple", "apple", "banana", "cherry"}, result);
    }

    @Test
    void should_returnEmptyArray_when_arrayIsEmpty() {
        Integer[] array = new Integer[0];

        Integer[] result = bubbleSort.sort(array);

        assertArrayEquals(new Integer[0], result);
    }

    @Test
    void should_keepSingleElement_when_arrayHasOneElement() {
        Integer[] array = {42};

        Integer[] result = bubbleSort.sort(array);

        assertArrayEquals(new Integer[] {42}, result);
    }

    @Test
    void should_returnSameArrayInstance_when_sortIsCalled() {
        Integer[] array = {2, 1, 3};

        Integer[] result = bubbleSort.sort(array);

        assertSame(array, result);
    }

    @Test
    void should_throwNullPointerException_when_arrayIsNull() {
        Integer[] array = null;

        assertThrows(NullPointerException.class, () -> bubbleSort.sort(array));
    }
}
