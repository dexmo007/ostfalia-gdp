package de.ostfalia.gdp.ss15;

/**
 * Created by Henrik on 4/14/2015.
 * @author Henrik und Maximilian
 */
public class Bruch {
    /**
     * calculates the greatest common divisor
     * @param a long number a
     * @param b long number b
     * @return long greatest common divisor
     */
    public static long ggT(long a, long b) {
        long r = 0;
        while (b != 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return Math.abs(a);
    }

    /**
     * calculates the lowest common multiple
     * @param a long number a
     * @param b long number b
     * @return long lowest common multiple
     */
    public static long kgV(long a, long b) {
        if (b == 0) {
            return 0;
        } else {
            return Math.abs((a / ggT(a, b)) * b);
        }
    }

    /**
     * calculates the division of a and b
     * @param a long numerator
     * @param b long denominator
     * @return double divion
     */
    public static double toDouble(long a, long b) {
        return (double) a / (double) b;
    }

    /**
     * This is main-method.
     * @param args argument
     */
    public static void main(String[] args) {
        System.out.println(ggT(0, 0));
        System.out.println(kgV(0, 0));
        System.out.println(toDouble(0, 0));
    }
}
