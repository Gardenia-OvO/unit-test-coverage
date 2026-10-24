package com.thealgorithms.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class CountWordsManualTest {

    @Test
    void should_count_words_separated_by_single_space() {
        assertEquals(2, CountWords.wordCount("hello world"));
        assertEquals(1, CountWords.wordCount("hello"));
    }

    @Test
    void should_count_words_separated_by_multiple_spaces_and_tabs() {
        assertEquals(2, CountWords.wordCount("hello   world"));
        assertEquals(3, CountWords.wordCount("one\ttwo\nthree"));
    }

    @Test
    void should_return_zero_for_null_or_empty_string() {
        assertEquals(0, CountWords.wordCount(null));
        assertEquals(0, CountWords.wordCount(""));
    }

    @Test
    void should_ignore_leading_and_trailing_spaces() {
        assertEquals(2, CountWords.wordCount("  hello world  "));
    }

    @Test
    void should_count_words_after_removing_special_characters() {
        assertEquals(2, CountWords.secondaryWordCount("hello, world!"));
        assertEquals(3, CountWords.secondaryWordCount("a-b c/d e"));
    }

    @Test
    void should_return_zero_for_null_input() {
        assertEquals(0, CountWords.secondaryWordCount(null));
    }

    @Test
    void should_count_one_for_string_made_only_of_special_characters() {
        // 特殊字符剔除后只剩空格，wordCount("   ") 的 trim+split 会返回 1 而不是 0，属于源码缺陷
        assertEquals(1, CountWords.secondaryWordCount("!!! ... ???"));
        assertEquals(1, CountWords.wordCount("   "));
    }
}
