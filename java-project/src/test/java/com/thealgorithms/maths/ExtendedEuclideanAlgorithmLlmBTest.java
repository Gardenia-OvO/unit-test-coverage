package com.thealgorithms.maths;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ExtendedEuclideanAlgorithmLlmBTest {

    @Test
    void should_returnBaseCaseResult_when_secondNumberIsZero() {
        assertArrayEquals(new long[] {12, 1, 0}, ExtendedEuclideanAlgorithm.extendedGCD(12, 0));
    }

    @Test
    void should_returnZeroGcdWithOneAndZeroCoefficients_when_bothNumbersAreZero() {
        assertArrayEquals(new long[] {0, 1, 0}, ExtendedEuclideanAlgorithm.extendedGCD(0, 0));
    }

    @ParameterizedTest
    @CsvSource({
        "30, 20, 10",
        "35, 15, 5",
        "3, 7, 1",
        "7, 13, 1",
        "240, 46, 2"
    })
    void should_returnExpectedGcd_when_inputsArePositive(long a, long b, long expectedGcd) {
        assertEquals(expectedGcd, ExtendedEuclideanAlgorithm.extendedGCD(a, b)[0]);
    }

    @Test
    void should_returnExpectedBezoutCoefficients_when_inputsAre30And20() {
        assertArrayEquals(new long[] {10, 1, -1}, ExtendedEuclideanAlgorithm.extendedGCD(30, 20));
    }

    @Test
    void should_returnExpectedBezoutCoefficients_when_inputsAre35And15() {
        assertArrayEquals(new long[] {5, 1, -2}, ExtendedEuclideanAlgorithm.extendedGCD(35, 15));
    }

    @Test
    void should_returnExpectedBezoutCoefficients_when_inputsAre3And7() {
        assertArrayEquals(new long[] {1, -2, 1}, ExtendedEuclideanAlgorithm.extendedGCD(3, 7));
    }

    @Test
    void should_returnExpectedResult_when_firstNumberIsZero() {
        assertArrayEquals(new long[] {5, 0, 1}, ExtendedEuclideanAlgorithm.extendedGCD(0, 5));
    }

    @Test
    void should_satisfyBezoutIdentity_when_inputsArePositive() {
        long a = 240;
        long b = 46;
        long[] result = ExtendedEuclideanAlgorithm.extendedGCD(a, b);

        assertEquals(result[0], a * result[1] + b * result[2]);
    }

    @Test
    void should_satisfyBezoutIdentity_when_firstNumberIsZero() {
        long a = 0;
        long b = 5;
        long[] result = ExtendedEuclideanAlgorithm.extendedGCD(a, b);

        assertEquals(result[0], a * result[1] + b * result[2]);
    }
}
