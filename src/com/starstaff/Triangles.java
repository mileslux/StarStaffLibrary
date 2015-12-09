package com.starstaff;

/**
 * Created by mileslux on 12/9/2015.
 * Class that calculates the area of a right-angled triangle
 */
public class Triangles {
    public static final double DELTA = 1e-7;

    private static final Precision PRECISION = new Precision(DELTA);

    public static double areaRightAngledTriangle(double a, double b, double c) {
        if (!Double.isFinite(a))
            throw new IllegalArgumentException("First argument is not finite");
        if (!Double.isFinite(b))
            throw new IllegalArgumentException("Second argument is not finite");
        if (!Double.isFinite(c))
            throw new IllegalArgumentException("Third argument is not finite");

        if (a <= 0)
            throw new IllegalArgumentException("First argument should be positive");
        if (b <= 0)
            throw new IllegalArgumentException("Second argument should be positive");
        if (c <= 0)
            throw new IllegalArgumentException("Third argument should be positive");

        if (PRECISION.lessOrEqualUnchecked(a + b, c) ||
                PRECISION.lessOrEqualUnchecked(a + c, b) ||
                PRECISION.lessOrEqualUnchecked(b + c, a))
            throw new IllegalArgumentException("Triangle inequality is violated");

        double swap;

        if (PRECISION.lessUnchecked(c, a)) {
            swap = a;
            a = c;
            c = swap;
        }

        if (PRECISION.lessUnchecked(c, b)) {
            swap = b;
            b = c;
            c = swap;
        }

        if (PRECISION.nonZeroUnchecked(c * c - a * a - b * b))
            throw new IllegalArgumentException("Triangle is not right-angled");

        return a * b / 2;
    }
}
