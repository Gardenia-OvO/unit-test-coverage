package com.thealgorithms.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LongestCommonPrefixLlmATest {

    @Test
    void should_returnEmptyString_when_inputIsNull() {
        String result = LongestCommonPrefix.longestCommonPrefix(null);

        Assertions.assertEquals("", result);
    }

    @Test
    void should_returnEmptyString_when_inputArrayIsEmpty() {
        String[] input = {};

        String result = LongestCommonPrefix.longestCommonPrefix(input);

        Assertions.assertEquals("", result);
    }

    @Test
    void should_returnOriginalString_when_inputContainsSingleString() {
        String[] input = {"hello"};

        String result = LongestCommonPrefix.longestCommonPrefix(input);

        Assertions.assertEquals("hello", result);
    }

    @Test
    void should_returnFullString_when_allStringsAreIdentical() {
        String[] input = {"test", "test", "test"};

        String result = LongestCommonPrefix.longestCommonPrefix(input);

        Assertions.assertEquals("test", result);
    }

    @Test
    void should_returnCommonPrefix_when_stringsSharePrefix() {
        String[] input = {"flower", "flow", "flight"};

        String result = LongestCommonPrefix.longestCommonPrefix(input);

        Assertions.assertEquals("fl", result);
    }

    @Test
    void should_returnEmptyString_when_stringsHaveNoCommonPrefix() {
        String[] input = {"dog", "racecar", "car"};

        String result = LongestCommonPrefix.longestCommonPrefix(input);

        Assertions.assertEquals("", result);
    }

    @Test
    void should_returnShortestString_when_itIsPrefixOfOtherStrings() {
        String[] input = {"apple", "app", "application"};

        String result = LongestCommonPrefix.longestCommonPrefix(input);

        Assertions.assertEquals("app", result);
    }

    @Test
    void should_returnEmptyString_when_inputContainsEmptyString() {
        String[] input = {"apple", "", "application"};

        String result = LongestCommonPrefix.longestCommonPrefix(input);

        Assertions.assertEquals("", result);
    }
}
