package com.thealgorithms.maths;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DeterminantOfMatrixLlmBTest {

    @Test
    void should_returnElement_when_matrixSizeIsOne() {
        int[][] matrix = {{7}};
        assertEquals(7, DeterminantOfMatrix.determinant(matrix, 1));
    }

    @Test
    void should_returnNegativeTwo_when_matrixIsTwoByTwo() {
        int[][] matrix = {{1, 2}, {3, 4}};
        assertEquals(-2, DeterminantOfMatrix.determinant(matrix, 2));
    }

    @Test
    void should_returnZero_when_matrixIsSingular() {
        int[][] matrix = {{1, 2}, {2, 4}};
        assertEquals(0, DeterminantOfMatrix.determinant(matrix, 2));
    }

    @Test
    void should_returnSeventy_when_matrixIsUpperTriangularThreeByThree() {
        int[][] matrix = {
            {2, 3, 4},
            {0, 5, 6},
            {0, 0, 7}
        };
        assertEquals(70, DeterminantOfMatrix.determinant(matrix, 3));
    }

    @Test
    void should_returnOne_when_matrixIsIdentityThreeByThree() {
        int[][] matrix = {
            {1, 0, 0},
            {0, 1, 0},
            {0, 0, 1}
        };
        assertEquals(1, DeterminantOfMatrix.determinant(matrix, 3));
    }

    @Test
    void should_returnTwentyFour_when_matrixIsUpperTriangularFourByFour() {
        int[][] matrix = {
            {1, 2, 3, 4},
            {0, 2, 3, 4},
            {0, 0, 3, 4},
            {0, 0, 0, 4}
        };
        assertEquals(24, DeterminantOfMatrix.determinant(matrix, 4));
    }

    @Test
    void should_throwNegativeArraySizeException_when_matrixSizeIsZero() {
        assertThrows(NegativeArraySizeException.class, () -> {
            DeterminantOfMatrix.determinant(new int[][] {}, 0);
        });
    }
}
