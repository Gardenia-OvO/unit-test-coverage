package com.thealgorithms.datastructures.lists;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class SortedLinkedListManualTest {

    @Test
    void should_keep_elements_sorted_after_insertions_in_any_order() {
        SortedLinkedList list = new SortedLinkedList();
        list.insert(10);
        list.insert(5);
        list.insert(20);
        assertEquals("[5, 10, 20]", list.toString());
    }

    @Test
    void should_return_empty_brackets_when_list_is_empty() {
        assertEquals("[]", new SortedLinkedList().toString());
    }

    @Test
    void should_insert_new_minimum_at_head_and_new_maximum_at_tail() {
        SortedLinkedList list = new SortedLinkedList();
        list.insert(10);
        list.insert(1);
        list.insert(99);
        assertEquals("[1, 10, 99]", list.toString());
    }

    @Test
    void should_delete_head_middle_and_tail_elements() {
        SortedLinkedList list = new SortedLinkedList();
        for (int value : new int[] {4, 2, 6, 8}) {
            list.insert(value);
        }
        assertEquals("[2, 4, 6, 8]", list.toString());

        assertTrue(list.delete(2));
        assertEquals("[4, 6, 8]", list.toString());
        assertTrue(list.delete(6));
        assertEquals("[4, 8]", list.toString());
        assertTrue(list.delete(8));
        assertEquals("[4]", list.toString());
    }

    @Test
    void should_return_false_when_deleting_absent_value_or_from_empty_list() {
        SortedLinkedList list = new SortedLinkedList();
        assertFalse(list.delete(1));

        list.insert(5);
        assertFalse(list.delete(9));
        assertEquals("[5]", list.toString());
    }

    @Test
    void should_search_existing_and_missing_values() {
        SortedLinkedList list = new SortedLinkedList();
        list.insert(3);
        list.insert(7);
        assertTrue(list.search(3));
        assertTrue(list.search(7));
        assertFalse(list.search(5));
    }

    @Test
    void should_report_emptiness_after_deleting_the_only_element() {
        SortedLinkedList list = new SortedLinkedList();
        assertTrue(list.isEmpty());
        list.insert(42);
        assertFalse(list.isEmpty());
        assertTrue(list.delete(42));
        assertTrue(list.isEmpty());
    }

    @Test
    void should_accept_duplicates_and_delete_only_the_first_one() {
        SortedLinkedList list = new SortedLinkedList();
        list.insert(5);
        list.insert(5);
        assertEquals("[5, 5]", list.toString());
        assertTrue(list.delete(5));
        assertEquals("[5]", list.toString());
    }
}
