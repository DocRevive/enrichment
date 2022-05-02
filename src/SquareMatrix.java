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
        setMatrix(matrix);
    }

    /**
     * Add another square matrix to this one.
     *
     * @param  matrix  matrix to add
     * @return         sum
     */
    public SquareMatrix add(SquareMatrix matrix)
    {
        if (matrix.getSize() != size) {
            throw new IllegalArgumentException("The matrices must have the same dimensions.");
        }

        SquareMatrix sum = new SquareMatrix(size);
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                sum.setPosition(row, column,
                        getPosition(row, column) + matrix.getPosition(row, column));
            }
        }

        return sum;
    }

    /**
     * Subtract another square matrix from this one.
     *
     * @param  matrix  matrix to subtract
     * @return         difference
     */
    public SquareMatrix subtract(SquareMatrix matrix)
    {
        if (matrix.getSize() != size) {
            throw new IllegalArgumentException("The matrices must have the same dimensions.");
        }

        SquareMatrix difference = new SquareMatrix(size);
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                difference.setPosition(row, column,
                        getPosition(row, column) - matrix.getPosition(row, column));
            }
        }

        return difference;
    }

    /**
     * Multiply another square matrix with this one.
     * Matrix multiplication is not commutative.
     *
     * @param  matrix  matrix to multiply
     * @return         product
     */
    public SquareMatrix multiply(SquareMatrix matrix)
    {
        if (matrix.getSize() != size) {
            throw new IllegalArgumentException("The matrices must have the same dimensions.");
        }

        SquareMatrix product = new SquareMatrix(size);
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                int value = 0;
                int[] currentRow = getRow(row);
                int[] currentCol = matrix.getColumn(column);

                for (int i = 0; i < size; i++) {
                    value += currentRow[i] * currentCol[i];
                }

                product.setPosition(row, column, value);
            }
        }

        return product;
    }

    /*
     * Getters
     */
    /**
     * Returns the value at a position.
     *
     * @param  row     row of value
     * @param  column  column of value
     * @return         value at position
     */
    public int getPosition(int row, int column)
    {
        return matrix[row][column];
    }

    /**
     * Returns the row at an index.
     *
     * @param  index  index of the row
     * @return        array of row entries
     */
    public int[] getRow(int index)
    {
        return matrix[index];
    }

    /**
     * Returns the column at an index.
     *
     * @param  index  index of the column
     * @return        array of column entries
     */
    public int[] getColumn(int index)
    {
        int[] column = new int[size];

        for (int i = 0; i < size; i++) {
            column[i] = matrix[i][index];
        }

        return column;
    }

    /**
     * Returns the matrix.
     *
     * @return square matrix represented by the object
     */
    public int[][] getMatrix()
    {
        return matrix;
    }

    /**
     * Returns the size of the matrix.
     *
     * @return size of square matrix
     */
    public int getSize()
    {
        return size;
    }

    /*
     * Setters
     */
    /**
     * Sets the value at a position.
     *
     * @param  row     row of new value
     * @param  column  column of new value
     * @param  value   new value
     */
    public void setPosition(int row, int column, int value)
    {
        matrix[row][column] = value;
    }

    /**
     * Sets the row at an index.
     *
     * @param  index   row to change
     * @param  newRow  new int array
     */
    public void setRow(int index, int[] newRow)
    {
        if (size != newRow.length) {
            throw new IllegalArgumentException("newRow must be the same size as the matrix.");
        }

        matrix[index] = newRow;
    }

    /**
     * Sets the column at an index.
     *
     * @param  index      column to change
     * @param  newColumn  new int array
     */
    public void setColumn(int index, int[] newColumn)
    {
        if (size != newColumn.length) {
            throw new IllegalArgumentException("newColumn must be the same size as the matrix.");
        }

        for (int i = 0; i < size; i++) {
            matrix[i][index] = newColumn[i];
        }
    }

    /**
     * Sets the matrix.
     *
     * @param  matrix  square 2-dimensional int array
     */
    public void setMatrix(int[][] matrix)
    {
        if (!isSquare(matrix)) {
            throw new IllegalArgumentException("Argument must be a square matrix.");
        }

        this.matrix = matrix;
        size = matrix.length;
    }

    /*
     * Static methods
     */
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
