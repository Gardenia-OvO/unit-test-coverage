package com.thealgorithms.searches;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BinarySearchManualTest {

    private final BinarySearch binarySearch = new BinarySearch();

    // 正常情况：有序数组找到目标
    @Test
    void should_return_index_when_key_exists_in_sorted_array() {
        Integer[] array = {3, 8, 15, 22, 31, 47, 56};
        assertEquals(4, binarySearch.find(array, 31));
    }

    // 正常情况：找不到返回 -1
    @Test
    void should_return_negative_one_when_key_does_not_exist() {
        Integer[] array = {3, 8, 15, 22, 31, 47, 56};
        assertEquals(-1, binarySearch.find(array, 40));
    }

    // 边界：空数组返回 -1
    @Test
    void should_return_negative_one_when_array_is_empty() {
        Integer[] array = {};
        assertEquals(-1, binarySearch.find(array, 5));
    }

    // 边界：null 数组返回 -1
    @Test
    void should_return_negative_one_when_array_is_null() {
        assertEquals(-1, binarySearch.find(null, 5));
    }

    // 边界：null key 返回 -1
    @Test
    void should_return_negative_one_when_key_is_null() {
        Integer[] array = {1, 2, 3};
        assertEquals(-1, binarySearch.find(array, null));
    }

    // 正常：String 类型，验证泛型 Comparable
    @Test
    void should_find_string_when_array_is_sorted_strings() {
        String[] array = {"ant", "bee", "cat", "dog"};
        assertEquals(2, binarySearch.find(array, "cat"));
    }
}