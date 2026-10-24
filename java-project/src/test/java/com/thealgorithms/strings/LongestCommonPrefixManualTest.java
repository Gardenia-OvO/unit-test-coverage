package com.thealgorithms.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class LongestCommonPrefixManualTest {

    @Test
    void should_return_common_prefix_of_three_words() {
        assertEquals("fl", LongestCommonPrefix.longestCommonPrefix(new String[] {"flower", "flow", "flight"}));
    }

    @Test
    void should_return_empty_string_when_there_is_no_common_prefix() {
        assertEquals("", LongestCommonPrefix.longestCommonPrefix(new String[] {"dog", "racecar", "car"}));
    }

    @Test
    void should_return_empty_string_for_null_or_empty_array() {
        assertEquals("", LongestCommonPrefix.longestCommonPrefix(null));
        assertEquals("", LongestCommonPrefix.longestCommonPrefix(new String[] {}));
    }

    @Test
    void should_return_whole_word_when_only_one_element() {
        assertEquals("abc", LongestCommonPrefix.longestCommonPrefix(new String[] {"abc"}));
    }

    @Test
    void should_return_shorter_word_when_it_is_prefix_of_another() {
        assertEquals("ab", LongestCommonPrefix.longestCommonPrefix(new String[] {"ab", "abc"}));
        assertEquals("a", LongestCommonPrefix.longestCommonPrefix(new String[] {"a", "ab", "abc"}));
    }

    @Test
    void should_handle_words_that_share_only_the_first_character() {
        assertEquals("a", LongestCommonPrefix.longestCommonPrefix(new String[] {"apple", "apricot", "avocado"}));
    }
}
