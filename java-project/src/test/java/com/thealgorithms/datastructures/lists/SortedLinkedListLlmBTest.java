package com.thealgorithms.datastructures.lists;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SortedLinkedListLlmBTest {

    @Test
    void should_returnTrue_when_listIsNew() {
        SortedLinkedList list = new SortedLinkedList();
        assertTrue(list.isEmpty());
    }

    @Test
    void should_returnFalse_when_valueIsInserted() {
        SortedLinkedList list = new SortedLinkedList();
        list.insert(1);
        assertFalse(list.isEmpty());
    }

    @Test
    void should_returnEmptyStringRepresentation_when_listIsEmpty() {
        SortedLinkedList list = new SortedLinkedList();
        assertEquals("[]", list.toString());
    }

    @Test
    void should_returnSingleValueRepresentation_when_oneValueIsInserted() {
        SortedLinkedList list = new SortedLinkedList();
        list.insert(10);
        assertEquals("[10]", list.toString());
    }

    @Test
    void should_keepAscendingOrder_when_valuesAreInsertedOutOfOrder() {
        SortedLinkedList list = new SortedLinkedList();
        list.insert(10);
        list.insert(5);
        list.insert(20);
        assertEquals("[5, 10, 20]", list.toString());
    }

    @Test
    void should_insertAtHead_when_valueIsLessThanCurrentMinimum() {
        SortedLinkedList list = new SortedLinkedList();
        list.insert(10);
        list.insert(5);
        assertEquals("[5, 10]", list.toString());
    }

    @Test
    void should_insertAtTail_when_valueIsGreaterThanCurrentMaximum() {
        SortedLinkedList list = new SortedLinkedList();
        list.insert(10);
        list.insert(20);
        assertEquals("[10, 20]", list.toString());
    }

    @Test
    void should_insertInMiddle_when_valueIsBetweenExistingValues() {
        SortedLinkedList list = new SortedLinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(15);
        assertEquals("[10, 15, 20]", list.toString());
    }

    @Test
    void should_keepDuplicateValues_when_duplicateValueIsInserted() {
        SortedLinkedList list = new SortedLinkedList();
        list.insert(5);
        list.insert(5);
        assertEquals("[5, 5]", list.toString());
    }

    @Test
    void should_returnTrue_when_searchExistingValue() {
        SortedLinkedList list = new SortedLinkedList();
        list.insert(5);
        list.insert(10);
        assertTrue(list.search(10));
    }

    @Test
    void should_returnFalse_when_searchMissingValue() {
        SortedLinkedList list = new SortedLinkedList();
        list.insert(5);
        list.insert(10);
        assertFalse(list.search(15));
    }

    @Test
    void should_returnFalse_when_searchInEmptyList() {
        SortedLinkedList list = new SortedLinkedList();
        assertFalse(list.search(1));
    }

    @Test
    void should_returnFalse_when_deleteFromEmptyList() {
        SortedLinkedList list = new SortedLinkedList();
        assertFalse(list.delete(1));
    }

    @Test
    void should_returnTrue_when_deleteExistingValue() {
        SortedLinkedList list = new SortedLinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        assertTrue(list.delete(2));
    }

    @Test
    void should_returnFalse_when_deleteMissingValue() {
        SortedLinkedList list = new SortedLinkedList();
        list.insert(1);
        list.insert(3);
        assertFalse(list.delete(2));
    }

    @Test
    void should_removeHead_when_deleteHeadValue() {
        SortedLinkedList list = new SortedLinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.delete(1);
        assertEquals("[2, 3]", list.toString());
    }

    @Test
    void should_removeMiddle_when_deleteMiddleValue() {
        SortedLinkedList list = new SortedLinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.delete(2);
        assertEquals("[1, 3]", list.toString());
    }

    @Test
    void should_removeTail_when_deleteTailValue() {
        SortedLinkedList list = new SortedLinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.delete(3);
        assertEquals("[1, 2]", list.toString());
    }

    @Test
    void should_makeListEmpty_when_deleteOnlyElement() {
        SortedLinkedList list = new SortedLinkedList();
        list.insert(1);
        list.delete(1);
        assertTrue(list.isEmpty());
    }

    @Test
    void should_removeOnlyOneOccurrence_when_deleteDuplicateValue() {
        SortedLinkedList list = new SortedLinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(2);
        list.insert(3);
        list.delete(2);
        assertEquals("[1, 2, 3]", list.toString());
    }

    @Test
    void should_keepOtherElements_when_deleteMissingValue() {
        SortedLinkedList list = new SortedLinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.delete(4);
        assertEquals("[1, 2, 3]", list.toString());
    }

    @Test
    void should_maintainSortedOrder_when_insertAfterDeletingTail() {
        SortedLinkedList list = new SortedLinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.delete(3);
        list.insert(4);
        assertEquals("[1, 2, 4]", list.toString());
    }

    @Test
    void should_returnTrue_when_allElementsAreDeleted() {
        SortedLinkedList list = new SortedLinkedList();
        list.insert(1);
        list.insert(2);
        list.delete(1);
        list.delete(2);
        assertTrue(list.isEmpty());
    }

    @Test
    void should_returnFalse_when_oneElementRemains() {
        SortedLinkedList list = new SortedLinkedList();
        list.insert(1);
        list.insert(2);
        list.delete(1);
        assertFalse(list.isEmpty());
    }

    @Test
    void should_sortNegativeValues_when_insertedOutOfOrder() {
        SortedLinkedList list = new SortedLinkedList();
        list.insert(0);
        list.insert(-5);
        list.insert(5);
        assertEquals("[-5, 0, 5]", list.toString());
    }

    @Test
    void should_sortIntegerExtremes_when_insertedOutOfOrder() {
        SortedLinkedList list = new SortedLinkedList();
        list.insert(Integer.MAX_VALUE);
        list.insert(0);
        list.insert(Integer.MIN_VALUE);
        assertEquals("[" + Integer.MIN_VALUE + ", 0, " + Integer.MAX_VALUE + "]", list.toString());
    }

    @Test
    void should_keepSortedOrder_when_manyValuesAreInserted() {
        SortedLinkedList list = new SortedLinkedList();
        list.insert(5);
        list.insert(1);
        list.insert(4);
        list.insert(2);
        list.insert(3);
        assertEquals("[1, 2, 3, 4, 5]", list.toString());
    }
}
