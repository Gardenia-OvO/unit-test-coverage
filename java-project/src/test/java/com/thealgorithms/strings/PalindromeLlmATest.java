package com.thealgorithms.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PalindromeLlmATest {

    @Test
    void should_returnTrue_when_isPalindromeInputIsNull() {
        assertTrue(Palindrome.isPalindrome(null));
    }

    @Test
    void should_returnTrue_when_isPalindromeInputIsEmpty() {
        assertTrue(Palindrome.isPalindrome(""));
    }

    @Test
    void should_returnTrue_when_isPalindromeInputHasOneCharacter() {
        assertTrue(Palindrome.isPalindrome("a"));
    }

    @Test
    void should_returnTrue_when_isPalindromeInputIsOddLengthPalindrome() {
        assertTrue(Palindrome.isPalindrome("racecar"));
    }

    @Test
    void should_returnTrue_when_isPalindromeInputIsEvenLengthPalindrome() {
        assertTrue(Palindrome.isPalindrome("abba"));
    }

    @Test
    void should_returnFalse_when_isPalindromeInputIsNotPalindrome() {
        assertFalse(Palindrome.isPalindrome("palindrome"));
    }

    @Test
    void should_returnTrue_when_isPalindromeRecursionInputIsNull() {
        assertTrue(Palindrome.isPalindromeRecursion(null));
    }

    @Test
    void should_returnTrue_when_isPalindromeRecursionInputIsEmpty() {
        assertTrue(Palindrome.isPalindromeRecursion(""));
    }

    @Test
    void should_returnTrue_when_isPalindromeRecursionInputHasOneCharacter() {
        assertTrue(Palindrome.isPalindromeRecursion("a"));
    }

    @Test
    void should_returnTrue_when_isPalindromeRecursionInputIsOddLengthPalindrome() {
        assertTrue(Palindrome.isPalindromeRecursion("racecar"));
    }

    @Test
    void should_returnTrue_when_isPalindromeRecursionInputIsEvenLengthPalindrome() {
        assertTrue(Palindrome.isPalindromeRecursion("abba"));
    }

    @Test
    void should_returnFalse_when_isPalindromeRecursionOuterCharactersDiffer() {
        assertFalse(Palindrome.isPalindromeRecursion("abc"));
    }

    @Test
    void should_returnFalse_when_isPalindromeRecursionInnerCharactersDiffer() {
        assertFalse(Palindrome.isPalindromeRecursion("abca"));
    }

    @Test
    void should_returnTrue_when_isPalindromeTwoPointerInputIsNull() {
        assertTrue(Palindrome.isPalindromeTwoPointer(null));
    }

    @Test
    void should_returnTrue_when_isPalindromeTwoPointerInputIsEmpty() {
        assertTrue(Palindrome.isPalindromeTwoPointer(""));
    }

    @Test
    void should_returnTrue_when_isPalindromeTwoPointerInputHasOneCharacter() {
        assertTrue(Palindrome.isPalindromeTwoPointer("a"));
    }

    @Test
    void should_returnTrue_when_isPalindromeTwoPointerInputIsOddLengthPalindrome() {
        assertTrue(Palindrome.isPalindromeTwoPointer("racecar"));
    }

    @Test
    void should_returnTrue_when_isPalindromeTwoPointerInputIsEvenLengthPalindrome() {
        assertTrue(Palindrome.isPalindromeTwoPointer("abba"));
    }

    @Test
    void should_returnFalse_when_isPalindromeTwoPointerOuterCharactersDiffer() {
        assertFalse(Palindrome.isPalindromeTwoPointer("abc"));
    }

    @Test
    void should_returnFalse_when_isPalindromeTwoPointerInnerCharactersDiffer() {
        assertFalse(Palindrome.isPalindromeTwoPointer("abca"));
    }
}
