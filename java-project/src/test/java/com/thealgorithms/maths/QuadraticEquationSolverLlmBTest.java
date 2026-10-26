package com.thealgorithms.maths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class QuadraticEquationSolverLlmBTest {

    @Test
    public void should_return_two_real_roots_when_discriminant_positive() {
        ComplexNumber[] roots = new QuadraticEquationSolver().solveEquation(1, -5, 6);
        assertEquals(2, roots.length);
    }

    @Test
    public void should_return_first_real_root_value_when_discriminant_positive() {
        ComplexNumber[] roots = new QuadraticEquationSolver().solveEquation(1, -5, 6);
        assertEquals(3.0, roots[0].real, 0.0);
    }

    @Test
    public void should_return_second_real_root_value_when_discriminant_positive() {
        ComplexNumber[] roots = new QuadraticEquationSolver().solveEquation(1, -5, 6);
        assertEquals(2.0, roots[1].real, 0.0);
    }

    @Test
    public void should_return_null_imaginary_for_first_real_root_when_discriminant_positive() {
        ComplexNumber[] roots = new QuadraticEquationSolver().solveEquation(1, -5, 6);
        assertNull(roots[0].imaginary);
    }

    @Test
    public void should_return_null_imaginary_for_second_real_root_when_discriminant_positive() {
        ComplexNumber[] roots = new QuadraticEquationSolver().solveEquation(1, -5, 6);
        assertNull(roots[1].imaginary);
    }

    @Test
    public void should_return_one_real_root_when_discriminant_zero() {
        ComplexNumber[] roots = new QuadraticEquationSolver().solveEquation(1, -4, 4);
        assertEquals(1, roots.length);
    }

    @Test
    public void should_return_repeated_real_root_value_when_discriminant_zero() {
        ComplexNumber[] roots = new QuadraticEquationSolver().solveEquation(1, -4, 4);
        assertEquals(2.0, roots[0].real, 0.0);
    }

    @Test
    public void should_return_null_imaginary_for_repeated_real_root_when_discriminant_zero() {
        ComplexNumber[] roots = new QuadraticEquationSolver().solveEquation(1, -4, 4);
        assertNull(roots[0].imaginary);
    }

    @Test
    public void should_return_two_complex_roots_when_discriminant_negative() {
        ComplexNumber[] roots = new QuadraticEquationSolver().solveEquation(1, 2, 5);
        assertEquals(2, roots.length);
    }

    @Test
    public void should_return_real_part_for_first_complex_root_when_discriminant_negative() {
        ComplexNumber[] roots = new QuadraticEquationSolver().solveEquation(1, 2, 5);
        assertEquals(-1.0, roots[0].real, 0.0);
    }

    @Test
    public void should_return_positive_imaginary_part_for_first_complex_root_when_discriminant_negative() {
        ComplexNumber[] roots = new QuadraticEquationSolver().solveEquation(1, 2, 5);
        assertEquals(2.0, roots[0].imaginary, 0.0);
    }

    @Test
    public void should_return_real_part_for_second_complex_root_when_discriminant_negative() {
        ComplexNumber[] roots = new QuadraticEquationSolver().solveEquation(1, 2, 5);
        assertEquals(-1.0, roots[1].real, 0.0);
    }

    @Test
    public void should_return_negative_imaginary_part_for_second_complex_root_when_discriminant_negative() {
        ComplexNumber[] roots = new QuadraticEquationSolver().solveEquation(1, 2, 5);
        assertEquals(-2.0, roots[1].imaginary, 0.0);
    }
}
