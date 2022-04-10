import java.util.Random;

/**
 * Approximation of pi with a Monte Carlo method.
 *
 * @author Daniel Kim
 * @version 4-9-22
 */
public class PiApproximation {
    public static void main(String[] args)
    {
        System.out.println(approximate(100000000));
    }

    /**
     * Returns the approximation when n random samples
     * are used. The greater n is, the more accurate pi
     * should be.
     *
     * @param  n  number of point-samples
     * @return    approximation
     */
    public static double approximate(int n)
    {
        /*
         * Methodology: Generates n random points from (0,0) to
         * (1,1). The top-right quadrant of a unit circle is
         * inscribed in the 1x1 box. The ratio of points within
         * the quadrant to n is approximately pi/4, so the ratio
         * multiplied by 4 is returned.
         */
        int pointsWithin = 0;
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            // Current point
            double x = random.nextDouble();
            double y = random.nextDouble();

            /*
             * Equation of semicircle in QI & QII centered at (0,0)
             * with radius of 1: y = sqrt(1 - x^2)
             * We are in QI. If y is less than or equal to the y-value
             * of the semicircle at x, the point is in the sector.
             */
            if (y <= Math.sqrt(1 - x*x)) {
                pointsWithin++;
            }
        }

        return pointsWithin / (double)n * 4;
    }
}
