package com.thealgorithms.maths;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ExtendedEuclideanAlgorithmManualTest {

    // 正常情况：一般输入，验证 gcd 值
    @Test
    void should_return_correct_gcd_when_two_positive_numbers_are_given() {
        long[] result = ExtendedEuclideanAlgorithm.extendedGCD(30, 50);
        assertEquals(10, result[0]);
    }

    // 正常情况：验证贝祖等式 a*x + b*y = gcd 成立
    @Test
    void should_satisfy_bezout_identity_when_two_positive_numbers_are_given() {
        long[] result = ExtendedEuclideanAlgorithm.extendedGCD(30, 50);
        // 30*x + 50*y 应该等于 gcd
        assertEquals(30L * result[1] + 50L * result[2], result[0]);
    }

    // 边界：b = 0，应该返回 {a, 1, 0}
    @Test
    void should_return_first_argument_and_coefficients_when_second_argument_is_zero() {
        long[] result = ExtendedEuclideanAlgorithm.extendedGCD(10, 0);
        assertEquals(10, result[0]);
        assertEquals(1, result[1]);
        assertEquals(0, result[2]);
    }

    // 边界：互质，gcd = 1
    @Test
    void should_return_one_when_two_numbers_are_coprime() {
        long[] result = ExtendedEuclideanAlgorithm.extendedGCD(17, 13);
        assertEquals(1, result[0]);
    }

    // 边界：返回数组长度验证
    @Test
    void should_return_array_of_length_three_when_valid_input_is_given() {
        long[] result = ExtendedEuclideanAlgorithm.extendedGCD(240, 46);
        assertEquals(3, result.length);
    }
}