import java.util.Random;

/**
 * Approximation of pi with different methods.
 *
 * @author Daniel Kim
 * @version 4-9-22
 */
public class PiApproximation {
    public static void main(String[] args)
    {
        long timer = System.currentTimeMillis();
        double[] exhaustionResult = exhaustion(100000000);
        timer = System.currentTimeMillis() - timer;
        System.out.println(exhaustionResult[0] + " < pi < " + exhaustionResult[1]);
        System.out.println("Took " + timer + " ms");

        timer = System.currentTimeMillis();
        double result = series(100000000);
        timer = System.currentTimeMillis() - timer;
        System.out.println(result);
        System.out.println("Took " + timer + " ms");

        timer = System.currentTimeMillis();
        result = monteCarlo(100000000);
        timer = System.currentTimeMillis() - timer;
        System.out.println(result);
        System.out.println("Took " + timer + " ms");
    }

    /**
     * Returns the approximation using a Monte Carlo method
     * when n random samples are used. The greater n is, the
     * more accurate pi should be.
     *
     * @param  n  number of point-samples
     * @return    approximation of pi
     */
    public static double monteCarlo(int n)
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

        return pointsWithin / (double) n * 4;
    }

    /**
     * Returns the approximation using a convergent series
     * when the upper limit is n. The greater n is, the
     * more accurate pi should be.
     *
     * @param  n  upper limit of series
     * @return    approximation of pi
     */
    public static double series(int n)
    {
        /*
         * (1/6)pi^2 = nΣk (1 / k^2)
         * pi = sqrt(6(nΣk (1 / k^2)))
         */

        double sum = 0;
        for (double k = 1; k <= n; k++) {
            sum += 1 / (k*k);
        }
        return Math.sqrt(6 * sum);
    }

    /**
     * Returns the approximation with the squeeze technique used
     * by Archimedes, today known as the method of exhaustion.
     *
     * @param  n  number of sides of the regular polygon
     * @return    an array with {lower bound, upper bound} of pi
     */
    public static double[] exhaustion(int n)
    {
        /*
         * Lower bound (of pi): perimeter of inscribed (within a circle)
         * regular polygon with n sides
         * Upper bound: perimeter of circumscribed polygon
         *
         * For the inscribed polygon, each constituent isosceles
         * triangle has r as two of its side lengths. For the circumscribed
         * polygon, each has r as its altitude.
         * The base is equal to 2r * sin(pi/n) for triangles in an
         * inscribed polygon, and 2r * tan(pi/n) for those in a circumscribed
         * polygon.
         * The perimeters of the polygons are the bases * n.
         * Pi = C/d = C/(2r); For the lower bound, C > P, so pi > P/(2r),
         * and for the upper bound, C < P, so pi < P/(2r)
         */

        double innerAngleRad = 180/(double) n * 0.01745329251994329577;

        double triangleBase = Math.sin(innerAngleRad);
        double lowerBound = triangleBase * n;
        // 2r cancels in P/(2r), so omit and skip.

        triangleBase = Math.tan(innerAngleRad);
        double upperBound = triangleBase * n;

        return new double[]{ lowerBound, upperBound };
    }
}
