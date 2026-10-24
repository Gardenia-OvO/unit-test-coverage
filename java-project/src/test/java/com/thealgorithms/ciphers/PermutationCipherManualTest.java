package com.thealgorithms.ciphers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class PermutationCipherManualTest {

    private final PermutationCipher cipher = new PermutationCipher();

    @Test
    void should_encrypt_block_according_to_key_positions() {
        assertEquals("LHE", cipher.encrypt("HEL", new int[] {3, 1, 2}));
    }

    @Test
    void should_pad_short_block_before_encrypting() {
        assertEquals("LHEXLO", cipher.encrypt("HELLO", new int[] {3, 1, 2}));
    }

    @Test
    void should_remove_spaces_and_convert_to_uppercase() {
        assertEquals(cipher.encrypt("HELLO", new int[] {3, 1, 2}), cipher.encrypt(" hello ", new int[] {3, 1, 2}));
    }

    @Test
    void should_decrypt_back_to_original_text() {
        assertEquals("HELLO", cipher.decrypt("LHEXLO", new int[] {3, 1, 2}));
    }

    @Test
    void should_round_trip_longer_text() {
        int[] key = {2, 4, 1, 3};
        String plaintext = "THEQUICKBROWNFOXJUMPS";
        assertEquals(plaintext, cipher.decrypt(cipher.encrypt(plaintext, key), key));
    }

    @Test
    void should_lose_trailing_padding_character_of_plaintext() {
        // 解密时无条件删除末尾的 'X'，明文本来说明以 X 结尾时也会被吃掉，属于源码缺陷
        int[] key = {2, 4, 1, 3};
        String plaintext = "THEQUICKBROWNFOX";
        assertEquals("THEQUICKBROWNFO", cipher.decrypt(cipher.encrypt(plaintext, key), key));
    }

    @Test
    void should_return_input_unchanged_when_empty_or_null() {
        assertEquals("", cipher.encrypt("", new int[] {1}));
        assertEquals(null, cipher.encrypt(null, new int[] {1}));
        assertEquals("", cipher.decrypt("", new int[] {1}));
    }

    @Test
    void should_throw_when_key_is_invalid() {
        assertThrows(IllegalArgumentException.class, () -> cipher.encrypt("HELLO", null));
        assertThrows(IllegalArgumentException.class, () -> cipher.encrypt("HELLO", new int[] {}));
        assertThrows(IllegalArgumentException.class, () -> cipher.encrypt("HELLO", new int[] {0, 1}));
        assertThrows(IllegalArgumentException.class, () -> cipher.encrypt("HELLO", new int[] {1, 1}));
    }

    @Test
    void should_expose_padding_character() {
        assertEquals('X', cipher.getPaddingChar());
    }
}
