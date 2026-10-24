package com.thealgorithms.searches;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class InterpolationSearchManualTest {

    private final InterpolationSearch interpolationSearch = new InterpolationSearch();

    // 正常情况：均匀有序数组找到目标
    @Test
    void should_return_index_when_key_exists_in_uniform_array() {
        int[] array = {5, 10, 15, 20, 25, 30, 35, 40};
        assertEquals(5, interpolationSearch.find(array, 30));
    }

    // 正常情况：找不到返回 -1
    @Test
    void should_return_negative_one_when_key_does_not_exist() {
        int[] array = {5, 10, 15, 20, 25};
        assertEquals(-1, interpolationSearch.find(array, 22));
    }

    // 边界：空数组返回 -1
    @Test
    void should_return_negative_one_when_array_is_empty() {
        int[] array = {};
        assertEquals(-1, interpolationSearch.find(array, 1));
    }

    // 边界：单元素数组，找到与找不到
    @Test
    void should_handle_single_element_array() {
        int[] array = {8};
        assertEquals(0, interpolationSearch.find(array, 8));
        assertEquals(-1, interpolationSearch.find(array, 3));
    }

    // 边界：首尾元素
    @Test
    void should_find_first_and_last_elements() {
        int[] array = {3, 6, 9, 12, 15};
        assertEquals(0, interpolationSearch.find(array, 3));
        assertEquals(4, interpolationSearch.find(array, 15));
    }

    // 边界：除零场景——数组含相同值，源码里 if (array[start] == array[end]) 处理了
    @Test
    void should_not_divide_by_zero_when_array_contains_equal_values() {
        int[] array = {0, 0, 0, 9};
        assertEquals(3, interpolationSearch.find(array, 9));

        int[] allSame = {7, 7, 7};
        assertEquals(0, interpolationSearch.find(allSame, 7));
    }

    // 异常情况：源码未判空，传 null 抛 NullPointerException
    @Test
    void should_throw_null_pointer_exception_when_array_is_null() {
        assertThrows(NullPointerException.class, () -> interpolationSearch.find(null, 5));
    }
}