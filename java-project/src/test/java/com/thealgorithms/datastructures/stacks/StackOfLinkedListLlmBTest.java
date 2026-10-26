package com.thealgorithms.datastructures.stacks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

public class StackOfLinkedListLlmBTest {

    @Test
    void should_returnTrue_when_pushValue() {
        LinkedListStack stack = new LinkedListStack();

        assertTrue(stack.push(10));
    }

    @Test
    void should_increaseSizeByOne_when_pushValue() {
        LinkedListStack stack = new LinkedListStack();

        stack.push(10);

        assertEquals(1, stack.getSize());
    }

    @Test
    void should_returnTrue_when_stackIsNew() {
        LinkedListStack stack = new LinkedListStack();

        assertTrue(stack.isEmpty());
    }

    @Test
    void should_returnFalse_when_stackHasElement() {
        LinkedListStack stack = new LinkedListStack();
        stack.push(10);

        assertFalse(stack.isEmpty());
    }

    @Test
    void should_returnZeroSize_when_stackIsNew() {
        LinkedListStack stack = new LinkedListStack();

        assertEquals(0, stack.getSize());
    }

    @Test
    void should_returnTopValue_when_peekOnNonEmptyStack() {
        LinkedListStack stack = new LinkedListStack();
        stack.push(10);
        stack.push(20);

        assertEquals(20, stack.peek());
    }

    @Test
    void should_throwNoSuchElementException_when_peekOnEmptyStack() {
        LinkedListStack stack = new LinkedListStack();

        assertThrows(NoSuchElementException.class, stack::peek);
    }

    @Test
    void should_returnTopValue_when_popOnNonEmptyStack() {
        LinkedListStack stack = new LinkedListStack();
        stack.push(10);
        stack.push(20);

        assertEquals(20, stack.pop());
    }

    @Test
    void should_throwNoSuchElementException_when_popOnEmptyStack() {
        LinkedListStack stack = new LinkedListStack();

        assertThrows(NoSuchElementException.class, stack::pop);
    }

    @Test
    void should_decreaseSizeByOne_when_pop() {
        LinkedListStack stack = new LinkedListStack();
        stack.push(10);

        stack.pop();

        assertEquals(0, stack.getSize());
    }

    @Test
    void should_returnNewTopValue_when_peekAfterPop() {
        LinkedListStack stack = new LinkedListStack();
        stack.push(10);
        stack.push(20);

        stack.pop();

        assertEquals(10, stack.peek());
    }

    @Test
    void should_returnTrue_when_stackIsEmptyAfterMakeEmpty() {
        LinkedListStack stack = new LinkedListStack();
        stack.push(10);

        stack.makeEmpty();

        assertTrue(stack.isEmpty());
    }

    @Test
    void should_returnZeroSize_when_makeEmptyCalled() {
        LinkedListStack stack = new LinkedListStack();
        stack.push(10);

        stack.makeEmpty();

        assertEquals(0, stack.getSize());
    }

    @Test
    void should_returnValuesFromTopToBottom_when_toStringOnNonEmptyStack() {
        LinkedListStack stack = new LinkedListStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals("3->2->1", stack.toString());
    }
}
