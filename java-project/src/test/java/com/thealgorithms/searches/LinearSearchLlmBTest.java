package com.thealgorithms.searches;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinearSearchLlmBTest {

    private final LinearSearch linearSearch = new LinearSearch();

    @Test
    void should_returnNegativeOne_when_arrayIsNull() {
        Integer[] array = null;
        assertEquals(-1, linearSearch.find(array, 1));
    }

    @Test
    void should_returnNegativeOne_when_arrayIsEmpty() {
        Integer[] array = new Integer[] {};
        assertEquals(-1, linearSearch.find(array, 1));
    }

    @Test
    void should_returnNegativeOne_when_valueIsNull() {
        Integer[] array = new Integer[] {1, 2, 3};
        assertEquals(-1, linearSearch.find(array, (Integer) null));
    }

    @Test
    void should_returnFirstIndex_when_valueIsAtFirstPosition() {
        Integer[] array = new Integer[] {5, 3, 8, 1, 9};
        assertEquals(0, linearSearch.find(array, 5));
    }

    @Test
    void should_returnMiddleIndex_when_valueIsInMiddle() {
        Integer[] array = new Integer[] {5, 3, 8, 1, 9};
        assertEquals(2, linearSearch.find(array, 8));
    }

    @Test
    void should_returnLastIndex_when_valueIsAtLastPosition() {
        Integer[] array = new Integer[] {5, 3, 8, 1, 9};
        assertEquals(4, linearSearch.find(array, 9));
    }

    @Test
    void should_returnNegativeOne_when_valueNotFound() {
        Integer[] array = new Integer[] {5, 3, 8, 1, 9};
        assertEquals(-1, linearSearch.find(array, 7));
    }

    @Test
    void should_returnFirstOccurrenceIndex_when_duplicatesExist() {
        Integer[] array = new Integer[] {1, 2, 1, 3};
        assertEquals(0, linearSearch.find(array, 1));
    }

    @Test
    void should_findValue_when_arrayIsUnsorted() {
        Integer[] array = new Integer[] {9, 1, 8, 2};
        assertEquals(2, linearSearch.find(array, 8));
    }

    @Test
    void should_skipNullElements_when_arrayContainsNulls() {
        Integer[] array = new Integer[] {null, 2, null, 3};
        assertEquals(3, linearSearch.find(array, 3));
    }

    @Test
    void should_returnNegativeOne_when_arrayContainsOnlyNullsAndValueNotNull() {
        Integer[] array = new Integer[] {null, null};
        assertEquals(-1, linearSearch.find(array, 1));
    }

    @Test
    void should_workWithStringArray_when_valueExists() {
        String[] array = new String[] {"apple", "banana", "cherry"};
        assertEquals(1, linearSearch.find(array, "banana"));
    }
}
