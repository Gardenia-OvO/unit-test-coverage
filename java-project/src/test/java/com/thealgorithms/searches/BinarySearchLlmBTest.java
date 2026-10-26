package com.thealgorithms.searches;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchLlmBTest {

    private final BinarySearch binarySearch = new BinarySearch();

    @Test
    void should_returnMinusOne_when_arrayIsNull() {
        Integer[] array = null;
        assertEquals(-1, binarySearch.find(array, 1));
    }

    @Test
    void should_returnMinusOne_when_arrayIsEmpty() {
        Integer[] array = {};
        assertEquals(-1, binarySearch.find(array, 1));
    }

    @Test
    void should_returnMinusOne_when_keyIsNull() {
        Integer[] array = {1, 2, 3, 4, 5};
        assertEquals(-1, binarySearch.find(array, null));
    }

    @Test
    void should_returnIndex_when_keyIsAtMiddle() {
        Integer[] array = {1, 3, 5, 7, 9};
        assertEquals(2, binarySearch.find(array, 5));
    }

    @Test
    void should_returnIndex_when_keyIsAtStart() {
        Integer[] array = {1, 3, 5, 7, 9};
        assertEquals(0, binarySearch.find(array, 1));
    }

    @Test
    void should_returnIndex_when_keyIsAtEnd() {
        Integer[] array = {1, 3, 5, 7, 9};
        assertEquals(4, binarySearch.find(array, 9));
    }

    @Test
    void should_returnMinusOne_when_keyIsLessThanFirstElement() {
        Integer[] array = {2, 4, 6, 8, 10};
        assertEquals(-1, binarySearch.find(array, 1));
    }

    @Test
    void should_returnMinusOne_when_keyIsGreaterThanLastElement() {
        Integer[] array = {2, 4, 6, 8, 10};
        assertEquals(-1, binarySearch.find(array, 11));
    }

    @Test
    void should_returnMinusOne_when_keyIsAbsentBetweenElements() {
        Integer[] array = {2, 4, 6, 8, 10};
        assertEquals(-1, binarySearch.find(array, 7));
    }

    @Test
    void should_returnIndex_when_arrayHasSingleMatchingElement() {
        Integer[] array = {42};
        assertEquals(0, binarySearch.find(array, 42));
    }

    @Test
    void should_returnMinusOne_when_singleElementDoesNotMatch() {
        Integer[] array = {42};
        assertEquals(-1, binarySearch.find(array, 7));
    }

    @Test
    void should_returnIndex_when_arrayContainsStrings() {
        String[] array = {"apple", "banana", "cherry", "date"};
        assertEquals(1, binarySearch.find(array, "banana"));
    }
}
