import java.util.ArrayList;
import java.util.Arrays;

/**
 * A calculator class with some methods.
 *
 * @author Daniel Kim
 * @version 3-2-22
 */
public class Calculator
{
    /**
     * Empty constructor
     */
    public Calculator()
    {}

    /**
     * Find primes using Sieve of Eratosthenes
     *
     * @param    n    ceiling, exclusive
     * @return        Integer array of primes below n at 0-based indices
     */
    public Integer[] findPrimes(int n)
    {
        int i;
        boolean[] boolArray = new boolean[n];
        ArrayList<Integer> primes = new ArrayList<>();

        /*
         * By default, values are true. In other words, initially,
         * everything is considered prime.
         */
        Arrays.fill(boolArray, 2, n, Boolean.TRUE);

        // As primes are encountered (starting with 2)
        for (i = 2; i < Math.sqrt(n); i++) {
            // If the index is prime (true)
            if (boolArray[i]) {
                for (int y = 2; y <= (n-1)/i; y++) {
                    boolArray[i*y] = false;
                    /*
                     * All the multiples of the prime below n are set to
                     * false since they are not prime.
                     */
                }
            }
            /*
             * As the loop advances, all composite number indices will
             * eventually hold 'false' before the loop reaches them.
             * Primes are not multiples, so they will stay 'true'.
             */
        }

        for (i = 2; i < boolArray.length; i++) {
            // Traversing boolArray to find & store primes
            if (boolArray[i]) primes.add(i);
        }

        // Convert ArrayList to Integer array
        return primes.toArray(new Integer[0]);
    }

    /**
     * Calculates absolute value of an int
     *
     * @return absolute value
     */
    public int abs(int n)
    {
        return n < 0 ? -n : n;
    }

    /**
     * Calculates whether one int is divisible by the second
     *
     * @param  dividend  number being divided
     * @param  divisor   number dividing
     * @return           whether the divisor divides into completely
     */
    public boolean isFactor(int dividend, int divisor)
    {
        return dividend % divisor == 0;
    }

    /**
     * Calculates whether one int is divisible by either of two
     * other ints
     *
     * @param  dividend  number being divided
     * @param  divisor1  number dividing
     * @param  divisor2  2nd number dividing
     * @return           whether either divisors divide into completely
     */
    public boolean isFactor(int dividend, int divisor1, int divisor2)
    {
        return dividend % divisor1 == 0 || dividend % divisor2 == 0;
    }

    /**
     * Calculates number of roots using discriminant (b^2 - 4ac)
     * a, b, and c come from the quadratic equation: ax^2 + bx + c
     *
     * @param  a  value of 'a'
     * @param  b  value of 'b'
     * @param  c  value of 'c'
     * @return    String describing roots
     */
    public String numberOfRoots(double a, double b, double c)
    {
        double discriminantValue = b*b - 4*a*c;

        if (discriminantValue > 0) {
            return "Two real roots";
        } else if (discriminantValue < 0) {
            return "No real roots";
        } else {
            return "One real double root";
        }
    }

    /**
     * Method that returns the smallest prime factor
     *
     * @param  n  number to get the smallest prime factor of
     */
    public int smallestPrimeFactor(int n)
    {
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) return i;
        }

        return n;
    }

    /**
     * Finds the greatest common factor of two numbers
     *
     * @param  n1  first number
     * @param  n2  second number
     * @return     greatest common factor
     */
    public int findGcf(int n1, int n2)
    {
        // Euclidean algorithm

        int secondToLast = Math.min(n1, n2);
        int remainder = Math.max(n1, n2) % secondToLast;
        int nextNumber;

        while (remainder > 0) {
            nextNumber = secondToLast % remainder;
            secondToLast = remainder;
            remainder = nextNumber;
        }

        return secondToLast;
    }
}
