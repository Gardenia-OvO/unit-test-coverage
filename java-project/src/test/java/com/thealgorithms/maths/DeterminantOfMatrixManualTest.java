package com.thealgorithms.maths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class DeterminantOfMatrixManualTest {

    // 正常情况：2x2 矩阵
    @Test
    void should_return_negative_two_when_matrix_is_two_by_two() {
        int[][] matrix = {{1, 2}, {3, 4}};
        assertEquals(-2, DeterminantOfMatrix.determinant(matrix, 2));
    }

    // 正常情况：3x3 矩阵（非奇异）
    @Test
    void should_return_one_when_three_by_three_matrix_is_given() {
        int[][] matrix = {{1, 2, 3}, {0, 1, 4}, {5, 6, 0}};
        assertEquals(1, DeterminantOfMatrix.determinant(matrix, 3));
    }

    // 边界：1x1 矩阵
    @Test
    void should_return_element_itself_when_matrix_is_one_by_one() {
        int[][] matrix = {{7}};
        assertEquals(7, DeterminantOfMatrix.determinant(matrix, 1));
    }

    // 边界：奇异矩阵行列式为 0
    @Test
    void should_return_zero_when_matrix_rows_are_linearly_dependent() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        assertEquals(0, DeterminantOfMatrix.determinant(matrix, 3));
    }

    // 异常情况：传入 null 矩阵（源码未做判空，应抛 NPE）
    @Test
    void should_throw_null_pointer_exception_when_matrix_is_null() {
        assertThrows(NullPointerException.class, () -> DeterminantOfMatrix.determinant(null, 2));
    }
}