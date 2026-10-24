package com.thealgorithms.maths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class GCDManualTest {

    // 正常情况：两参数重载，普通输入
    @Test
    void should_return_six_when_two_numbers_are_twelve_and_eighteen() {
        assertEquals(6, GCD.gcd(12, 18));
    }

    // 边界：两参数重载，一个为 0
    @Test
    void should_return_other_number_when_one_argument_is_zero() {
        assertEquals(9, GCD.gcd(9, 0));
        assertEquals(9, GCD.gcd(0, 9));
    }

    // 异常：两参数重载，负数抛 ArithmeticException
    @Test
    void should_throw_arithmetic_exception_when_any_argument_is_negative() {
        assertThrows(ArithmeticException.class, () -> GCD.gcd(-4, 6));
    }

    // 正常：可变参数重载，多参数（替代了原数组测试）
    @Test
    void should_return_common_divisor_when_more_than_two_numbers_are_given() {
        assertEquals(4, GCD.gcd(8, 12, 20));
    }

    // 边界：可变参数重载，空数组返回 0（源码初始结果为0，循环不执行）
    @Test
    void should_return_zero_when_no_arguments_are_given() {
        assertEquals(0, GCD.gcd(new int[] {}));
        // 或者直接写 GCD.gcd()，因为可变参数允许空
    }

    // 正常/异常验证：可变参数中混入负数
    @Test
    void should_throw_arithmetic_exception_when_any_number_in_varargs_is_negative() {
        assertThrows(ArithmeticException.class, () -> GCD.gcd(8, -12, 20));
    }
}