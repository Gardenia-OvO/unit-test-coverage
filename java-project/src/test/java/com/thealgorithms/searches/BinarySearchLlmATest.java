package com.thealgorithms.searches;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class BinarySearchLlmATest {

    private final BinarySearch binarySearch = new BinarySearch();

    @Test
    void should_return_minus_one_when_array_is_null() {
        Integer[] array = null;

        int result = binarySearch.find(array, 1);

        Assertions.assertEquals(-1, result);
    }

    @Test
    void should_return_minus_one_when_array_is_empty() {
        Integer[] array = {};

        int result = binarySearch.find(array, 1);

        Assertions.assertEquals(-1, result);
    }

    @Test
    void should_return_minus_one_when_key_is_null() {
        Integer[] array = {1, 3, 5, 7};

        int result = binarySearch.find(array, null);

        Assertions.assertEquals(-1, result);
    }

    @ParameterizedTest
    @CsvSource({
        "1, 0",
        "7, 3",
        "11, 5",
        "19, 9"
    })
    void should_return_expected_index_when_key_is_present(int key, int expectedIndex) {
        Integer[] array = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};

        int result = binarySearch.find(array, key);

        Assertions.assertEquals(expectedIndex, result);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 4, 20})
    void should_return_minus_one_when_key_is_not_present(int key) {
        Integer[] array = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};

        int result = binarySearch.find(array, key);

        Assertions.assertEquals(-1, result);
    }

    @Test
    void should_return_zero_when_single_element_array_contains_key() {
        Integer[] array = {42};

        int result = binarySearch.find(array, 42);

        Assertions.assertEquals(0, result);
    }

    @Test
    void should_return_minus_one_when_single_element_array_does_not_contain_key() {
        Integer[] array = {42};

        int result = binarySearch.find(array, 41);

        Assertions.assertEquals(-1, result);
    }

    @Test
    void should_return_expected_index_when_searching_comparable_strings() {
        String[] array = {"apple", "banana", "cherry", "date"};

        int result = binarySearch.find(array, "cherry");

        Assertions.assertEquals(2, result);
    }
}
