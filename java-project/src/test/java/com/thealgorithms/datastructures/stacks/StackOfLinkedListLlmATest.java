package com.thealgorithms.datastructures.stacks;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StackOfLinkedListLlmATest {

    private LinkedListStack stack;

    @BeforeEach
    void setUp() {
        stack = new LinkedListStack();
    }

    @Test
    void should_returnZero_when_gettingSizeOfNewStack() {
        assertEquals(0, stack.getSize());
    }

    @Test
    void should_returnTrue_when_checkingIfNewStackIsEmpty() {
        assertTrue(stack.isEmpty());
    }

    @Test
    void should_returnTrue_when_pushingAnElement() {
        assertTrue(stack.push(10));
    }

    @Test
    void should_increaseSizeByOne_when_pushingAnElement() {
        stack.push(10);

        assertEquals(1, stack.getSize());
    }

    @Test
    void should_returnFalse_when_checkingIfNonEmptyStackIsEmpty() {
        stack.push(10);

        assertFalse(stack.isEmpty());
    }

    @Test
    void should_returnLastPushedElement_when_peeking() {
        stack.push(10);
        stack.push(20);

        assertEquals(20, stack.peek());
    }

    @Test
    void should_keepSizeUnchanged_when_peeking() {
        stack.push(10);
        stack.push(20);

        stack.peek();

        assertEquals(2, stack.getSize());
    }

    @Test
    void should_returnLastPushedElement_when_popping() {
        stack.push(10);
        stack.push(20);

        assertEquals(20, stack.pop());
    }

    @Test
    void should_decreaseSizeByOne_when_popping() {
        stack.push(10);
        stack.push(20);

        stack.pop();

        assertEquals(1, stack.getSize());
    }

    @Test
    void should_returnElementsInLifoOrder_when_poppingRepeatedly() {
        stack.push(10);
        stack.push(20);
        stack.push(30);

        assertEquals(30, stack.pop());
        assertEquals(20, stack.pop());
        assertEquals(10, stack.pop());
    }

    @Test
    void should_throwNoSuchElementException_when_poppingEmptyStack() {
        assertThrows(NoSuchElementException.class, () -> stack.pop());
    }

    @Test
    void should_throwNoSuchElementException_when_peekingEmptyStack() {
        assertThrows(NoSuchElementException.class, () -> stack.peek());
    }

    @Test
    void should_formatElementsFromTopToBottom_when_convertingToString() {
        stack.push(10);
        stack.push(20);
        stack.push(30);

        assertEquals("30->20->10", stack.toString());
    }

    @Test
    void should_markStackAsEmpty_when_makeEmptyIsCalled() {
        stack.push(10);
        stack.push(20);

        stack.makeEmpty();

        assertTrue(stack.isEmpty());
    }

    @Test
    void should_resetSizeToZero_when_makeEmptyIsCalled() {
        stack.push(10);
        stack.push(20);

        stack.makeEmpty();

        assertEquals(0, stack.getSize());
    }

    @Test
    void should_containOnlyNewElement_when_pushingAfterMakeEmpty() {
        stack.push(10);
        stack.makeEmpty();

        stack.push(20);

        assertEquals("20", stack.toString());
    }
}
