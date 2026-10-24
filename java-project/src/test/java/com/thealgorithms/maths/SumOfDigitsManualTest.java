package com.thealgorithms.maths;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SumOfDigitsManualTest {

    // 正常情况：普通正整数，三个方法都验证
    @Test
    void should_return_sum_of_digits_when_input_is_positive() {
        assertEquals(9, SumOfDigits.sumOfDigits(234));
        assertEquals(9, SumOfDigits.sumOfDigitsRecursion(234));
        assertEquals(9, SumOfDigits.sumOfDigitsFast(234));
    }

    // 边界：0
    @Test
    void should_return_zero_when_input_is_zero() {
        assertEquals(0, SumOfDigits.sumOfDigits(0));
    }

    // 边界：负数取绝对值
    @Test
    void should_return_sum_of_absolute_digits_when_input_is_negative() {
        assertEquals(6, SumOfDigits.sumOfDigits(-123));
        assertEquals(6, SumOfDigits.sumOfDigitsRecursion(-123));
        assertEquals(6, SumOfDigits.sumOfDigitsFast(-123));
    }

    // 边界：单数字（个位数）
    @Test
    void should_return_itself_when_input_is_single_digit() {
        assertEquals(7, SumOfDigits.sumOfDigits(7));
        assertEquals(7, SumOfDigits.sumOfDigitsRecursion(7));
        assertEquals(7, SumOfDigits.sumOfDigitsFast(7));
    }

    // 边界：含 0 的数字，验证 0 不影响和
    @Test
    void should_ignore_zeros_when_digits_contain_zero() {
        assertEquals(3, SumOfDigits.sumOfDigits(1020));
        assertEquals(3, SumOfDigits.sumOfDigitsRecursion(1020));
        assertEquals(3, SumOfDigits.sumOfDigitsFast(1020));
    }

    // 一致性：三个方法对同一输入结果必须相同
    @Test
    void should_return_same_result_across_three_implementations_for_same_input() {
        int input = 98765;
        int a = SumOfDigits.sumOfDigits(input);
        int b = SumOfDigits.sumOfDigitsRecursion(input);
        int c = SumOfDigits.sumOfDigitsFast(input);
        assertEquals(a, b);
        assertEquals(b, c);
    }
}