import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private final Calculator CALCULATOR = new Calculator();

    @Test
    void findPrimes() {
        assertArrayEquals(new Integer[]{2, 3, 5, 7}, CALCULATOR.findPrimes(8));
    }

    @Test
    void abs() {
        assertEquals(5, CALCULATOR.abs(-5));
        assertEquals(3, CALCULATOR.abs(3));
    }

    @Test
    void isFactor() {
        assertFalse(CALCULATOR.isFactor(90, 4));
        assertTrue(CALCULATOR.isFactor(100, 2));
    }

    @Test
    void testIsFactor() {
        assertFalse(CALCULATOR.isFactor(90, 4, 7));
        assertTrue(CALCULATOR.isFactor(100, 2, 20));
    }

    @Test
    void numberOfRoots() {
        assertEquals("No real roots", CALCULATOR.numberOfRoots(2, 2, 5));
        assertEquals("One real double root", CALCULATOR.numberOfRoots(1, 0, 0));
        assertEquals("Two real roots", CALCULATOR.numberOfRoots(3, 4, -10));
    }

    @Test
    void smallestPrimeFactor() {
        assertEquals(19, CALCULATOR.smallestPrimeFactor(589));
        assertEquals(31, CALCULATOR.smallestPrimeFactor(1457));
    }

    @Test
    void findGcf() {
        assertEquals(7, CALCULATOR.findGcf(21, 35));
        assertEquals(590, CALCULATOR.findGcf(12390, 590));
    }
}