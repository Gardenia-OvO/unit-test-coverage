package com.thealgorithms.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CountWordsLlmBTest {

    @Test
    void should_returnZero_when_wordCountReceivesNull() {
        assertEquals(0, CountWords.wordCount(null));
    }

    @Test
    void should_returnZero_when_wordCountReceivesEmptyString() {
        assertEquals(0, CountWords.wordCount(""));
    }

    @ParameterizedTest
    @CsvSource({
        "hello, 1",
        "hello world, 2",
        "hello   world, 2",
        "'  hello world  ', 2"
    })
    void should_returnExpectedWordCount_when_wordCountReceivesNonEmptyString(String input, int expected) {
        assertEquals(expected, CountWords.wordCount(input));
    }

    @Test
    void should_returnOne_when_wordCountReceivesWhitespaceOnlyString() {
        assertEquals(1, CountWords.wordCount("   "));
    }

    @Test
    void should_returnZero_when_secondaryWordCountReceivesNull() {
        assertEquals(0, CountWords.secondaryWordCount(null));
    }

    @Test
    void should_returnZero_when_secondaryWordCountReceivesEmptyString() {
        assertEquals(0, CountWords.secondaryWordCount(""));
    }

    @ParameterizedTest
    @CsvSource({
        "'Hello, world!', 2",
        "'Hello,world!', 1",
        "abc 123, 2",
        "!!!, 0",
        "'!!!   ???', 1"
    })
    void should_returnExpectedWordCount_when_secondaryWordCountReceivesNonNullString(String input, int expected) {
        assertEquals(expected, CountWords.secondaryWordCount(input));
    }
}
