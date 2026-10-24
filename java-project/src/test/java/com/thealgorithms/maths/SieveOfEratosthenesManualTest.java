package com.thealgorithms.maths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class SieveOfEratosthenesManualTest {

    // 正常情况：≤20 的素数，验证内容与顺序
    @Test
    void should_return_primes_in_ascending_order_when_n_is_twenty() {
        List<Integer> expected = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19);
        assertEquals(expected, SieveOfEratosthenes.findPrimes(20));
    }

    // 边界：n=2 含上界本身
    @Test
    void should_include_upper_bound_when_n_is_two() {
        assertEquals(Arrays.asList(2), SieveOfEratosthenes.findPrimes(2));
    }

    // 边界：n=3 含上界 3
    @Test
    void should_include_upper_bound_when_n_is_three() {
        assertEquals(Arrays.asList(2, 3), SieveOfEratosthenes.findPrimes(3));
    }

    // 边界：n<2 返回空列表（0 和 1 都测）
    @Test
    void should_return_empty_list_when_n_is_less_than_two() {
        assertTrue(SieveOfEratosthenes.findPrimes(0).isEmpty());
        assertTrue(SieveOfEratosthenes.findPrimes(1).isEmpty());
    }

    // 异常：负数抛 IllegalArgumentException
    @Test
    void should_throw_illegal_argument_exception_when_n_is_negative() {
        assertThrows(IllegalArgumentException.class, () -> SieveOfEratosthenes.findPrimes(-5));
    }

    // 正常 + 一致性：countPrimes 与 findPrimes().size() 应一致，用 n=50 验证
    @Test
    void should_return_same_count_from_count_primes_as_size_of_find_primes_when_n_is_fifty() {
        int n = 50;
        List<Integer> primes = SieveOfEratosthenes.findPrimes(n);
        assertEquals(primes.size(), SieveOfEratosthenes.countPrimes(n));
        // ≤50 的素数个数为 15，独立核对后写死
        assertEquals(15, primes.size());
    }
}