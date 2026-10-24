package com.thealgorithms.maths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class QuadraticEquationSolverManualTest {

    private final QuadraticEquationSolver solver = new QuadraticEquationSolver();

    // 正常情况：两个不同实根  x^2 - 5x + 6 = 0  → 根 2 和 3
    @Test
    void should_return_two_distinct_real_roots_when_discriminant_is_positive() {
        ComplexNumber[] roots = solver.solveEquation(1, -5, 6);
        assertEquals(2, roots.length);
        assertNull(roots[0].imaginary);
        assertNull(roots[1].imaginary);
        // 用韦达定理验证和与积，避免硬编码浮点数
        double sum = roots[0].real + roots[1].real;
        double product = roots[0].real * roots[1].real;
        assertEquals(5.0, sum, 1e-9);      // 和 = -b/a
        assertEquals(6.0, product, 1e-9);  // 积 = c/a
    }

    // 边界：两个相等实根  x^2 - 4x + 4 = 0  → 根 2（返回长度 1）
    @Test
    void should_return_single_root_when_discriminant_is_zero() {
        ComplexNumber[] roots = solver.solveEquation(1, -4, 4);
        assertEquals(1, roots.length);
        assertEquals(2.0, roots[0].real, 1e-9);
        assertNull(roots[0].imaginary);
    }

    // 边界：两个共轭复根  x^2 + 1 = 0  → 根 ±i
    @Test
    void should_return_conjugate_complex_roots_when_discriminant_is_negative() {
        ComplexNumber[] roots = solver.solveEquation(1, 0, 1);
        assertEquals(2, roots.length);
        assertEquals(0.0, roots[0].real, 1e-9);
        assertEquals(0.0, roots[1].real, 1e-9);
        assertNotNull(roots[0].imaginary);
        assertNotNull(roots[1].imaginary);
        // 虚部互为相反数
        assertEquals(roots[0].imaginary, -roots[1].imaginary, 1e-9);
    }

    // 边界：b = 0，纯二次  x^2 - 9 = 0  → 根 ±3
    @Test
    void should_return_symmetric_real_roots_when_b_is_zero() {
        ComplexNumber[] roots = solver.solveEquation(1, 0, -9);
        assertEquals(2, roots.length);
        assertEquals(3.0, Math.abs(roots[0].real), 1e-9);
        assertEquals(3.0, Math.abs(roots[1].real), 1e-9);
    }

    // 边界：c = 0，一根为 0  x^2 - 3x = 0  → 根 0 和 3
    @Test
    void should_return_zero_as_one_root_when_c_is_zero() {
        ComplexNumber[] roots = solver.solveEquation(1, -3, 0);
        assertEquals(2, roots.length);
        double product = roots[0].real * roots[1].real;
        assertEquals(0.0, product, 1e-9);
    }
}