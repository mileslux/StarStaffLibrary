package com.starstaff;

/**
 * Created by mileslux on 12/9/2015.
 * Supplemental class for operations with precision
 */
public class Precision
{
    public static final double DEFAULT_DELTA = 1e-7;

    public final double delta;

    public Precision() {
        delta = DEFAULT_DELTA;
    }

    public Precision(double delta) {
        if (!Double.isFinite(delta))
            throw new IllegalArgumentException("delta is not finite");
        if (delta < 0)
            throw new IllegalArgumentException("delta should be non-negative");

        this.delta = delta;
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
