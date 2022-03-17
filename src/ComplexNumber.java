
/**
 * ComplexNumber class for operations with complex numbers
 *
 * @author Daniel Kim
 * @version 2-9-22
 */
public class ComplexNumber
{
    private double a;
    private double b;

    /**
     * Empty constructor for ComplexNumber
     */
    public ComplexNumber()
    {}

    /**
     * Overloaded constructor for ComplexNumber (a+bi)
     *
     * @param  a  real component
     * @param  b  imaginary component
     */
    public ComplexNumber(double a, double b)
    {
        this.a = a;
        this.b = b;
    }

    /*
     * Accessors
     */
    /*
     * With two complex numbers
     */
    /**
     * Add a complex number to this one
     *
     * @param  plus  complex number to add
     * @return       sum
     */
    public ComplexNumber add(ComplexNumber plus)
    {
        return new ComplexNumber(a + plus.a, b + plus.b);
    }

    /**
     * Subtract a complex number from this one
     *
     * @param  minus  complex number to subtract
     * @return        difference
     */
    public ComplexNumber subtract(ComplexNumber minus)
    {
        return new ComplexNumber(a - minus.a, b - minus.b);
    }

    /**
     * Multiply a complex number with this one
     *
     * @param  mult  complex number to multiply
     * @return       product
     */
    public ComplexNumber multiply(ComplexNumber mult)
    {
        // (a+bi)(c+di) = ac-bd + i(ad+cb)
        return new ComplexNumber(a*mult.a - b*mult.b, a*mult.b + b*mult.a);
    }

    /**
     * This complex number divided by another one
     *
     * @param  divisor  complex number divisor
     * @return          quotient
     */
    public ComplexNumber divide(ComplexNumber divisor)
    {
        /*
         * (a+bi)/(c+di) = (a+bi)(c-di)/(c+di)(c-di)
         *               = (a+bi)(c-di)/(c^2 + d^2)
         */

        // Numerator: multiply with divisor with negated 'b'
        ComplexNumber numerator = multiply(new ComplexNumber(divisor.a, divisor.b*-1));
        double denominator = Math.pow(divisor.a, 2) + Math.pow(divisor.b, 2);

        return new ComplexNumber(numerator.a / denominator, numerator.b / denominator);
    }

    /*
     * With this complex number
     */
    /**
     * Negate the complex number
     *
     * @return negation
     */
    public ComplexNumber negative()
    {
        // Negation: -a-bi
        return new ComplexNumber(a*-1, b*-1);
    }

    /**
     * Calculate absolute value of complex number
     *
     * @return absolute value/modulus
     */
    public double absoluteValue()
    {
        //|a+bi| = sqrt(a^2 + b^2)
        return Math.sqrt(a*a + b*b);
    }

    /**
     * Calculate argument of complex number
     *
     * @return argument in radians
     */
    public double argument()
    {
        // atan2: 2-argument arctan
        return Math.atan2(b, a);
    }

    /**
     * Calculate conjugate of complex number
     *
     * @return conjugate
     */
    public ComplexNumber conjugate()
    {
        // Conjugate: a-bi
        return new ComplexNumber(a, b*-1);
    }

    /**
     * Calculate the complex number squared
     *
     * @return squared
     */
    public ComplexNumber square()
    {
        // (a+bi)^2 = a^2 - b^2 + 2abi
        return new ComplexNumber(a*a - b*b, 2*a*b);
    }

    /**
     * Return String representation of complex number (a+bi)
     *
     * @return string in a+bi form
     */
    @Override
    public String toString()
    {
        double absB = Math.abs(b);
        // Simplifies signums e.g. "4+(-3)i" into "4-3i"
        return a + (absB == b ? "+":"") + b + "i";
    }

    /**
     * Gets 'a' (real component)
     *
     * @return value of 'a'
     */
    public double getA()
    {
        return a;
    }

    /**
     * Gets 'b' (imaginary component)
     *
     * @return value of 'b'
     */
    public double getB()
    {
        return b;
    }

    /*
     * Mutators
     */
    /**
     * Sets 'a' (real component)
     *
     * @param  a  value of 'a'
     */
    public void setA(double a)
    {
        this.a = a;
    }

    /**
     * Sets 'b' (imaginary component)
     *
     * @param  b  value of 'b'
     */
    public void setB(double b)
    {
        this.b = b;
    }
}
