/**
 * Class that enables the creation of diamonds.
 *
 * @author Daniel Kim
 * @version 4-9-22
 */
public class Diamond {
    public static void main(String[] args)
    {
        System.out.println(makeDiamond(5));
    }

    /**
     * Creates a diamond.
     *
     * @param  size  length of both diagonals
     * @return       a diamond made up of asterisks
     */
    public static String makeDiamond(int size)
    {
        // Vertex: (h, size)
        int h = (size-1) / 2;
        StringBuilder diamond = new StringBuilder();

        for (int i = 0; i < size; i++) {
            /*
             * numOfAsterisks is determined by an absolute value
             * function since a diamond widens and shrinks at a
             * constant rate
             *
             * Number of preceding spaces is half of the size not
             * taken up by asterisks
             */

            int numOfAsterisks = -2 * Math.abs(i - h) + size;
            diamond.append(" ".repeat((size - numOfAsterisks) / 2))
                    .append("*".repeat(numOfAsterisks)).append("\n");
        }

        return diamond.toString();
    }
}
