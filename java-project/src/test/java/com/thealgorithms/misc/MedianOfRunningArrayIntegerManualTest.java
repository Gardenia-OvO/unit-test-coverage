package com.thealgorithms.misc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class MedianOfRunningArrayIntegerManualTest {

    // 异常：空数据集 getMedian 抛 IllegalArgumentException
    @Test
    void should_throw_illegal_argument_exception_when_dataset_is_empty() {
        MedianOfRunningArrayInteger stream = new MedianOfRunningArrayInteger();
        assertThrows(IllegalArgumentException.class, stream::getMedian);
    }

    // 正常情况：单个元素，中位数即自身
    @Test
    void should_return_element_itself_when_only_one_value_inserted() {
        MedianOfRunningArrayInteger stream = new MedianOfRunningArrayInteger();
        stream.insert(42);
        assertEquals(42, stream.getMedian());
    }

    // 正常情况：偶数个元素取平均（整数除法）
    @Test
    void should_return_average_of_two_middle_values_when_count_is_even() {
        MedianOfRunningArrayInteger stream = new MedianOfRunningArrayInteger();
        stream.insert(10);
        stream.insert(20);
        assertEquals(15, stream.getMedian());
    }

    // 正常情况：奇数个元素取中间值（乱序插入）
    @Test
    void should_return_middle_value_when_count_is_odd_and_input_is_unsorted() {
        MedianOfRunningArrayInteger stream = new MedianOfRunningArrayInteger();
        stream.insert(7);
        stream.insert(1);
        stream.insert(4);
        assertEquals(4, stream.getMedian());
    }

    // 边界：负数
    @Test
    void should_handle_negative_values() {
        MedianOfRunningArrayInteger stream = new MedianOfRunningArrayInteger();
        stream.insert(-5);
        stream.insert(-1);
        stream.insert(-3);
        assertEquals(-3, stream.getMedian());
    }

    // 边界：重复值
    @Test
    void should_handle_duplicate_values() {
        MedianOfRunningArrayInteger stream = new MedianOfRunningArrayInteger();
        stream.insert(6);
        stream.insert(6);
        stream.insert(6);
        stream.insert(2);
        assertEquals(6, stream.getMedian());
    }
}