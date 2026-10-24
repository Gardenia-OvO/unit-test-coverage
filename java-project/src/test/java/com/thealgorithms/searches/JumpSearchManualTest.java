package com.thealgorithms.searches;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class JumpSearchManualTest {

    private final JumpSearch jumpSearch = new JumpSearch();

    // 正常情况：有序数组找到目标
    @Test
    void should_return_index_when_key_exists_in_sorted_array() {
        Integer[] array = {2, 4, 6, 8, 10, 12, 14, 16};
        assertEquals(3, jumpSearch.find(array, 8));
    }

    // 正常情况：找不到返回 -1
    @Test
    void should_return_negative_one_when_key_does_not_exist() {
        Integer[] array = {2, 4, 6, 8, 10};
        assertEquals(-1, jumpSearch.find(array, 7));
    }

    // 边界：空数组返回 -1
    @Test
    void should_return_negative_one_when_array_is_empty() {
        Integer[] array = {};
        assertEquals(-1, jumpSearch.find(array, 1));
    }

    // 边界：单元素数组，找到与找不到
    @Test
    void should_handle_single_element_array() {
        Integer[] array = {5};
        assertEquals(0, jumpSearch.find(array, 5));
        assertEquals(-1, jumpSearch.find(array, 9));
    }

    // 回归：key 大于最大值，返回 -1（不会死循环，因为 limit += blockSize 最终 >= length）
    @Test
    void should_return_negative_one_without_infinite_loop_when_key_is_greater_than_max() {
        Integer[] array = {1, 3, 5, 7};
        assertEquals(-1, jumpSearch.find(array, 100));
    }

    // 异常：源码未判空，传 null 抛 NullPointerException
    @Test
    void should_throw_null_pointer_exception_when_array_is_null() {
        assertThrows(NullPointerException.class, () -> jumpSearch.find(null, 5));
    }
}