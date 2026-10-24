package com.thealgorithms.bitmanipulation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class BitRotateManualTest {

    @Test
    void should_rotate_left_by_one_position() {
        assertEquals(2, BitRotate.rotateLeft(1, 1));
        assertEquals(4, BitRotate.rotateLeft(2, 1));
    }

    @Test
    void should_carry_the_leftmost_bit_back_to_the_right() {
        assertEquals(3, BitRotate.rotateLeft(0x80000001, 1));
    }

    @Test
    void should_return_same_value_when_shift_is_zero_or_full_cycle() {
        assertEquals(5, BitRotate.rotateLeft(5, 0));
        assertEquals(1, BitRotate.rotateLeft(1, 32));
        assertEquals(1, BitRotate.rotateRight(1, 0));
        assertEquals(1, BitRotate.rotateRight(1, 32));
    }

    @Test
    void should_rotate_right_by_one_position() {
        assertEquals(1, BitRotate.rotateRight(2, 1));
        assertEquals(-2147483647, BitRotate.rotateRight(3, 1));
    }

    @Test
    void should_round_trip_left_then_right() {
        int value = 0x12345678;
        assertEquals(value, BitRotate.rotateRight(BitRotate.rotateLeft(value, 7), 7));
        assertEquals(value, BitRotate.rotateLeft(BitRotate.rotateRight(value, 11), 11));
    }

    @Test
    void should_throw_when_shift_is_negative() {
        assertThrows(IllegalArgumentException.class, () -> BitRotate.rotateLeft(1, -1));
        assertThrows(IllegalArgumentException.class, () -> BitRotate.rotateRight(1, -1));
    }
}
