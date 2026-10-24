package com.thealgorithms.maths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigInteger;
import org.junit.jupiter.api.Test;

class FibonacciLoopManualTest {

    // 正常情况：基础值 n=0
    @Test
    void should_return_zero_when_n_is_zero() {
        assertEquals(BigInteger.ZERO, FibonacciLoop.compute(0));
    }

    // 正常情况：n=10 的确定值，独立算好写死
    @Test
    void should_return_fifty_five_when_n_is_ten() {
        assertEquals(BigInteger.valueOf(55), FibonacciLoop.compute(10));
    }

    // 边界：n=1 返回 1
    @Test
    void should_return_one_when_n_is_one() {
        assertEquals(BigInteger.ONE, FibonacciLoop.compute(1));
    }

    // 边界：较大 n，验证 BigInteger 不溢出（n=50，F(50)=12586269025）
    @Test
    void should_return_large_value_without_overflow_when_n_is_fifty() {
        assertEquals(new BigInteger("12586269025"), FibonacciLoop.compute(50));
    }

    // 异常情况：负数抛 IllegalArgumentException
    @Test
    void should_throw_illegal_argument_exception_when_n_is_negative() {
        assertThrows(IllegalArgumentException.class, () -> FibonacciLoop.compute(-1));
    }
}