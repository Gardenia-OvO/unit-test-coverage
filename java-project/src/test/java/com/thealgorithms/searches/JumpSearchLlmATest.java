package com.thealgorithms.searches;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class JumpSearchLlmATest {

    private final JumpSearch jumpSearch = new JumpSearch();

    @Test
    void should_return_minus_one_when_array_is_empty() {
        Integer[] array = {};

        assertEquals(-1, jumpSearch.find(array, 1));
    }

    @ParameterizedTest
    @CsvSource({
        "0, 1",
        "4, 9",
        "9, 19"
    })
    void should_return_expected_index_when_key_is_present(int expectedIndex, int key) {
        Integer[] array = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};

        assertEquals(expectedIndex, jumpSearch.find(array, key));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 2, 8, 20})
    void should_return_minus_one_when_key_is_not_present(int key) {
        Integer[] array = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};

        assertEquals(-1, jumpSearch.find(array, key));
    }

    @Test
    void should_return_zero_when_single_element_array_contains_key() {
        Integer[] array = {7};

        assertEquals(0, jumpSearch.find(array, 7));
    }

    @Test
    void should_return_minus_one_when_single_element_array_does_not_contain_key() {
        Integer[] array = {7};

        assertEquals(-1, jumpSearch.find(array, 8));
    }

    @Test
    void should_return_expected_index_when_searching_strings() {
        String[] array = {"apple", "banana", "cherry", "date"};

        assertEquals(2, jumpSearch.find(array, "cherry"));
    }

    @Test
    void should_throw_null_pointer_exception_when_array_is_null() {
        Integer[] array = null;

        assertThrows(NullPointerException.class, () -> jumpSearch.find(array, 1));
    }
}
