package com.thealgorithms.maths.prime;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.thealgorithms.maths.Prime.PrimeCheck;
import org.junit.jupiter.api.Test;

class PrimeCheckManualTest {

    // 正常情况：最小素数 2
    @Test
    void should_return_true_when_input_is_two() {
        assertTrue(PrimeCheck.isPrime(2));
    }

    // 正常情况：普通素数
    @Test
    void should_return_true_when_input_is_prime() {
        assertTrue(PrimeCheck.isPrime(13));
        assertTrue(PrimeCheck.isPrime(97));
    }

    // 正常情况：普通合数（注意 9 和 100 都是偶数或奇数）
    @Test
    void should_return_false_when_input_is_composite() {
        assertFalse(PrimeCheck.isPrime(9));
        assertFalse(PrimeCheck.isPrime(100));
    }

    // 边界：0 和 1 不是素数
    @Test
    void should_return_false_when_input_is_zero_or_one() {
        assertFalse(PrimeCheck.isPrime(0));
        assertFalse(PrimeCheck.isPrime(1));
    }

    // 边界：负数不是素数
    @Test
    void should_return_false_when_input_is_negative() {
        assertFalse(PrimeCheck.isPrime(-7));
        assertFalse(PrimeCheck.isPrime(-2));
    }

    // 边界：平方数（容易被误判为素数）25 和 121
    @Test
    void should_return_false_when_input_is_perfect_square_greater_than_one() {
        assertFalse(PrimeCheck.isPrime(25));
        assertFalse(PrimeCheck.isPrime(121));
    }
}