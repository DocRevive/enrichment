import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SquareMatrixTest {
    private SquareMatrix matrix1;
    private SquareMatrix matrix2;

    @BeforeEach
    public void setUp() {
        matrix1 = new SquareMatrix(3);
        matrix2 = new SquareMatrix(3);

        matrix1.setMatrix(new int[][]{{0, -2, 1}, {2, 2, -4}, {3, 1, 0}});
        matrix2.setMatrix(new int[][]{{3, -5, 2}, {1, 3, 2}, {-1, 3, 3}});
    }

    @Test
    public void add() {
        SquareMatrix sum = matrix1.add(matrix2);
        int[][] expectedSum = {{3, -7, 3}, {3, 5, -2}, {2, 4, 3}};

        assertArrayEquals(expectedSum, sum.getMatrix());
    }

    @Test
    public void subtract() {
        SquareMatrix diff1 = matrix1.subtract(matrix2);
        SquareMatrix diff2 = matrix2.subtract(matrix1);
        int[][] expected1 = {{-3, 3, -1}, {1, -1, -6}, {4, -2, -3}};
        int[][] expected2 = {{3, -3, 1}, {-1, 1, 6}, {-4, 2, 3}};

        assertArrayEquals(expected1, diff1.getMatrix());
        assertArrayEquals(expected2, diff2.getMatrix());
    }

    @Test
    public void multiply() {
        SquareMatrix prod1 = matrix1.multiply(matrix2);
        SquareMatrix prod2 = matrix2.multiply(matrix1);
        int[][] expectedProd1 = {{-3, -3, -1}, {12, -16, -4}, {10, -12, 8}};
        int[][] expectedProd2 = {{-4, -14, 23}, {12, 6, -11}, {15, 11, -13}};

        assertArrayEquals(expectedProd1, prod1.getMatrix());
        assertArrayEquals(expectedProd2, prod2.getMatrix());
    }

    @Test
    public void getColumn() {
        assertArrayEquals(new int[]{-2, 2, 1}, matrix1.getColumn(1));
        assertArrayEquals(new int[]{2, 2, 3}, matrix2.getColumn(2));
    }

    @Test
    public void setColumn() {
        SquareMatrix setTest = new SquareMatrix(2);
        setTest.setColumn(1, new int[]{3, 5});

        assertArrayEquals(new int[][]{{0, 3}, {0, 5}}, setTest.getMatrix());
    }

    @Test
    public void isSquare() {
        int[][] test1 = new int[][]{{0, 0, 0}};
        int[][] test2 = new int[][]{{0, 0, 0}, {0, 0}};

        assertFalse(SquareMatrix.isSquare(test1));
        assertFalse(SquareMatrix.isSquare(test2));
        assertTrue(SquareMatrix.isSquare(matrix1.getMatrix()));
    }
}