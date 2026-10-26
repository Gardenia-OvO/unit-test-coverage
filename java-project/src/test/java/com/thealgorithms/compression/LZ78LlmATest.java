package com.thealgorithms.compression;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LZ78LlmATest {

    @Test
    void should_returnEmptyList_when_textIsNull() {
        assertTrue(LZ78.compress(null).isEmpty());
    }

    @Test
    void should_returnEmptyList_when_textIsEmpty() {
        assertTrue(LZ78.compress("").isEmpty());
    }

    @Test
    void should_returnEmptyString_when_compressedDataIsNull() {
        assertEquals("", LZ78.decompress(null));
    }

    @Test
    void should_returnEmptyString_when_compressedDataIsEmpty() {
        assertEquals("", LZ78.decompress(List.of()));
    }

    @Test
    void should_emitOneTokenPerCharacter_when_noPhraseIsRepeated() {
        List<LZ78.Token> expected = List.of(
            new LZ78.Token(0, 'a'),
            new LZ78.Token(0, 'b'),
            new LZ78.Token(0, 'c')
        );

        assertEquals(expected, LZ78.compress("abc"));
    }

    @Test
    void should_reuseDictionaryIndexes_when_phrasesAreRepeated() {
        List<LZ78.Token> expected = List.of(
            new LZ78.Token(0, 'a'),
            new LZ78.Token(0, 'b'),
            new LZ78.Token(1, 'b'),
            new LZ78.Token(3, 'a')
        );

        assertEquals(expected, LZ78.compress("abababa"));
    }

    @Test
    void should_emitEndOfStreamToken_when_inputEndsWithMatchedPhrase() {
        List<LZ78.Token> expected = List.of(
            new LZ78.Token(0, 'a'),
            new LZ78.Token(1, '\0')
        );

        assertEquals(expected, LZ78.compress("aa"));
    }

    @Test
    void should_reconstructDictionaryReferences_when_decompressingTokens() {
        List<LZ78.Token> tokens = List.of(
            new LZ78.Token(0, 'a'),
            new LZ78.Token(0, 'b'),
            new LZ78.Token(1, 'b'),
            new LZ78.Token(3, 'a')
        );

        assertEquals("abababa", LZ78.decompress(tokens));
    }

    @Test
    void should_appendMatchedPrefix_when_decompressingEndOfStreamToken() {
        List<LZ78.Token> tokens = List.of(
            new LZ78.Token(0, 'a'),
            new LZ78.Token(1, '\0')
        );

        assertEquals("aa", LZ78.decompress(tokens));
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "a",
        "abc",
        "aaaa",
        "abababa",
        "abcabcabc",
        "TOBEORNOTTOBEORTOBEORNOT",
        "The quick brown fox jumps over the lazy dog",
        "你好，世界！你好，世界！"
    })
    void should_restoreOriginalText_when_compressedDataIsDecompressed(String text) {
        assertEquals(text, LZ78.decompress(LZ78.compress(text)));
    }
}
