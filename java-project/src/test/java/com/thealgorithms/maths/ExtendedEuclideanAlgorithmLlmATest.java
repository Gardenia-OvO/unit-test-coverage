package com.thealgorithms.maths;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExtendedEuclideanAlgorithmLlmATest {

    @Test
    void should_returnBaseCaseResult_whenSecondNumberIsZero() {
        long[] result = ExtendedEuclideanAlgorithm.extendedGCD(42, 0);

        Assertions.assertArrayEquals(new long[] {42, 1, 0}, result);
    }

    @Test
    void should_returnZeroBaseCaseResult_whenBothNumbersAreZero() {
        long[] result = ExtendedEuclideanAlgorithm.extendedGCD(0, 0);

        Assertions.assertArrayEquals(new long[] {0, 1, 0}, result);
    }

    @Test
    void should_returnGcdWithZeroAndOneCoefficients_whenFirstNumberIsZero() {
        long[] result = ExtendedEuclideanAlgorithm.extendedGCD(0, 5);

        Assertions.assertArrayEquals(new long[] {5, 0, 1}, result);
    }

    @Test
    void should_returnGcdAndBezoutCoefficients_whenNumbersHaveCommonDivisor() {
        long[] result = ExtendedEuclideanAlgorithm.extendedGCD(240, 46);

        Assertions.assertArrayEquals(new long[] {2, -9, 47}, result);
    }

    @Test
    void should_returnGcdAndBezoutCoefficients_whenNumbersAreCoprime() {
        long[] result = ExtendedEuclideanAlgorithm.extendedGCD(35, 64);

        Assertions.assertArrayEquals(new long[] {1, 11, -6}, result);
    }

    @Test
    void should_returnCorrectCoefficients_whenFirstNumberIsSmallerThanSecondNumber() {
        long[] result = ExtendedEuclideanAlgorithm.extendedGCD(46, 240);

        Assertions.assertArrayEquals(new long[] {2, 47, -9}, result);
    }

    @Test
    void should_returnNumberAsGcd_whenBothNumbersAreEqualAndNonZero() {
        long[] result = ExtendedEuclideanAlgorithm.extendedGCD(12, 12);

        Assertions.assertArrayEquals(new long[] {12, 0, 1}, result);
    }

    @Test
    void should_returnCorrectResult_whenInputsExceedIntegerRange() {
        long[] result = ExtendedEuclideanAlgorithm.extendedGCD(4_000_000_000L, 6_000_000_000L);

        Assertions.assertArrayEquals(new long[] {2_000_000_000L, -1, 1}, result);
    }
}
