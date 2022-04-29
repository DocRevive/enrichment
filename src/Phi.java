import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.FileWriter;

/**
 * Enrichment #3: phi(n): the number of integers k
 * such that 1 <= k <= n and the GCF of n and k is 1
 *
 * @author Daniel Kim
 * @version 3-16-22
 */
public class Phi {
    /**
     * Computes and stores all phi(n) from 1 to 1,000,000
     */
    public static void main(String[] args)
    {
        int n = 1000000;
        int[] phiTo1Million = new int[n + 1];
        StringBuilder output = new StringBuilder();

        long startTime = System.currentTimeMillis();
        for (int i = 1; i <= n; i++) {
            phiTo1Million[i] = phi(i);
            output.append(phiTo1Million[i]).append("\n");
        }
        long endTime = System.currentTimeMillis();

        System.out.println((endTime - startTime) + "ms");
        System.out.println("Done, writing...");

        try {
            FileWriter outputFile = new FileWriter("C:\\Users\\dnk14\\IdeaProjects\\Enrichment\\phi.txt");
            outputFile.write(output.toString());
            outputFile.close();
        } catch (IOException error) {
            System.out.println("Something went wrong");
            error.printStackTrace();
        }

        System.out.println("Done!");
    }

    /**
     * The number of integers k such that 1 <= k <= n
     * and the GCF of n and k is 1
     *
     * @param  n  positive integer >= 1
     * @return    number of k's that fit the conditions
     */
    public static int phi(int n)
    {
        double product = n;
        int[] primeFBases = primeFBases(primeFactorization(n));

        /*
         * Instead of looping through millions of k's, which is
         * still expensive, it uses Euler's product formula to
         * skip the k-loop. Still needs prime factors but takes
         * 5 seconds instead of 1 hour
         *
         * phi(n) = n(1-(1/p1))(1-(1/p2))...(1-(1/pr))
         * where p1,...,pr are unique prime factors of n
         */

        for (int factor : primeFBases) {
            product *= (1.0 - 1.0/factor);
        }

        return (int) product;
    }

    /**
     * Slower 2nd-try method
     *
     * @param  n  positive integer >= 1
     * @return    number of k's that fit the conditions
     */
    public static int phiOld(int n)
    {
        int k;
        int numK = 0;
        int[] primeFBases = primeFBases(primeFactorization(n));

        /*
         * Instead of calculating gcf(n, k), which gets expensive,
         * it gets n's unique prime factors once and checks if any
         * evenly divide k. If none do, the gcf is 1.
         */

        eachK:
        for (k = 1; k < n; k++) {
            // For each prime factor
            for (int factor : primeFBases) {
                // If it's also a factor of k
                if (k % factor == 0) {
                    // Continue outer loop
                    continue eachK;
                }
            }
            // If none were a factor of k, the gcf is 1, so it's counted.
            numK++;
        }

        return numK;
    }

    /**
     * Calculates the prime factorization of an integer > 1
     *
     * @param  n  number to find prime factorization of
     * @return    prime factorization
     */
    public static Integer[] primeFactorization(int n)
    {
        /*
         * Same as ProjectEulerSolutions.largestPrimeFactor() but
         * saves factors and handles smaller largest prime factors
         */
        if (n < 2) return new Integer[0];

        int factor = 2;
        int remainingFactor = n;
        ArrayList<Integer> primeF = new ArrayList<>();

        /*
         * While the factor is no greater than the square root of n
         * (we will have found half of all factor pairs)
         */
        while (factor*factor < n && factor != 1) {
            // While 'factor' can divide the remaining composite factor
            while (remainingFactor % factor == 0) {
                // Set remainingFactor to the other factor in the factor pair
                remainingFactor /= factor;
                /*
                 * Add this factor to prime factorization. If 'factor'
                 * is an actual factor of remainingFactor, it's always
                 * prime. If it is composite, it won't be able to divide
                 * remainingFactor even if it's a factor of n, because
                 * it's the multiple of a smaller prime number that
                 * completed that division.
                 */
                primeF.add(factor);
            }

            /*
             * If n's largest prime factor is small enough such that its square
             * is less than n, it'll be included in the loop and bring
             * remainingFactor to 1, which isn't prime.
             */
            if (remainingFactor == 1) {
                // Restore remainingFactor (will be added to primeF after loop)
                remainingFactor = factor;
                // Cause outer while loop to end
                factor = 1;
            } else {
                // Move onto next possible prime factor
                factor++;
            }
        }

        // Add the last factor
        primeF.add(remainingFactor);
        return primeF.toArray(new Integer[0]);
    }

    /**
     * Filters exponents, or repeated numbers, out of
     * the prime factorization
     *
     * @param  primeFactorization  Integer array from primeFactorization()
     * @return                     int array with unique prime factors
     */
    public static int[] primeFBases(Integer[] primeFactorization)
    {
        return Arrays.stream(primeFactorization).distinct()
                .mapToInt(Integer::intValue).toArray();
    }
}
