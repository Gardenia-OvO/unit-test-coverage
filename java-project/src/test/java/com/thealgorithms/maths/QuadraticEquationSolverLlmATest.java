package com.thealgorithms.maths;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuadraticEquationSolverLlmATest {

    private static final double DELTA = 1.0e-9;

    private final QuadraticEquationSolver solver = new QuadraticEquationSolver();

    @Test
    void should_returnTwoDistinctRealRoots_when_discriminantIsPositive() {
        ComplexNumber[] roots = solver.solveEquation(2.0, -6.0, 4.0);

        Assertions.assertEquals(2, roots.length);
        Assertions.assertEquals(2.0, roots[0].real.doubleValue(), DELTA);
        Assertions.assertEquals(1.0, roots[1].real.doubleValue(), DELTA);
        Assertions.assertNull(roots[0].imaginary);
        Assertions.assertNull(roots[1].imaginary);
    }

    @Test
    void should_returnOneRepeatedRealRoot_when_discriminantIsZero() {
        ComplexNumber[] roots = solver.solveEquation(2.0, 4.0, 2.0);

        Assertions.assertEquals(1, roots.length);
        Assertions.assertEquals(-1.0, roots[0].real.doubleValue(), DELTA);
        Assertions.assertNull(roots[0].imaginary);
    }

    @Test
    void should_returnTwoConjugateComplexRoots_when_discriminantIsNegative() {
        ComplexNumber[] roots = solver.solveEquation(2.0, 2.0, 1.0);

        Assertions.assertEquals(2, roots.length);
        Assertions.assertEquals(-0.5, roots[0].real.doubleValue(), DELTA);
        Assertions.assertEquals(0.5, roots[0].imaginary.doubleValue(), DELTA);
        Assertions.assertEquals(-0.5, roots[1].real.doubleValue(), DELTA);
        Assertions.assertEquals(-0.5, roots[1].imaginary.doubleValue(), DELTA);
    }

    @Test
    void should_returnNoRoots_when_discriminantIsNaN() {
        ComplexNumber[] roots = solver.solveEquation(Double.NaN, 1.0, 1.0);

        Assertions.assertEquals(0, roots.length);
    }
}
