package com.thealgorithms.misc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MedianOfRunningArrayLlmBTest {

    private static final class IntegerMedian extends MedianOfRunningArray<Integer> {
        @Override
        protected Integer calculateAverage(Integer a, Integer b) {
            return (a + b) / 2;
        }
    }

    private static final class DoubleMedian extends MedianOfRunningArray<Double> {
        @Override
        protected Double calculateAverage(Double a, Double b) {
            return (a + b) / 2.0;
        }
    }

    @Test
    void should_throwIllegalArgumentException_when_getMedianWithoutInsertingElements() {
        MedianOfRunningArray<Integer> median = new IntegerMedian();

        assertThrows(IllegalArgumentException.class, () -> median.getMedian());
    }

    @ParameterizedTest
    @ValueSource(ints = {-10, -1, 0, 1, 5, 42, 100})
    void should_returnInsertedElement_when_singleElementInserted(int value) {
        MedianOfRunningArray<Integer> median = new IntegerMedian();

        median.insert(value);

        assertEquals(value, median.getMedian().intValue());
    }

    @ParameterizedTest
    @CsvSource({
        "1, 3, 2",
        "2, 4, 3",
        "-1, 1, 0",
        "10, 20, 15"
    })
    void should_returnAverageOfTwoElements_when_twoElementsInserted(int first, int second, int expectedMedian) {
        MedianOfRunningArray<Integer> median = new IntegerMedian();

        median.insert(first);
        median.insert(second);

        assertEquals(expectedMedian, median.getMedian().intValue());
    }

    @Test
    void should_returnMiddleValue_when_oddNumberOfUnsortedElementsInserted() {
        MedianOfRunningArray<Integer> median = new IntegerMedian();

        median.insert(5);
        median.insert(1);
        median.insert(3);

        assertEquals(3, median.getMedian().intValue());
    }

    @Test
    void should_returnAverageOfMiddleValues_when_evenNumberOfUnsortedElementsInserted() {
        MedianOfRunningArray<Integer> median = new IntegerMedian();

        median.insert(7);
        median.insert(1);
        median.insert(3);
        median.insert(5);

        assertEquals(4, median.getMedian().intValue());
    }

    @ParameterizedTest
    @CsvSource({
        "1, 2, 3, 2",
        "1, 3, 2, 2",
        "3, 1, 2, 2",
        "2, 3, 1, 2"
    })
    void should_returnSameMedian_when_sameElementsInsertedInDifferentOrder(int first, int second, int third, int expectedMedian) {
        MedianOfRunningArray<Integer> median = new IntegerMedian();

        median.insert(first);
        median.insert(second);
        median.insert(third);

        assertEquals(expectedMedian, median.getMedian().intValue());
    }

    @Test
    void should_returnDuplicateValue_when_duplicateElementsInserted() {
        MedianOfRunningArray<Integer> median = new IntegerMedian();

        median.insert(4);
        median.insert(4);
        median.insert(4);

        assertEquals(4, median.getMedian().intValue());
    }

    @Test
    void should_returnDecimalAverage_when_evenNumberOfDoubleElementsInserted() {
        MedianOfRunningArray<Double> median = new DoubleMedian();

        median.insert(1.0);
        median.insert(2.0);

        assertEquals(1.5, median.getMedian().doubleValue());
    }
}
