/**
 * Running code
 *
 * @author Daniel Kim
 * @version 3-7-22
 */

public class Main {
    public static void main(String[] args)
    {

        long startTime = System.currentTimeMillis();
        long result = ProjectEulerSolutions.findLargestPrimeFactor(500);
        long endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime) / 1000 + " s");
        System.out.println(result);
    }
}
