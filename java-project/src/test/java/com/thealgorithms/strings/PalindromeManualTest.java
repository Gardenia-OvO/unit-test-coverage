package com.thealgorithms.strings;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class PalindromeManualTest {

    @Test
    void should_return_true_for_palindromic_word() {
        assertTrue(Palindrome.isPalindrome("racecar"));
        assertTrue(Palindrome.isPalindromeRecursion("racecar"));
        assertTrue(Palindrome.isPalindromeTwoPointer("racecar"));
    }

    @Test
    void should_return_false_for_non_palindromic_word() {
        assertFalse(Palindrome.isPalindrome("abcdef"));
        assertFalse(Palindrome.isPalindromeRecursion("abcdef"));
        assertFalse(Palindrome.isPalindromeTwoPointer("abcdef"));
    }

    @Test
    void should_treat_empty_single_char_and_null_as_palindrome() {
        assertTrue(Palindrome.isPalindrome(""));
        assertTrue(Palindrome.isPalindrome("a"));
        assertTrue(Palindrome.isPalindrome(null));
        assertTrue(Palindrome.isPalindromeTwoPointer(null));
        assertTrue(Palindrome.isPalindromeRecursion(null));
    }

    @Test
    void should_be_case_sensitive() {
        assertFalse(Palindrome.isPalindrome("Racecar"));
        assertTrue(Palindrome.isPalindrome("RacecaR"));
    }

    @Test
    void should_handle_even_length_palindrome() {
        assertTrue(Palindrome.isPalindrome("abba"));
        assertTrue(Palindrome.isPalindromeTwoPointer("abba"));
        assertTrue(Palindrome.isPalindromeRecursion("abba"));
    }

    @Test
    void should_give_same_answer_from_all_three_implementations() {
        String[] samples = {"a", "ab", "aba", "abba", "abcba", "abca", ""};
        for (String sample : samples) {
            boolean expected = Palindrome.isPalindrome(sample);
            assertTrue(expected == Palindrome.isPalindromeRecursion(sample), "recursion differs on " + sample);
            assertTrue(expected == Palindrome.isPalindromeTwoPointer(sample), "two-pointer differs on " + sample);
        }
    }
}
