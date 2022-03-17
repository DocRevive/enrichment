
/**
 * Project Euler 85
 * Given an mxn grid, determines how many rectangles or squares
 * can be found within it.
 *
 * @author Daniel Kim
 * @version 2-18-22
 */
public class GridRectCounter
{
    // m & n are positive integers
    private int m;
    private int n;

    /**
     * Empty constructor for a grid
     */
    public GridRectCounter()
    {}

    /**
     * Overloaded constructor for a grid
     *
     * @param  m  length of grid
     * @param  n  width of grid
     */
    public GridRectCounter(int m, int n)
    {
        this.m = m;
        this.n = n;
    }

    /*
     * Accessors
     */
    /**
     * Determines how many rectangles can be found in the grid
     *
     * @return number of rectangles
     */
    public long countRectangles()
    {
        long currentWidth = m;
        long rectSum = 0;
        /*
         * All adjacent/singular groups/rows counted using formula for
         * nth triangular number (1+2+3+...+n). This counts the number
         * of full-width rectangles, or the number of "row-rectangles",
         * disregarding the height of the grid.
         */
        int numRowRects = n*(n+1)/2;

        do {
            rectSum += numRowRects * (currentWidth*2 - 1);
            currentWidth -= 2;
        } while (currentWidth > 0);
        /*
         * A full-width rectangle 2 squares long and of a fixed height has 3
         * rectangles (width*2 - 1). Multiply the number of possible full-width
         * rectangles (numRowRects) by 3 and the count is complete. Identically,
         * a full-width, fixed-height rectangle 1 square wide (m = 1) has 1
         * rectangle (1*2 - 1). numRowRects is the total count.
         *
         * However, m*2 - 1 doesn't hold when m > 2 because rectangles appear
         * in the center (not touching left or right edge), which are uncounted.
         * A full-width, fixed-height rectangle 3 squares wide has 6 rectangles.
         * Instead of being 3*2 - 1 = 5, it has one square in the center, which
         * must be counted.
         *
         * m*2 - 1 appropriately counts all rectangles that touch the edge.
         * If one column on each side of the whole rectangle was stripped (-= 2),
         * the center, uncounted rectangles would be left, with which the number
         * of rectangles touching the new, exposed edge, can again be counted
         * and added to a running total. The solution is to continue stripping
         * the edges until the grid is 1 or 2 units wide, thus when all center
         * rectangles have been accounted for.
         */

        return rectSum;
    }

    /**
     * Determines how many squares can be found in the grid
     *
     * @return number of squares
     */
    public long countSquares()
    {
        // To simplify code, determine length & width
        int length = Math.max(m, n);
        int width = Math.min(m, n);
        long squaresInRow = length;
        long squareSum = 0;

        /*
         * squaresInColumn denotes the number of squares of a particular
         * size that can fit in the rectangle's width. squaresInRow denotes
         * the number of squares of the same size that can fit in its length.
         * For example, if the rectangle was 6x4:
         * Dims   squaresInRow   squaresInColumn
         * 1x1    6              4
         * 2x2    5              3
         * 3x3    4              2
         *
         * squaresInRow is initialized as the length of the rectangle,
         * meaning the smallest squares (individual grid boxes) are counted
         * first. squaresInColumn is initialized as the width, the number
         * of rows, to be first multiplied with squaresInRow to get the
         * number of 1x1 squares.
         *
         * squaresInRow and squaresInColumn decrement together, counting 2x2
         * squares, 3x3, etc. After squaresInColumn reaches 1, meaning these
         * squares take up the entire width of the rectangle and there are no
         * larger squares, and since 'length' has been standardized to the
         * longest side of the rectangle, the count is finished.
         */
        for (int squaresInColumn = width; squaresInColumn > 0; squaresInColumn--) {
            squareSum += squaresInRow * squaresInColumn;
            squaresInRow--;
        }

        return squareSum;
    }

    /**
     * Gets m
     *
     * @return width of grid
     */
    public int getM()
    {
        return m;
    }

    /**
     * Gets n
     *
     * @return width of grid
     */
    public int getN()
    {
        return n;
    }

    /*
     * Mutators
     */
    /**
     * Sets m
     *
     * @param  m  length of grid
     */
    public void setM(int m)
    {
        this.m = m;
    }

    /**
     * Sets n
     *
     * @param  n  width of grid
     */
    public void setN(int n)
    {
        this.n = n;
    }
}