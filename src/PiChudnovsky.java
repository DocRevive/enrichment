import org.apfloat.Apfloat;
import org.apfloat.ApfloatMath;

/**
 * Chudnovsky algorithm implementation with Apfloat.
 */
public class PiChudnovsky
{
    private static final long ITERATIONS = 100L;
    private static final int DIGITS = 1000;

    public static void main(String[] args)
    {
        Apfloat sum = new Apfloat(0);

        Apfloat C = new Apfloat(426880).multiply(ApfloatMath.sqrt(new Apfloat(10005, DIGITS)));
        Apfloat m = new Apfloat(1);
        Apfloat k = new Apfloat(-6);
        Apfloat x = new Apfloat(1);
        Apfloat l = new Apfloat(13591409);

        Apfloat l2 = new Apfloat(545140134);
        Apfloat x2 = new Apfloat("-262537412640768000", DIGITS);

        Apfloat k2 = new Apfloat(12);
        Apfloat m2 = new Apfloat(16);
        Apfloat m3 = new Apfloat(1);

        for (long q = 0; q < ITERATIONS; q++) {
            sum = sum.add(m.multiply(l).divide(x));
            Apfloat apQ = new Apfloat(q, DIGITS);
            l = l.add(l2);
            x = x.multiply(x2);
            k = k.add(k2);
            m = m.multiply(
                    ApfloatMath.pow(k, 3L)
                            .subtract(k.multiply(m2))
                            .divide(ApfloatMath
                                    .pow(apQ.add(m3),3L)));
        }

        System.out.println(ApfloatMath.pow(sum, -1L).multiply(C));
    }
}
