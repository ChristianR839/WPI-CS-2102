import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

public class Examples {

    Planning planning = new Planning();

    LinkedList<Double> rainAllPositive = new LinkedList<Double>();
    LinkedList<Double> rainAllNegative = new LinkedList<Double>();
    LinkedList<Double> rainPosAndNeg = new LinkedList<Double>();
    LinkedList<Double> rainAllPositiveWith999 = new LinkedList<Double>();
    LinkedList<Double> rainAllNegativeWith999 = new LinkedList<Double>();
    LinkedList<Double> rainPosAndNegWith999 = new LinkedList<Double>();
    LinkedList<Double> rainAllZero = new LinkedList<Double>();

    public Examples() {

    }

    @Before
    public void setup() {
        rainAllPositive.add(1.0);
        rainAllPositive.add(2.0);
        rainAllPositive.add(3.0);
        rainAllPositive.add(4.0);

        rainAllNegative.add(-1.0);
        rainAllNegative.add(-2.0);
        rainAllNegative.add(-3.0);
        rainAllNegative.add(-4.0);

        rainPosAndNeg.add(2.0);
        rainPosAndNeg.add(-4.0);
        rainPosAndNeg.add(-6.0);
        rainPosAndNeg.add(8.0);

        rainAllPositiveWith999.add(1.0);
        rainAllPositiveWith999.add(2.0);
        rainAllPositiveWith999.add(3.0);
        rainAllPositiveWith999.add(4.0);
        rainAllPositiveWith999.add(-999.0);
        rainAllPositiveWith999.add(5.0);

        rainAllNegativeWith999.add(-1.0);
        rainAllNegativeWith999.add(-2.0);
        rainAllNegativeWith999.add(-3.0);
        rainAllNegativeWith999.add(-4.0);
        rainAllNegativeWith999.add(-999.0);
        rainAllNegativeWith999.add(-5.0);

        rainPosAndNegWith999.add(1.0);
        rainPosAndNegWith999.add(-2.0);
        rainPosAndNegWith999.add(5.0);
        rainPosAndNegWith999.add(-999.0);
        rainPosAndNegWith999.add(8.0);

        rainAllZero.add(0.0);
        rainAllZero.add(0.0);
        rainAllZero.add(0.0);
        rainAllZero.add(0.0);
        rainAllZero.add(0.0);
    }

    // Planning

    @Test
    public void testRainfall_AllPositiveNo999() {
        assertEquals(planning.rainfall(rainAllPositive), 2.5, 0.1);
    }

    @Test
    public void testRainfall_AllNegativeNo999() {
        assertEquals(planning.rainfall(rainAllNegative), 0.0, 0.1);
    }

    @Test
    public void testRainfall_PosAndNegNo999() {
        assertEquals(planning.rainfall(rainPosAndNeg), 5.0, 0.1);
    }

    @Test
    public void testRainfall_AllPositiveWith999() {
        assertEquals(planning.rainfall(rainAllPositiveWith999), 2.5, 0.1);
    }

    @Test
    public void testRainfall_AllNegativeWith999() {
        assertEquals(planning.rainfall(rainAllNegativeWith999), 0.0, 0.1);
    }

    @Test
    public void testRainfall_PosAndNegWith999() {
        assertEquals(planning.rainfall(rainPosAndNegWith999), 3.0, 0.1);
    }

    @Test
    public void testRainfall_AllZero() {
        assertEquals(planning.rainfall(rainAllZero), 0.0, 0.1);
    }

}
