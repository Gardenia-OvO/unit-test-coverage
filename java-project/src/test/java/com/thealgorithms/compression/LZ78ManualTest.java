package com.thealgorithms.compression;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.junit.jupiter.api.Test;

class LZ78ManualTest {

    @Test
    void should_produce_one_token_per_new_character() {
        List<LZ78.Token> tokens = LZ78.compress("AB");
        assertEquals(2, tokens.size());
        assertEquals(0, tokens.get(0).index());
        assertEquals('A', tokens.get(0).nextChar());
        assertEquals(0, tokens.get(1).index());
        assertEquals('B', tokens.get(1).nextChar());
    }

    @Test
    void should_emit_end_of_stream_token_for_trailing_repeated_phrase() {
        List<LZ78.Token> tokens = LZ78.compress("AA");
        assertEquals(2, tokens.size());
        assertEquals(1, tokens.get(1).index());
        assertEquals('\u0000', tokens.get(1).nextChar());
    }

    @Test
    void should_return_empty_list_for_empty_or_null_input() {
        assertTrue(LZ78.compress("").isEmpty());
        assertTrue(LZ78.compress(null).isEmpty());
    }

    @Test
    void should_decompress_empty_or_null_input_to_empty_string() {
        assertEquals("", LZ78.decompress(null));
        assertEquals("", LZ78.decompress(List.of()));
    }

    @Test
    void should_round_trip_simple_text() {
        String text = "ABABABA";
        assertEquals(text, LZ78.decompress(LZ78.compress(text)));
    }

    @Test
    void should_round_trip_text_with_repeated_and_unique_parts() {
        String[] samples = {"A", "AAAA", "ABCDEF", "TOBEORNOTTOBE", "BANANA_BANDANA"};
        for (String sample : samples) {
            assertEquals(sample, LZ78.decompress(LZ78.compress(sample)), "sample = " + sample);
        }
    }

    @Test
    void should_compress_shorter_than_original_for_repetitive_text() {
        String text = "ABABABABABABABABABAB";
        assertTrue(LZ78.compress(text).size() < text.length());
    }
}
