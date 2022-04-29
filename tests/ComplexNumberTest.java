import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ComplexNumberTest {
    private ComplexNumber cn;
    private ComplexNumber cn2;

    @BeforeEach
    public void setUp() {
        cn = new ComplexNumber(2.0, -3.0);
        cn2 = new ComplexNumber(-5.0, -3.0);
    }

    @Test
    public void add() {
        assertEquals("-3.0-6.0i", cn.add(cn2).toString());
    }

    @Test
    void subtract() {
        assertEquals("7.0+0.0i", cn.subtract(cn2).toString());
    }

    @Test
    void multiply() {
        assertEquals("-19.0+9.0i", cn.multiply(cn2).toString());
    }

    @Test
    void divide() {
        ComplexNumber quotient = cn.divide(cn2);
        assertEquals(-0.02941, quotient.getA(), 1e-5);
        assertEquals(0.61765, quotient.getB(), 1e-5);
    }

    @Test
    void negative() {
        assertEquals("-2.0+3.0i", cn.negative().toString());
        assertEquals("5.0+3.0i", cn2.negative().toString());
    }

    @Test
    void absoluteValue() {
        assertEquals(3.6055, cn.absoluteValue(), 1e-4);
        assertEquals(5.831, cn2.absoluteValue(), 1e-3);
    }

    @Test
    void argument() {
        assertEquals(-0.98279, cn.argument(), 1e-5);
        assertEquals(-2.60117, cn2.argument(), 1e-5);
    }

    @Test
    void conjugate() {
        assertEquals("2.0+3.0i", cn.conjugate().toString());
        assertEquals("-5.0+3.0i", cn2.conjugate().toString());
    }

    @Test
    void square() {
        assertEquals("-5.0-12.0i", cn.square().toString());
        assertEquals("16.0+30.0i", cn2.square().toString());
    }

    @Test
    void testToString() {
        assertEquals("2.0-3.0i", cn.toString());
        assertEquals("-5.0-3.0i", cn2.toString());
    }
}