package com.thealgorithms.datastructures.stacks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

class StackOfLinkedListManualTest {

    private final LinkedListStack stack = new LinkedListStack();

    @Test
    void should_push_and_report_new_size() {
        assertTrue(stack.push(1));
        assertTrue(stack.push(2));
        assertEquals(2, stack.getSize());
    }

    @Test
    void should_pop_in_last_in_first_out_order() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
        assertEquals(0, stack.getSize());
    }

    @Test
    void should_peek_without_removing_the_top_element() {
        stack.push(7);
        stack.push(9);
        assertEquals(9, stack.peek());
        assertEquals(2, stack.getSize());
    }

    @Test
    void should_throw_when_popping_or_peeking_an_empty_stack() {
        assertThrows(NoSuchElementException.class, stack::pop);
        assertThrows(NoSuchElementException.class, stack::peek);
    }

    @Test
    void should_be_empty_after_construction_and_after_make_empty() {
        assertTrue(stack.isEmpty());
        stack.push(1);
        stack.push(2);
        assertFalse(stack.isEmpty());
        stack.makeEmpty();
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.getSize());
    }

    @Test
    void should_print_elements_from_top_to_bottom() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals("3->2->1", stack.toString());
    }

    @Test
    void should_throw_when_printing_an_empty_stack() {
        assertThrows(StringIndexOutOfBoundsException.class, stack::toString);
    }
}
