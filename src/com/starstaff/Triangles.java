package com.starstaff;

/**
 * Created by mileslux on 12/9/2015.
 * Class that calculates the area of a right-angled triangle
 */
public class Triangles {

    private final Precision precision;
    
    public Triangles(Precision precision) {
        this.precision = precision;
    }
    
    public Precision getPrecision() {
        return precision;
    }

    public double areaRightAngledTriangle(double a, double b, double c) {
        if (!Double.isFinite(a))
            throw new IllegalArgumentException("First argument is not finite");
        if (!Double.isFinite(b))
            throw new IllegalArgumentException("Second argument is not finite");
        if (!Double.isFinite(c))
            throw new IllegalArgumentException("Third argument is not finite");

        if (precision.lessOrEqualUnchecked(a, 0))
            throw new IllegalArgumentException("First argument should be positive");
        if (precision.lessOrEqualUnchecked(b, 0))
            throw new IllegalArgumentException("Second argument should be positive");
        if (precision.lessOrEqualUnchecked(c, 0))
            throw new IllegalArgumentException("Third argument should be positive");

        if (precision.lessOrEqualUnchecked(a + b, c) ||
                precision.lessOrEqualUnchecked(a + c, b) ||
                precision.lessOrEqualUnchecked(b + c, a))
            throw new IllegalArgumentException("Triangle inequality is violated");

        double swap;

        if (precision.lessUnchecked(c, a)) {
            swap = a;
            a = c;
            c = swap;
        }

        if (precision.lessUnchecked(c, b)) {
            swap = b;
            b = c;
            c = swap;
        }

        if (precision.nonZeroUnchecked(c * c - a * a - b * b))
            throw new IllegalArgumentException("Triangle is not right-angled");

        return a * b / 2;
    }
}
