package com.starstaff.library;

/**
 * Created by mileslux on 12/9/2015.
 * Supplemental class for operations with precision
 */
public class Precision
{
    private final double delta;

    public Precision(double delta) {
        if (!Double.isFinite(delta))
            throw new IllegalArgumentException("delta is not finite");
        if (delta < 0)
            throw new IllegalArgumentException("delta should be non-negative");

        this.delta = delta;
    }

    public double getDelta() {
        return delta;
    }

    public boolean lessOrEqualUnchecked(double a, double b) {
        return (a <= b + delta);
    }

    public boolean lessUnchecked(double a, double b) {
        return (a < b + delta);
    }

    public boolean nonZeroUnchecked(double a) {
        return (Math.abs(a) > delta);
    }
}
