package com.thealgorithms.searches;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class JumpSearchLlmBTest {

    @Test
    void should_returnIndexOfKey_when_keyIsInMiddle() {
        JumpSearch jumpSearch = new JumpSearch();
        Integer[] array = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};

        int result = jumpSearch.find(array, 9);

        assertEquals(4, result);
    }

    @Test
    void should_returnFirstIndex_when_keyIsFirstElement() {
        JumpSearch jumpSearch = new JumpSearch();
        Integer[] array = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};

        int result = jumpSearch.find(array, 1);

        assertEquals(0, result);
    }

    @Test
    void should_returnLastIndex_when_keyIsLastElement() {
        JumpSearch jumpSearch = new JumpSearch();
        Integer[] array = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};

        int result = jumpSearch.find(array, 19);

        assertEquals(9, result);
    }

    @Test
    void should_returnMinusOne_when_keyIsSmallerThanAllElements() {
        JumpSearch jumpSearch = new JumpSearch();
        Integer[] array = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};

        int result = jumpSearch.find(array, 0);

        assertEquals(-1, result);
    }

    @Test
    void should_returnMinusOne_when_keyIsLargerThanAllElements() {
        JumpSearch jumpSearch = new JumpSearch();
        Integer[] array = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};

        int result = jumpSearch.find(array, 100);

        assertEquals(-1, result);
    }

    @Test
    void should_returnMinusOne_when_keyIsAbsentBetweenElements() {
        JumpSearch jumpSearch = new JumpSearch();
        Integer[] array = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};

        int result = jumpSearch.find(array, 10);

        assertEquals(-1, result);
    }

    @Test
    void should_returnMinusOne_when_arrayIsEmpty() {
        JumpSearch jumpSearch = new JumpSearch();
        Integer[] array = {};

        int result = jumpSearch.find(array, 42);

        assertEquals(-1, result);
    }

    @Test
    void should_returnZero_when_singleElementArrayContainsKey() {
        JumpSearch jumpSearch = new JumpSearch();
        Integer[] array = {42};

        int result = jumpSearch.find(array, 42);

        assertEquals(0, result);
    }

    @Test
    void should_returnMinusOne_when_singleElementArrayDoesNotContainKey() {
        JumpSearch jumpSearch = new JumpSearch();
        Integer[] array = {42};

        int result = jumpSearch.find(array, 7);

        assertEquals(-1, result);
    }

    @Test
    void should_throwNullPointerException_when_arrayIsNull() {
        JumpSearch jumpSearch = new JumpSearch();

        assertThrows(NullPointerException.class, () -> jumpSearch.find((Integer[]) null, 1));
    }

    @Test
    void should_throwNullPointerException_when_keyIsNull() {
        JumpSearch jumpSearch = new JumpSearch();
        Integer[] array = {1, 2, 3};

        assertThrows(NullPointerException.class, () -> jumpSearch.find(array, (Integer) null));
    }
}
