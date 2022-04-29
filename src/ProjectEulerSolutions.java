/**
 * Some Project Euler solutions.
 *
 * @author Daniel Kim
 * @version 3-7-22
 */

public class ProjectEulerSolutions {
    /**
     * Problem 3 - Largest prime factor. Revised for performance
     *
     * @param  n  positive integer to find largest prime factor of
     * @return    largest prime factor
     */
    public static long findLargestPrimeFactor(long n)
    {
        int factor = 2;
        long largestPrimeFactor = n;

        /*
         * While the factor is no greater than the square root of n
         * (we will have found half of all factor pairs)
         */
        while ((long) factor *factor < n) {
            // While 'factor' can divide the remaining composite factor
            while (largestPrimeFactor % factor == 0) {
                // Set largestPrimeFactor to the other half of the factor pair
                largestPrimeFactor /= factor;
            }

            if (largestPrimeFactor == 1) {
                return factor;
            } else {
                factor++;
            }
        }

        /*
         * When the while loop ends, 'largestPrimeFactor' is no longer
         * divisible by any of n's possible factors, so it is the largest
         * prime factor
         */
        return largestPrimeFactor;
    }

    /**
     * Problem 1 - Multiples of 3 or 5
     *
     * @return sum of the multiples of 3 or 5 under 1000
     */
    public static int sumMultiplesOf3or5()
    {
        int sum = 0;

        /*
         * Multiples of 3 occur most frequently, so will be
         * the limit for i (333, 333 * 3 = 999)
         */
        for (int i = 1; i < 334; i++) {
            sum += i * 3;

            // Limit for multiples of 5 is 199 (199*5 = 995)
            if (i < 200) {
                sum += i * 5;
            }

            /*
             * Limit for multiples of 15 is 66 (66*15 = 990).
             * Deals with double-counting multiples of 15 (which
             * are multiples of both 3 and 5). Each are summed twice,
             * so subtract one of each from the sum.
             */
            if (i < 67) {
                sum -= 15 * i;
            }
        }

        return sum;
    }
}
