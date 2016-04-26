import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Сергей on 26.04.2016.
 */
public class AverageNumberTest {
    public static final double ACCURACY = 1e-10;

    @org.junit.Test
    public void testCalculateAverage() throws Exception {
        AverageNumber an = new AverageNumber(3, 7, 5);
        double res = an.calculateAverage();
        assertEquals(5, res, ACCURACY);
    }

    @Test
    public void testRoundToLess() {
        AverageNumber an = new AverageNumber(1, 7, 5);
        int res = an.roundAderage();
        assertEquals(4, res);
    }

    @Test
    public void testRoundToMore() {
        AverageNumber an = new AverageNumber(5, 7, 5);
        int res = an.roundAderage();
        assertEquals(6, res);
    }

}