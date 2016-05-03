import model.Model;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Сергей on 26.04.2016.
 */
public class TestModel {

    private Model model;
    @Before
    public void modelSetUp(){
        model = new Model();
    }

    @Test
    public void testDefaultRandBoundaries() throws Exception {
        model.rand();
        int lowBoundary = model.getMinValue();
        int highBoundary = model.getMaxValue();
        assertEquals(1, lowBoundary);
        assertEquals(99, highBoundary);
    }

    @Test
    public void testRandBoundaries() throws Exception {
        model.rand(15, 20);
        int lowBoundary = model.getMinValue();
        int highBoundary = model.getMaxValue();
        assertEquals(16, lowBoundary);
        assertEquals(19, highBoundary);
    }

    @Test
    public void testSetMinValue() throws Exception {
        model.setMinValue(5);
        int lowBoundary = model.getMinValue();
        assertEquals(6, lowBoundary);
    }

    @Test
    public void testSetMaxValue() throws Exception {
        model.setMaxValue(77);
        int highBoundary = model.getMaxValue();
        assertEquals(76, highBoundary);
    }

}
