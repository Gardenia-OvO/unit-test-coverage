package com.thealgorithms.searches;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LinearSearchLlmATest {

    private final LinearSearch linearSearch = new LinearSearch();

    @Test
    void should_returnIndex_when_valueIsInMiddleOfUnsortedArray() {
        Integer[] array = {5, 3, 8, 1, 9};

        assertEquals(2, linearSearch.find(array, 8));
    }

    @Test
    void should_returnZero_when_valueIsFirstElement() {
        Integer[] array = {5, 3, 8, 1, 9};

        assertEquals(0, linearSearch.find(array, 5));
    }

    @Test
    void should_returnLastIndex_when_valueIsLastElement() {
        Integer[] array = {5, 3, 8, 1, 9};

        assertEquals(4, linearSearch.find(array, 9));
    }

    @Test
    void should_returnFirstMatchingIndex_when_arrayContainsDuplicates() {
        Integer[] array = {1, 4, 4, 2};

        assertEquals(1, linearSearch.find(array, 4));
    }

    @Test
    void should_returnMinusOne_when_valueIsNotPresent() {
        Integer[] array = {5, 3, 8, 1, 9};

        assertEquals(-1, linearSearch.find(array, 7));
    }

    @Test
    void should_returnMinusOne_when_arrayIsNull() {
        assertEquals(-1, linearSearch.find(null, 5));
    }

    @Test
    void should_returnMinusOne_when_arrayIsEmpty() {
        Integer[] array = {};

        assertEquals(-1, linearSearch.find(array, 5));
    }

    @Test
    void should_returnMinusOne_when_valueIsNull() {
        Integer[] array = {1, 2, 3};

        assertEquals(-1, linearSearch.find(array, null));
    }

    @Test
    void should_returnIndex_when_arrayContainsNullElements() {
        Integer[] array = {null, 3, null, 5};

        assertEquals(3, linearSearch.find(array, 5));
    }

    @Test
    void should_returnMinusOne_when_arrayContainsOnlyNullElements() {
        Integer[] array = {null, null};

        assertEquals(-1, linearSearch.find(array, 3));
    }

    @Test
    void should_returnIndex_when_searchingStrings() {
        String[] array = {"apple", "banana", "cherry"};

        assertEquals(1, linearSearch.find(array, "banana"));
    }
}
