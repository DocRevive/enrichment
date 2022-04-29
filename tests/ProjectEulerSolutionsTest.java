import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProjectEulerSolutionsTest {
    @Test
    public void findLargestPrimeFactor() {
        assertEquals(6857, ProjectEulerSolutions.findLargestPrimeFactor(600851475143L));
    }

    @Test
    public void sumMultiplesOf3or5() {
        assertEquals(233168, ProjectEulerSolutions.sumMultiplesOf3or5());
    }
}