package com.thealgorithms.strings;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PalindromeLlmBTest {

    @Test
    void should_returnTrue_when_isPalindromeInputIsNull() {
        assertTrue(Palindrome.isPalindrome(null));
    }

    @Test
    void should_returnTrue_when_isPalindromeInputLengthAtMostOne() {
        assertTrue(Palindrome.isPalindrome(""));
        assertTrue(Palindrome.isPalindrome("a"));
    }

    @Test
    void should_returnTrue_when_isPalindromeInputIsPalindrome() {
        assertTrue(Palindrome.isPalindrome("racecar"));
        assertTrue(Palindrome.isPalindrome("abba"));
        assertTrue(Palindrome.isPalindrome("12321"));
    }

    @Test
    void should_returnFalse_when_isPalindromeInputIsNotPalindrome() {
        assertFalse(Palindrome.isPalindrome("hello"));
        assertFalse(Palindrome.isPalindrome("abca"));
        assertFalse(Palindrome.isPalindrome("12345"));
    }

    @Test
    void should_returnTrue_when_isPalindromeRecursionInputIsNull() {
        assertTrue(Palindrome.isPalindromeRecursion(null));
    }

    @Test
    void should_returnTrue_when_isPalindromeRecursionInputLengthAtMostOne() {
        assertTrue(Palindrome.isPalindromeRecursion(""));
        assertTrue(Palindrome.isPalindromeRecursion("a"));
    }

    @Test
    void should_returnTrue_when_isPalindromeRecursionInputIsPalindrome() {
        assertTrue(Palindrome.isPalindromeRecursion("racecar"));
        assertTrue(Palindrome.isPalindromeRecursion("abba"));
        assertTrue(Palindrome.isPalindromeRecursion("12321"));
    }

    @Test
    void should_returnFalse_when_isPalindromeRecursionInputIsNotPalindrome() {
        assertFalse(Palindrome.isPalindromeRecursion("hello"));
        assertFalse(Palindrome.isPalindromeRecursion("abca"));
        assertFalse(Palindrome.isPalindromeRecursion("12345"));
    }

    @Test
    void should_returnTrue_when_isPalindromeTwoPointerInputIsNull() {
        assertTrue(Palindrome.isPalindromeTwoPointer(null));
    }

    @Test
    void should_returnTrue_when_isPalindromeTwoPointerInputLengthAtMostOne() {
        assertTrue(Palindrome.isPalindromeTwoPointer(""));
        assertTrue(Palindrome.isPalindromeTwoPointer("a"));
    }

    @Test
    void should_returnTrue_when_isPalindromeTwoPointerInputIsPalindrome() {
        assertTrue(Palindrome.isPalindromeTwoPointer("racecar"));
        assertTrue(Palindrome.isPalindromeTwoPointer("abba"));
        assertTrue(Palindrome.isPalindromeTwoPointer("12321"));
    }

    @Test
    void should_returnFalse_when_isPalindromeTwoPointerInputIsNotPalindrome() {
        assertFalse(Palindrome.isPalindromeTwoPointer("hello"));
        assertFalse(Palindrome.isPalindromeTwoPointer("abca"));
        assertFalse(Palindrome.isPalindromeTwoPointer("12345"));
    }
}
