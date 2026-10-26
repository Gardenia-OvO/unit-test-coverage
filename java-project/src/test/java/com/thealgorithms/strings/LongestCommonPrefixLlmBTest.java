package com.thealgorithms.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LongestCommonPrefixLlmBTest {

    @Test
    void should_returnEmptyString_when_inputArrayIsNull() {
        assertEquals("", LongestCommonPrefix.longestCommonPrefix(null));
    }

    @Test
    void should_returnEmptyString_when_inputArrayIsEmpty() {
        assertEquals("", LongestCommonPrefix.longestCommonPrefix(new String[] {}));
    }

    @Test
    void should_returnFullString_when_inputArrayContainsSingleString() {
        assertEquals("abc", LongestCommonPrefix.longestCommonPrefix(new String[] {"abc"}));
    }

    @Test
    void should_returnCommonPrefix_when_allStringsSharePrefix() {
        assertEquals("fl", LongestCommonPrefix.longestCommonPrefix(new String[] {"flower", "flow", "flight"}));
    }

    @Test
    void should_returnEmptyString_when_stringsHaveNoCommonPrefix() {
        assertEquals("", LongestCommonPrefix.longestCommonPrefix(new String[] {"dog", "racecar", "car"}));
    }

    @Test
    void should_returnCommonPrefix_when_inputArrayIsUnsorted() {
        assertEquals("abc", LongestCommonPrefix.longestCommonPrefix(new String[] {"abcdef", "abc", "abczz"}));
    }

    @Test
    void should_returnEmptyString_when_anyStringIsEmpty() {
        assertEquals("", LongestCommonPrefix.longestCommonPrefix(new String[] {"abc", "", "ab"}));
    }

    @Test
    void should_returnFullString_when_allStringsAreIdentical() {
        assertEquals("same", LongestCommonPrefix.longestCommonPrefix(new String[] {"same", "same", "same"}));
    }
}
