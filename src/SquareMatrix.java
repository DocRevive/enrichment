/**
 * Class that represents square matrices and provides
 * matrix operations.
 *
 * @author Daniel Kim
 * @version 4-29-22
 */
public class SquareMatrix {
    private int[][] matrix;
    private int size;

    /**
     * Constructor for an empty square matrix.
     *
     * @param  n  size of n x n matrix
     */
    public SquareMatrix(int n)
    {
        matrix = new int[n][n];
        size = n;
    }

    /**
     * Constructor for a filled square matrix.
     *
     * @param  matrix  square 2-dimensional int array
     */
    public SquareMatrix(int[][] matrix)
    {
        if (!isSquare(matrix)) {
            throw new IllegalArgumentException("Argument must be a square matrix.");
        }

        this.matrix = matrix;
        size = matrix.length;
    }

    /**
     * Returns the row at the index.
     *
     * @param  index  index of the row
     * @return        array of row entries
     */
    public int[] getRow(int index)
    {
        return matrix[index];
    }

    /**
     * Returns the column at the index.
     *
     * @param
     */
    // TODO: finish
    //   - getters & setters
    //   - multiply, add, subtract
    //   - add tests

    /**
     * Returns whether the provided matrix is a square.
     * This means that the number of entries in each row
     * is equal to the number of rows.
     *
     * @param  matrix  matrix to check
     * @return         whether it is square
     */
    public static boolean isSquare(int[][] matrix)
    {
        int numOfRows = matrix.length;

        for (int[] row : matrix) {
            if (row.length != numOfRows) return false;
        }

        return true;
    }
}
