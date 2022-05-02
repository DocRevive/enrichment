import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    private static Calculator calculator;

    @BeforeAll
    public static void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void findPrimes() {
        assertArrayEquals(new Integer[]{2, 3, 5, 7}, calculator.findPrimes(8));
    }

    @Test
    public void abs() {
        assertEquals(5, calculator.abs(-5));
        assertEquals(3, calculator.abs(3));
    }

    @Test
    public void isFactor() {
        assertFalse(calculator.isFactor(90, 4));
        assertTrue(calculator.isFactor(100, 2));
    }

    @Test
    public void testIsFactor() {
        assertFalse(calculator.isFactor(90, 4, 7));
        assertTrue(calculator.isFactor(100, 2, 20));
    }

    @Test
    public void numberOfRoots() {
        assertEquals("No real roots", calculator.numberOfRoots(2, 2, 5));
        assertEquals("One real double root", calculator.numberOfRoots(1, 0, 0));
        assertEquals("Two real roots", calculator.numberOfRoots(3, 4, -10));
    }

    @Test
    public void smallestPrimeFactor() {
        assertEquals(19, calculator.smallestPrimeFactor(589));
        assertEquals(31, calculator.smallestPrimeFactor(1457));
    }

    @Test
    public void findGcf() {
        assertEquals(7, calculator.findGcf(21, 35));
        assertEquals(590, calculator.findGcf(12390, 590));
    }
}