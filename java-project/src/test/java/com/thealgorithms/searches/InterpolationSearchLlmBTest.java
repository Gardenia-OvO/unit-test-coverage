package com.thealgorithms.searches;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class InterpolationSearchLlmBTest {

    private final InterpolationSearch interpolationSearch = new InterpolationSearch();

    @ParameterizedTest
    @CsvSource({
        "10, 0",
        "20, 1",
        "30, 2",
        "40, 3",
        "50, 4"
    })
    void should_returnExpectedIndex_when_keyExistsInSortedArray(int key, int expectedIndex) {
        int[] array = {10, 20, 30, 40, 50};
        assertEquals(expectedIndex, interpolationSearch.find(array, key));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 5, 15, 25, 35, 45, 55, 100})
    void should_returnMinusOne_when_keyDoesNotExistInSortedArray(int key) {
        int[] array = {10, 20, 30, 40, 50};
        assertEquals(-1, interpolationSearch.find(array, key));
    }

    @Test
    void should_returnMinusOne_when_arrayIsEmpty() {
        assertEquals(-1, interpolationSearch.find(new int[] {}, 1));
    }

    @Test
    void should_returnZero_when_singleElementArrayContainsKey() {
        assertEquals(0, interpolationSearch.find(new int[] {42}, 42));
    }

    @Test
    void should_returnMinusOne_when_singleElementArrayDoesNotContainKey() {
        assertEquals(-1, interpolationSearch.find(new int[] {42}, 41));
    }

    @ParameterizedTest
    @CsvSource({
        "-9, 0",
        "-4, 1",
        "-1, 2",
        "0, 3",
        "5, 4"
    })
    void should_returnExpectedIndex_when_keyExistsInArrayWithNegativeValues(int key, int expectedIndex) {
        int[] array = {-9, -4, -1, 0, 5};
        assertEquals(expectedIndex, interpolationSearch.find(array, key));
    }

    @Test
    void should_returnZero_when_allElementsAreEqualAndKeyExists() {
        int[] array = {7, 7, 7, 7};
        assertEquals(0, interpolationSearch.find(array, 7));
    }

    @Test
    void should_returnMinusOne_when_allElementsAreEqualAndKeyDoesNotExist() {
        int[] array = {7, 7, 7, 7};
        assertEquals(-1, interpolationSearch.find(array, 8));
    }

    @Test
    void should_returnMatchingIndex_when_duplicateKeyExists() {
        int[] array = {1, 2, 2, 2, 3};
        int index = interpolationSearch.find(array, 2);
        assertTrue(index >= 0 && array[index] == 2);
    }

    @Test
    void should_throwNullPointerException_when_arrayIsNull() {
        assertThrows(NullPointerException.class, () -> interpolationSearch.find(null, 1));
    }
}
