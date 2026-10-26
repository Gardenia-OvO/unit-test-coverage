package com.thealgorithms.maths;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DeterminantOfMatrixLlmATest {

    @Test
    void should_returnElement_when_matrixHasOneElement() {
        int[][] matrix = {{42}};

        assertEquals(42, DeterminantOfMatrix.determinant(matrix, 1));
    }

    @Test
    void should_returnNegativeElement_when_singleElementIsNegative() {
        int[][] matrix = {{-17}};

        assertEquals(-17, DeterminantOfMatrix.determinant(matrix, 1));
    }

    @Test
    void should_returnNegativeTwo_when_matrixIsTwoByTwo() {
        int[][] matrix = {
            {1, 2},
            {3, 4}
        };

        assertEquals(-2, DeterminantOfMatrix.determinant(matrix, 2));
    }

    @Test
    void should_returnOne_when_matrixIsThreeByThree() {
        int[][] matrix = {
            {1, 2, 3},
            {0, 1, 4},
            {5, 6, 0}
        };

        assertEquals(1, DeterminantOfMatrix.determinant(matrix, 3));
    }

    @Test
    void should_returnZero_when_matrixHasLinearlyDependentRows() {
        int[][] matrix = {
            {1, 2, 3},
            {2, 4, 6},
            {0, 1, 1}
        };

        assertEquals(0, DeterminantOfMatrix.determinant(matrix, 3));
    }

    @Test
    void should_returnZero_when_matrixContainsOnlyZeros() {
        int[][] matrix = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };

        assertEquals(0, DeterminantOfMatrix.determinant(matrix, 3));
    }

    @Test
    void should_returnOne_when_matrixIsFourByFourIdentity() {
        int[][] matrix = {
            {1, 0, 0, 0},
            {0, 1, 0, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 1}
        };

        assertEquals(1, DeterminantOfMatrix.determinant(matrix, 4));
    }

    @Test
    void should_returnProductOfDiagonal_when_matrixIsLowerTriangular() {
        int[][] matrix = {
            {2, 0, 0, 0},
            {1, 3, 0, 0},
            {4, 5, 4, 0},
            {6, 7, 8, 5}
        };

        assertEquals(120, DeterminantOfMatrix.determinant(matrix, 4));
    }
}
