package com.thealgorithms.datastructures.lists;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SortedLinkedListLlmATest {

    @Test
    void should_beEmpty_when_listIsCreated() {
        SortedLinkedList list = new SortedLinkedList();

        assertTrue(list.isEmpty());
    }

    @Test
    void should_notBeEmpty_when_valueIsInserted() {
        SortedLinkedList list = new SortedLinkedList();

        list.insert(10);

        assertFalse(list.isEmpty());
    }

    @Test
    void should_beEmpty_when_lastElementIsDeleted() {
        SortedLinkedList list = createList(7);

        list.delete(7);

        assertTrue(list.isEmpty());
    }

    @Test
    void should_maintainSortedOrder_when_valuesAreInsertedInArbitraryOrder() {
        SortedLinkedList list = createList(10, 5, 20, 15, 1, 25);

        assertEquals("[1, 5, 10, 15, 20, 25]", list.toString());
    }

    @Test
    void should_preserveDuplicateValues_when_duplicateValuesAreInserted() {
        SortedLinkedList list = createList(10, 5, 20, 10, 5);

        assertEquals("[5, 5, 10, 10, 20]", list.toString());
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 10, 20})
    void should_returnTrue_when_searchingForExistingValue(int value) {
        SortedLinkedList list = createList(10, 5, 20);

        assertTrue(list.search(value));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 15, 30})
    void should_returnFalse_when_searchingForMissingValue(int value) {
        SortedLinkedList list = createList(10, 5, 20);

        assertFalse(list.search(value));
    }

    @Test
    void should_returnFalse_when_searchingInEmptyList() {
        SortedLinkedList list = new SortedLinkedList();

        assertFalse(list.search(10));
    }

    @Test
    void should_returnFalse_when_deletingFromEmptyList() {
        SortedLinkedList list = new SortedLinkedList();

        assertFalse(list.delete(10));
    }

    @Test
    void should_returnFalse_when_deletingMissingValue() {
        SortedLinkedList list = createList(1, 2, 3);

        assertFalse(list.delete(4));
    }

    @Test
    void should_returnTrue_when_deletingExistingValue() {
        SortedLinkedList list = createList(1, 2, 3);

        assertTrue(list.delete(2));
    }

    @Test
    void should_keepListUnchanged_when_deletingMissingValue() {
        SortedLinkedList list = createList(1, 2, 3);

        list.delete(4);

        assertEquals("[1, 2, 3]", list.toString());
    }

    @Test
    void should_removeHead_when_headValueIsDeleted() {
        SortedLinkedList list = createList(1, 2, 3);

        list.delete(1);

        assertEquals("[2, 3]", list.toString());
    }

    @Test
    void should_removeMiddleElement_when_middleValueIsDeleted() {
        SortedLinkedList list = createList(1, 2, 3);

        list.delete(2);

        assertEquals("[1, 3]", list.toString());
    }

    @Test
    void should_removeTail_when_tailValueIsDeleted() {
        SortedLinkedList list = createList(1, 2, 3);

        list.delete(3);

        assertEquals("[1, 2]", list.toString());
    }

    @Test
    void should_removeOnlyFirstOccurrence_when_duplicateValueIsDeleted() {
        SortedLinkedList list = createList(1, 2, 2, 3);

        list.delete(2);

        assertEquals("[1, 2, 3]", list.toString());
    }

    @Test
    void should_appendCorrectly_when_valueIsInsertedAfterTailDeletion() {
        SortedLinkedList list = createList(1, 2, 3);

        list.delete(3);
        list.insert(4);

        assertEquals("[1, 2, 4]", list.toString());
    }

    @Test
    void should_formatAsEmptyBrackets_when_listIsEmpty() {
        SortedLinkedList list = new SortedLinkedList();

        assertEquals("[]", list.toString());
    }

    @Test
    void should_formatElementsAsCommaSeparatedList_when_listContainsElements() {
        SortedLinkedList list = createList(3, 1, 2);

        assertEquals("[1, 2, 3]", list.toString());
    }

    private SortedLinkedList createList(int... values) {
        SortedLinkedList list = new SortedLinkedList();
        for (int value : values) {
            list.insert(value);
        }
        return list;
    }
}
