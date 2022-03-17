
/**
 * A place to test code.
 *
 * @author Daniel Kim
 * @version 2-10-22
 */
public class ComplexTester
{
    public static void main(String[] args)
    {
        System.out.println("1st\n");

        ComplexNumber cn = new ComplexNumber(2.0, -3.0);
        System.out.println(cn);
        System.out.println(cn.negative());       // -2.0+3.0i
        System.out.println(cn.absoluteValue());  // 3.6055
        System.out.println(cn.argument());       // -0.982793723
        System.out.println(cn.conjugate());      // 2.0+3.0i
        System.out.println(cn.square());         // -5-12i

        System.out.println("\n2nd\n");

        ComplexNumber cn2 = new ComplexNumber(-5.0, -3.0);
        System.out.println(cn2);
        System.out.println(cn2.negative());       // 5+3i
        System.out.println(cn2.absoluteValue());  // 5.831
        System.out.println(cn2.argument());       // -2.60117
        System.out.println(cn2.conjugate());      // -5+3i
        System.out.println(cn2.square());         // 16+30i

        System.out.println("\nBoth\n");

        System.out.println(cn.add(cn2));          // -3-6i
        System.out.println(cn.subtract(cn2));     // 7+0i
        System.out.println(cn.multiply(cn2));     // -19+9i
        System.out.println(cn.divide(cn2));       // -0.02941 + 0.61765i
    }
}
