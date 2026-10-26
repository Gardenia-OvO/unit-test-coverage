package com.thealgorithms.misc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MedianOfRunningArrayLlmATest {

    @Test
    void should_throwIllegalArgumentException_when_dataSetIsEmpty() {
        MedianOfRunningArray<Integer> median = new IntegerMedianOfRunningArray();

        assertThrows(IllegalArgumentException.class, median::getMedian);
    }

    @Test
    void should_returnInsertedElement_when_onlyOneElementExists() {
        MedianOfRunningArray<Integer> median = new IntegerMedianOfRunningArray();

        median.insert(42);

        assertEquals(Integer.valueOf(42), median.getMedian());
    }

    @Test
    void should_returnAverageOfTwoMiddleElements_when_elementCountIsEven() {
        MedianOfRunningArray<Integer> median = new IntegerMedianOfRunningArray();
        median.insert(40);
        median.insert(10);
        median.insert(30);
        median.insert(20);

        assertEquals(Integer.valueOf(25), median.getMedian());
    }

    @Test
    void should_returnMiddleElement_when_elementCountIsOdd() {
        MedianOfRunningArray<Integer> median = new IntegerMedianOfRunningArray();
        median.insert(7);
        median.insert(1);
        median.insert(9);
        median.insert(3);
        median.insert(5);

        assertEquals(Integer.valueOf(5), median.getMedian());
    }

    @Test
    void should_returnCorrectMedian_when_elementsContainDuplicates() {
        MedianOfRunningArray<Integer> median = new IntegerMedianOfRunningArray();
        median.insert(5);
        median.insert(5);
        median.insert(5);
        median.insert(5);

        assertEquals(Integer.valueOf(5), median.getMedian());
    }

    @Test
    void should_returnCorrectMedian_when_allElementsAreNegative() {
        MedianOfRunningArray<Integer> median = new IntegerMedianOfRunningArray();
        median.insert(-10);
        median.insert(-20);
        median.insert(-30);
        median.insert(-40);

        assertEquals(Integer.valueOf(-25), median.getMedian());
    }

    @Test
    void should_returnFractionalAverage_when_doubleElementsHaveEvenCount() {
        MedianOfRunningArray<Double> median = new DoubleMedianOfRunningArray();
        median.insert(1.0);
        median.insert(2.0);

        assertEquals(Double.valueOf(1.5), median.getMedian());
    }

    private static final class IntegerMedianOfRunningArray extends MedianOfRunningArray<Integer> {
        @Override
        protected Integer calculateAverage(final Integer a, final Integer b) {
            return (a + b) / 2;
        }
    }

    private static final class DoubleMedianOfRunningArray extends MedianOfRunningArray<Double> {
        @Override
        protected Double calculateAverage(final Double a, final Double b) {
            return (a + b) / 2.0;
        }
    }
}
