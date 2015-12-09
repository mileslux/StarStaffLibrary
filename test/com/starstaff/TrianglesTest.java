package com.starstaff;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by mileslux on 12/9/2015.
 */
public class TrianglesTest {
    @DataProvider
    public Object[][] validData() {
        return new Object[][]{
                {3, 4, 5, 6},
                {13, 12, 5, 30},
                {40, 9, 41, 180},
                {0.7, 2.5, 2.4, 0.84},
                {1, 1, 1.41421356, 0.5},
                {1.414213562, 1.732050807, 2.23606797, 1.224744871}
        };
    }

    @DataProvider
    public Object[][] invalidData() {
        return new Object[][]{
                {Double.NaN, 1, 1},
                {1, Double.NEGATIVE_INFINITY, 1},
                {1, 1, Double.POSITIVE_INFINITY},
                {-1, 1, 1},
                {1, 0, 1},
                {4, 3, 1},
                {3, 4, 6},
                {1, 1, 1.4142135}
        };
    }

    @Test(dataProvider = "validData")
    public void testAreaRightAngledTriangleValid(double a, double b, double c, double area) {
        assertEquals(Triangles.areaRightAngledTriangle(a, b, c),
                area,
                Triangles.DELTA);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, dataProvider = "invalidData")
    public void testAreaRightAngledTriangleInvalid(double a, double b, double c) {
        Triangles.areaRightAngledTriangle(a, b, c);
    }
}