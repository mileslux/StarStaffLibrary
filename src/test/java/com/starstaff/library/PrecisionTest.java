package com.starstaff.library;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by mileslux on 12/9/2015.
 */
public class PrecisionTest {
    private static final double DELTA = 1e-8;
    private final Precision precision = new Precision(DELTA);

    @DataProvider
    public Object[][] lessOrEqualUncheckedData() {
        return new Object[][]{
                {1, 1, true},
                {1 + precision.getDelta(), 1, true},
                {1 + precision.getDelta() * 1.1, 1, false}
        };
    }

    @DataProvider
    public Object[][] lessUncheckedData() {
        return new Object[][]{
                {1, 1, true},
                {1 + precision.getDelta(), 1, false},
                {1 + precision.getDelta() / 2, 1, true}
        };
    }

    @DataProvider
    public Object[][] nonZeroUncheckedData() {
        return new Object[][]{
                {1, true},
                {precision.getDelta() * 1.1, true},
                {precision.getDelta(), false},
                {0, false}
        };
    }

    @Test(dataProvider = "lessOrEqualUncheckedData")
    public void testLessOrEqualUnchecked(double a, double b, boolean expected) {
        assertEquals(precision.lessOrEqualUnchecked(a,b), expected);
    }

    @Test(dataProvider = "lessUncheckedData")
    public void testLessUnchecked(double a, double b, boolean expected) {
        assertEquals(precision.lessUnchecked(a, b), expected);
    }

    @Test(dataProvider = "nonZeroUncheckedData")
    public void testNonZeroUnchecked(double a, boolean expected) {
        assertEquals(precision.nonZeroUnchecked(a), expected);
    }
}