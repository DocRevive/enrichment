import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GridRectCounterTest {
    private static GridRectCounter rect1;
    private static GridRectCounter rect2;
    private static GridRectCounter rect3;

    @BeforeAll
    public static void setUp() {
        rect1 = new GridRectCounter(1, 3);
        rect2 = new GridRectCounter(2, 2);
        rect3 = new GridRectCounter(5, 4);
    }

    @Test
    public void countRectangles() {
        assertEquals(6, rect1.countRectangles());
        assertEquals(9, rect2.countRectangles());
        assertEquals(150, rect3.countRectangles());
    }

    @Test
    public void countSquares() {
        assertEquals(3, rect1.countSquares());
        assertEquals(5, rect2.countSquares());
        assertEquals(40, rect3.countSquares());
    }
}