package com.thealgorithms.bitmanipulation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class BitRotateLlmBTest {

    @Test
    void should_returnSameValue_when_rotateLeftByZero() {
        assertEquals(0x12345678, BitRotate.rotateLeft(0x12345678, 0));
    }

    @Test
    void should_returnSameValue_when_rotateRightByZero() {
        assertEquals(0x12345678, BitRotate.rotateRight(0x12345678, 0));
    }

    @Test
    void should_rotateHighAndLowBitsToLowBits_when_rotateLeftByOne() {
        assertEquals(3, BitRotate.rotateLeft(0x80000001, 1));
    }

    @Test
    void should_rotateLowBitsToHighAndLowBits_when_rotateRightByOne() {
        assertEquals(0x80000001, BitRotate.rotateRight(3, 1));
    }

    @ParameterizedTest
    @CsvSource({
        "1, 1, 2",
        "2, 1, 4",
        "-1, 1, -1",
        "-2147483648, 1, 1"
    })
    void should_returnExpectedValue_when_rotateLeftByPositiveShift(int value, int shift, int expected) {
        assertEquals(expected, BitRotate.rotateLeft(value, shift));
    }

    @ParameterizedTest
    @CsvSource({
        "2, 1, 1",
        "4, 1, 2",
        "-1, 1, -1",
        "1, 1, -2147483648"
    })
    void should_returnExpectedValue_when_rotateRightByPositiveShift(int value, int shift, int expected) {
        assertEquals(expected, BitRotate.rotateRight(value, shift));
    }

    @ParameterizedTest
    @ValueSource(ints = {32, 64, 96})
    void should_returnSameValue_when_rotateLeftByMultipleOf32(int shift) {
        assertEquals(0x12345678, BitRotate.rotateLeft(0x12345678, shift));
    }

    @ParameterizedTest
    @ValueSource(ints = {32, 64, 96})
    void should_returnSameValue_when_rotateRightByMultipleOf32(int shift) {
        assertEquals(0x12345678, BitRotate.rotateRight(0x12345678, shift));
    }

    @Test
    void should_normalizeShiftModulo32_when_rotateLeftByThirtyThree() {
        assertEquals(2, BitRotate.rotateLeft(1, 33));
    }

    @Test
    void should_normalizeShiftModulo32_when_rotateRightByThirtyThree() {
        assertEquals(-2147483648, BitRotate.rotateRight(1, 33));
    }

    @Test
    void should_throwIllegalArgumentException_when_rotateLeftWithNegativeShift() {
        assertThrows(IllegalArgumentException.class, () -> BitRotate.rotateLeft(1, -1));
    }

    @Test
    void should_throwIllegalArgumentException_when_rotateRightWithNegativeShift() {
        assertThrows(IllegalArgumentException.class, () -> BitRotate.rotateRight(1, -1));
    }
}
