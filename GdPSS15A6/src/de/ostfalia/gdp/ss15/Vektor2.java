package de.ostfalia.gdp.ss15;

/**
 * Created by Henrik on 4/27/2015.
 * @author Henrik Drefs Maximilian Prusch
 */
public class Vektor2 {
    /**
     * checks if all values of an array are zero
     * @param v input array
     * @return boolean if all the values are zero or not
     */
    public static boolean isZero (double[] v) {
        for (double zahl : v) {
            if (zahl != 0) {
                return false;
            }
        }
        return true;
    }
    /**
     * checks if all values of an array are zero
     * @param v input array
     * @return boolean if all the values are zero or not
     */
    public static boolean isZero (int[] v) {
        for (int zahl : v) {
            if (zahl != 0) {
                return false;
            }
        }
        return true;
    }
    /**
     * checks if all values of an array are zero
     * @param v input array
     * @return boolean if all the values are zero or not
     */
    public static boolean isZero (long[] v) {
        for (long zahl : v) {
            if (zahl != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * adds all the values of an array together. Also fills empty values with zeros if one of the two arrays is longer than the other one.
     * @param v input array
     * @param w input array
     * @return an array which displays the sum of the two arrays
     */
    public static double[] add(double[] v, double[] w) {
        double[] sum;
        if (v.length >= w.length) {
            sum = new double[v.length];
        } else {
            sum = new double[w.length];
        }

        for (int i = 0; i < sum.length; i++) {
            if (i > w.length) {
                sum[i] = v[i];
            } else if (i > v.length) {
                sum[i] = w[i];
            } else {
                sum[i] = v[i] + w[i];
            }
        }
        return sum;
    }
    /**
     * adds all the values of an array together. Also fills empty values with zeros if one of the two arrays is longer than the other one.
     * @param v input array
     * @param w input array
     * @return an array which displays the sum of the two arrays
     */
    public static double[] add(double[] v, int[] w) {
        double[] sum;
        if (v.length >= w.length) {
            sum = new double[v.length];
        } else {
            sum = new double[w.length];
        }

        for (int i = 0; i < sum.length; i++) {
            if (i > w.length) {
                sum[i] = v[i];
            } else if (i > v.length) {
                sum[i] = w[i];
            } else {
                sum[i] = v[i] + w[i];
            }
        }
        return sum;
    }
    /**
     * adds all the values of an array together. Also fills empty values with zeros if one of the two arrays is longer than the other one.
     * @param v input array
     * @param w input array
     * @return an array which displays the sum of the two arrays
     */
    public static double[] add(double[] v, long[] w) {
        double[] sum;
        if (v.length >= w.length) {
            sum = new double[v.length];
        } else {
            sum = new double[w.length];
        }

        for (int i = 0; i < sum.length; i++) {
            if (i > w.length) {
                sum[i] = v[i];
            } else if (i > v.length) {
                sum[i] = w[i];
            } else {
                sum[i] = v[i] + w[i];
            }
        }
        return sum;
    }
    /**
     * adds all the values of an array together. Also fills empty values with zeros if one of the two arrays is longer than the other one.
     * @param v input array
     * @param w input array
     * @return an array which displays the sum of the two arrays
     */
    public static int[] add(int[] v, int[] w) {
        int[] sum;
        if (v.length >= w.length) {
            sum = new int[v.length];
        } else {
            sum = new int[w.length];
        }

        for (int i = 0; i < sum.length; i++) {
            if (i > w.length) {
                sum[i] = v[i];
            } else if (i > v.length) {
                sum[i] = w[i];
            } else {
                sum[i] = v[i] + w[i];
            }
        }
        return sum;
    }
    /**
     * adds all the values of an array together. Also fills empty values with zeros if one of the two arrays is longer than the other one.
     * @param v input array
     * @param w input array
     * @return an array which displays the sum of the two arrays
     */
    public static long[] add(int[] v, long[] w) {
        long[] sum;
        if (v.length >= w.length) {
            sum = new long[v.length];
        } else {
            sum = new long[w.length];
        }

        for (int i = 0; i < sum.length; i++) {
            if (i > w.length) {
                sum[i] = v[i];
            } else if (i > v.length) {
                sum[i] = w[i];
            } else {
                sum[i] = v[i] + w[i];
            }
        }
        return sum;
    }
    /**
     * adds all the values of an array together. Also fills empty values with zeros if one of the two arrays is longer than the other one.
     * @param v input array
     * @param w input array
     * @return an array which displays the sum of the two arrays
     */
    public static double[] add(int[] v, double[] w) {
        double[] sum;
        if (v.length >= w.length) {
            sum = new double[v.length];
        } else {
            sum = new double[w.length];
        }

        for (int i = 0; i < sum.length; i++) {
            if (i > w.length) {
                sum[i] = v[i];
            } else if (i > v.length) {
                sum[i] = w[i];
            } else {
                sum[i] = v[i] + w[i];
            }
        }
        return sum;
    }
    /**
     * adds all the values of an array together. Also fills empty values with zeros if one of the two arrays is longer than the other one.
     * @param v input array
     * @param w input array
     * @return an array which displays the sum of the two arrays
     */
    public static long[] add(long[] v, long[] w) {
        long[] sum;
        if (v.length >= w.length) {
            sum = new long[v.length];
        } else {
            sum = new long[w.length];
        }
        for (int i = 0; i < sum.length; i++) {
            if (i > w.length) {
                sum[i] = v[i];
            } else if (i > v.length) {
                sum[i] = w[i];
            } else {
                sum[i] = v[i] + w[i];
            }
        }
        return sum;
    }
    /**
     * adds all the values of an array together. Also fills empty values with zeros if one of the two arrays is longer than the other one.
     * @param v input array
     * @param w input array
     * @return an array which displays the sum of the two arrays
     */
    public static double[] add(long[] v, double[] w) {
        double[] sum;
        if (v.length >= w.length) {
            sum = new double[v.length];
        } else {
            sum = new double[w.length];
        }
        for (int i = 0; i < sum.length; i++) {
            if (i > w.length) {
                sum[i] = v[i];
            } else if (i > v.length) {
                sum[i] = w[i];
            } else {
                sum[i] = v[i] + w[i];
            }
        }
        return sum;
    }
    /**
     * adds all the values of an array together. Also fills empty values with zeros if one of the two arrays is longer than the other one.
     * @param v input array
     * @param w input array
     * @return an array which displays the sum of the two arrays
     */
    public static long[] add(long[] v, int[] w) {
        long[] sum;
        if (v.length >= w.length) {
            sum = new long[v.length];
        } else {
            sum = new long[w.length];
        }

        for (int i = 0; i < sum.length; i++) {
            if (i > w.length) {
                sum[i] = v[i];
            } else if (i > v.length) {
                sum[i] = w[i];
            } else {
                sum[i] = v[i] + w[i];
            }
        }
        return sum;
    }

    /**
     * calculates an array which values are multiplied with another number
     * @param c multiplicand
     * @param v input array
     * @return an array that is the original array multiplied by c
     */
    public static double[] scale(double c, double[] v) {
        double[] scaled = new double[v.length];
        for (int i = 0; i < v.length; i++) {
            scaled[i] = c * v[i];
        }
        return scaled;
    }
    /**
     * calculates an array which values are multiplied with another number
     * @param c multiplicand
     * @param v input array
     * @return an array that is the original array multiplied by c
     */
    public static double[] scale(int c, double[] v) {
        double[] scaled = new double[v.length];
        for (int i = 0; i < v.length; i++) {
            scaled[i] = c * v[i];
        }
        return scaled;
    }
    /**
     * calculates an array which values are multiplied with another number
     * @param c multiplicand
     * @param v input array
     * @return an array that is the original array multiplied by c
     */
    public static double[] scale(long c, double[] v) {
        double[] scaled = new double[v.length];
        for (int i = 0; i < v.length; i++) {
            scaled[i] = c * v[i];
        }
        return scaled;
    }
    /**
     * calculates an array which values are multiplied with another number
     * @param c multiplicand
     * @param v input array
     * @return an array that is the original array multiplied by c
     */
    public static double[] scale(double c, long[] v) {
        double[] scaled = new double[v.length];
        for (int i = 0; i < v.length; i++) {
            scaled[i] = c * v[i];
        }
        return scaled;
    }
    /**
     * calculates an array which values are multiplied with another number
     * @param c multiplicand
     * @param v input array
     * @return an array that is the original array multiplied by c
     */
    public static long[] scale(int c, long[] v) {
        long[] scaled = new long[v.length];
        for (int i = 0; i < v.length; i++) {
            scaled[i] = c * v[i];
        }
        return scaled;
    }
    /**
     * calculates an array which values are multiplied with another number
     * @param c multiplicand
     * @param v input array
     * @return an array that is the original array multiplied by c
     */
    public static long[] scale(long c, long[] v) {
        long[] scaled = new long[v.length];
        for (int i = 0; i < v.length; i++) {
            scaled[i] = c * v[i];
        }
        return scaled;
    }
    /**
     * calculates an array which values are multiplied with another number
     * @param c multiplicand
     * @param v input array
     * @return an array that is the original array multiplied by c
     */
    public static double[] scale(double c, int[] v) {
        double[] scaled = new double[v.length];
        for (int i = 0; i < v.length; i++) {
            scaled[i] = c * v[i];
        }
        return scaled;
    }
    /**
     * calculates an array which values are multiplied with another number
     * @param c multiplicand
     * @param v input array
     * @return an array that is the original array multiplied by c
     */
    public static int[] scale(int c, int[] v) {
        int[] scaled = new int[v.length];
        for (int i = 0; i < v.length; i++) {
            scaled[i] = c * v[i];
        }
        return scaled;
    }
    /**
     * calculates an array which values are multiplied with another number
     * @param c multiplicand
     * @param v input array
     * @return an array that is the original array multiplied by c
     */
    public static long[] scale(long c, int[] v) {
        long[] scaled = new long[v.length];
        for (int i = 0; i < v.length; i++) {
            scaled[i] = c * v[i];
        }
        return scaled;
    }

    /**
     * calculates the length of a vector
     * @param v input vector
     * @return the length of a vector
     */
    public static double euclideanNorm(double[] v) {
        double sumSquares = 0;
        for (double zahl : v) {
            sumSquares = sumSquares + Math.pow(zahl, 2);
        }
        return Math.sqrt(sumSquares);

    }
    /**
     * calculates the length of a vector
     * @param v input vector
     * @return the length of a vector
     */
    public static double euclideanNorm(long[] v) {
        double sumSquares = 0;
        for (double zahl : v) {
            sumSquares = sumSquares + Math.pow(zahl, 2);
        }
        return Math.sqrt(sumSquares);

    }
    /**
     * calculates the length of a vector
     * @param v input vector
     * @return the length of a vector
     */
    public static double euclideanNorm(int[] v) {
        double sumSquares = 0;
        for (double zahl : v) {
            sumSquares = sumSquares + Math.pow(zahl, 2);
        }
        return Math.sqrt(sumSquares);

    }

    /**
     * calculates the sum of all absolute values of an array
     * @param v input array
     * @return sum of all the absolute values of v
     */
    public static double manhattenNorm(double[] v) {
        double manhattanNorm = 0;
        for (double zahl : v) {
            manhattanNorm = manhattanNorm + Math.abs(zahl);
        }
        return manhattanNorm;
    }
    /**
     * calculates the sum of all absolute values of an array
     * @param v input array
     * @return sum of all the absolute values of v
     */
    public static long manhattenNorm(long[] v) {
        long manhattanNorm = 0L;
        for (long zahl : v) {
            manhattanNorm = manhattanNorm + Math.abs(zahl);
        }
        return manhattanNorm;
    }
    /**
     * calculates the sum of all absolute values of an array
     * @param v input array
     * @return sum of all the absolute values of v
     */
    public static int manhattenNorm(int[] v) {
        int manhattanNorm = 0;
        for (int zahl : v) {
            manhattanNorm = manhattanNorm + Math.abs(zahl);
        }
        return manhattanNorm;
    }

    /**
     * calculates maximum absolute value of an array
     * @param v input array
     * @return the maximum absolute value of v
     */
    public static double infinityNorm(double[] v) {
        if (v.length == 0) {
            return 0.0;
        }
        double max = Math.abs(v[0]);
        for (double zahl : v) {
            if (Math.abs(zahl) > max) {
                max = Math.abs(zahl);
            }
        }
        return max;
    }
    /**
     * calculates maximum absolute value of an array
     * @param v input array
     * @return the maximum absolute value of v
     */
    public static long infinityNorm(long[] v) {
        if (v.length == 0) {
            return 0L;
        }
        long max = Math.abs(v[0]);
        for (long zahl : v) {
            if (Math.abs(zahl) > max) {
                max = Math.abs(zahl);
            }
        }
        return max;
    }
    /**
     * calculates maximum absolute value of an array
     * @param v input array
     * @return the maximum absolute value of v
     */
    public static int infinityNorm(int[] v) {
        if (v.length == 0) {
            return 0;
        }
        int max = Math.abs(v[0]);
        for (int zahl : v) {
            if (Math.abs(zahl) > max) {
                max = Math.abs(zahl);
            }
        }
        return max;
    }

    /**
     * tests
     * @param args arguments
     */
    public static void main(String[] args) {

    }
}
