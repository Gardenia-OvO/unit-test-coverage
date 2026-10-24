package com.thealgorithms.searches;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class KMPSearchManualTest {

    private final KMPSearch kmpSearch = new KMPSearch();

    // 正常情况：模式在文本开头
    @Test
    void should_return_zero_when_pattern_is_at_beginning_of_text() {
        assertEquals(0, kmpSearch.kmpSearch("abc", "abcdef"));
    }

    // 正常情况：模式在文本中间（"cat" 在 "thecatishere" 中从索引 3 开始）
    @Test
    void should_return_start_index_when_pattern_is_in_middle_of_text() {
        assertEquals(3, kmpSearch.kmpSearch("cat", "thecatishere"));
    }

    // 正常情况：模式在文本末尾（"world" 在 "helloworld" 中从索引 5 开始）
    @Test
    void should_return_start_index_when_pattern_is_at_end_of_text() {
        assertEquals(5, kmpSearch.kmpSearch("world", "helloworld"));
    }

    // 边界：找不到返回 -1
    @Test
    void should_return_negative_one_when_pattern_is_not_in_text() {
        assertEquals(-1, kmpSearch.kmpSearch("xyz", "abcdef"));
    }

    // 边界：模式等于文本
    @Test
    void should_return_zero_when_pattern_equals_text() {
        assertEquals(0, kmpSearch.kmpSearch("hello", "hello"));
    }

    // 边界：重叠匹配——模式 "aa" 在 "aaaa" 中首次出现在 0
    @Test
    void should_return_first_occurrence_when_pattern_overlaps() {
        assertEquals(0, kmpSearch.kmpSearch("aa", "aaaa"));
    }

    // 异常情况：传 null 文本或模式抛 NullPointerException
    @Test
    void should_throw_null_pointer_exception_when_arguments_are_null() {
        assertThrows(NullPointerException.class, () -> kmpSearch.kmpSearch(null, "txt"));
        assertThrows(NullPointerException.class, () -> kmpSearch.kmpSearch("pat", null));
    }
}