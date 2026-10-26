package com.thealgorithms.compression;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LZ78LlmBTest {

    @Test
    void should_returnEmptyList_when_compressNull() {
        assertEquals(List.<LZ78.Token>of(), LZ78.compress(null));
    }

    @Test
    void should_returnEmptyList_when_compressEmptyString() {
        assertEquals(List.<LZ78.Token>of(), LZ78.compress(""));
    }

    @Test
    void should_returnSingleToken_when_compressSingleCharacter() {
        assertEquals(List.of(new LZ78.Token(0, 'A')), LZ78.compress("A"));
    }

    @Test
    void should_returnInitialAndEndTokens_when_compressRepeatedCharacter() {
        assertEquals(
            List.of(new LZ78.Token(0, 'A'), new LZ78.Token(1, '\0')),
            LZ78.compress("AA")
        );
    }

    @Test
    void should_returnTwoInitialTokens_when_compressTwoDifferentCharacters() {
        assertEquals(
            List.of(new LZ78.Token(0, 'A'), new LZ78.Token(0, 'B')),
            LZ78.compress("AB")
        );
    }

    @Test
    void should_useMatchingPrefixIndex_when_compressRepeatedPattern() {
        assertEquals(
            List.of(
                new LZ78.Token(0, 'A'),
                new LZ78.Token(0, 'B'),
                new LZ78.Token(1, 'B')
            ),
            LZ78.compress("ABAB")
        );
    }

    @Test
    void should_appendEndOfStreamToken_when_inputEndsWithExistingPhrase() {
        assertEquals(
            List.of(
                new LZ78.Token(0, 'A'),
                new LZ78.Token(0, 'B'),
                new LZ78.Token(1, 'B'),
                new LZ78.Token(1, '\0')
            ),
            LZ78.compress("ABABA")
        );
    }

    @Test
    void should_returnEmptyString_when_decompressNull() {
        assertEquals("", LZ78.decompress(null));
    }

    @Test
    void should_returnEmptyString_when_decompressEmptyList() {
        assertEquals("", LZ78.decompress(List.<LZ78.Token>of()));
    }

    @Test
    void should_reconstructText_when_decompressTwoInitialTokens() {
        assertEquals(
            "AB",
            LZ78.decompress(List.of(new LZ78.Token(0, 'A'), new LZ78.Token(0, 'B')))
        );
    }

    @Test
    void should_reconstructText_when_decompressTokenWithEndOfStream() {
        assertEquals(
            "AA",
            LZ78.decompress(List.of(new LZ78.Token(0, 'A'), new LZ78.Token(1, '\0')))
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"A", "AB", "AA", "ABAB", "ABABA", "ABCABC", "BANANA", "LZ78", "aaaaabbbbb"})
    void should_roundTripOriginalText_when_compressThenDecompress(String text) {
        assertEquals(text, LZ78.decompress(LZ78.compress(text)));
    }
}
