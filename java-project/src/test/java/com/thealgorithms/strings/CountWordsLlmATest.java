package com.thealgorithms.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CountWordsLlmATest {

    @Test
    void should_returnZero_when_wordCountReceivesNull() {
        assertEquals(0, CountWords.wordCount(null));
    }

    @Test
    void should_returnZero_when_wordCountReceivesEmptyString() {
        assertEquals(0, CountWords.wordCount(""));
    }

    @Test
    void should_returnOne_when_wordCountReceivesSingleWord() {
        assertEquals(1, CountWords.wordCount("hello"));
    }

    @Test
    void should_returnFour_when_wordCountReceivesWordsSeparatedByMixedWhitespace() {
        assertEquals(4, CountWords.wordCount("  The quick\tbrown\nfox  "));
    }

    @Test
    void should_returnOne_when_wordCountReceivesPunctuationWithoutWhitespace() {
        assertEquals(1, CountWords.wordCount("hello,world"));
    }

    @Test
    void should_returnZero_when_secondaryWordCountReceivesNull() {
        assertEquals(0, CountWords.secondaryWordCount(null));
    }

    @Test
    void should_returnZero_when_secondaryWordCountReceivesEmptyString() {
        assertEquals(0, CountWords.secondaryWordCount(""));
    }

    @Test
    void should_returnZero_when_secondaryWordCountReceivesOnlySpecialCharacters() {
        assertEquals(0, CountWords.secondaryWordCount("!@#$%^&*()"));
    }

    @Test
    void should_returnTwo_when_secondaryWordCountReceivesPunctuatedWords() {
        assertEquals(2, CountWords.secondaryWordCount("Hello, world!"));
    }

    @Test
    void should_returnOne_when_secondaryWordCountReceivesWordsJoinedBySpecialCharacters() {
        assertEquals(1, CountWords.secondaryWordCount("hello@world"));
    }

    @Test
    void should_returnTwo_when_secondaryWordCountReceivesLettersAndDigits() {
        assertEquals(2, CountWords.secondaryWordCount("abc 123 !!!"));
    }
}
