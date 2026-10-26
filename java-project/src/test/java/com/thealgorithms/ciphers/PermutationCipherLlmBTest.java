package com.thealgorithms.ciphers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class PermutationCipherLlmBTest {

    private final PermutationCipher permutationCipher = new PermutationCipher();

    @Test
    public void should_encryptPlaintext_when_keyIsValid() {
        assertEquals("LHEXLO", permutationCipher.encrypt("HELLO", new int[]{3, 1, 2}));
    }

    @Test
    public void should_removeWhitespaceAndConvertToUpperCase_when_encrypting() {
        assertEquals("BA", permutationCipher.encrypt("a b", new int[]{2, 1}));
    }

    @Test
    public void should_padPlaintextWithPaddingChar_when_lengthIsNotMultipleOfKeyLength() {
        assertEquals("BAXC", permutationCipher.encrypt("ABC", new int[]{2, 1}));
    }

    @Test
    public void should_returnNull_when_encryptingNullPlaintext() {
        assertNull(permutationCipher.encrypt(null, new int[]{1}));
    }

    @Test
    public void should_returnEmptyString_when_encryptingEmptyPlaintext() {
        assertEquals("", permutationCipher.encrypt("", new int[]{1}));
    }

    @Test
    public void should_returnEmptyString_when_encryptingWhitespaceOnlyPlaintext() {
        assertEquals("", permutationCipher.encrypt("   ", new int[]{1}));
    }

    @Test
    public void should_decryptCiphertext_when_keyIsValid() {
        assertEquals("HELLO", permutationCipher.decrypt("LHEXLO", new int[]{3, 1, 2}));
    }

    @Test
    public void should_removePaddingFromEnd_when_decrypting() {
        assertEquals("ABC", permutationCipher.decrypt("BAXC", new int[]{2, 1}));
    }

    @Test
    public void should_returnNull_when_decryptingNullCiphertext() {
        assertNull(permutationCipher.decrypt(null, new int[]{1}));
    }

    @Test
    public void should_returnEmptyString_when_decryptingEmptyCiphertext() {
        assertEquals("", permutationCipher.decrypt("", new int[]{1}));
    }

    @Test
    public void should_returnPaddingChar_when_gettingPaddingChar() {
        assertEquals('X', permutationCipher.getPaddingChar());
    }

    @Test
    public void should_throwIllegalArgumentException_when_keyIsNull() {
        assertThrows(IllegalArgumentException.class, () -> permutationCipher.encrypt("HELLO", null));
    }

    @Test
    public void should_throwIllegalArgumentException_when_keyIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> permutationCipher.encrypt("HELLO", new int[]{}));
    }

    @Test
    public void should_throwIllegalArgumentException_when_keyContainsPositionBelowOne() {
        assertThrows(IllegalArgumentException.class, () -> permutationCipher.encrypt("HELLO", new int[]{0, 2}));
    }

    @Test
    public void should_throwIllegalArgumentException_when_keyContainsPositionAboveKeyLength() {
        assertThrows(IllegalArgumentException.class, () -> permutationCipher.encrypt("HELLO", new int[]{1, 3}));
    }

    @Test
    public void should_throwIllegalArgumentException_when_keyContainsDuplicatePosition() {
        assertThrows(IllegalArgumentException.class, () -> permutationCipher.encrypt("HELLO", new int[]{1, 1}));
    }

    @Test
    public void should_throwIllegalArgumentException_when_decryptKeyIsNull() {
        assertThrows(IllegalArgumentException.class, () -> permutationCipher.decrypt("LHEXLO", null));
    }
}
