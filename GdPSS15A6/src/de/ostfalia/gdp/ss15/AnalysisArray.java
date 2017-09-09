package de.ostfalia.gdp.ss15;

/**
 * Created by Henrik on 4/24/2015.
 * @author Henrik Drefs Maximilian Prusch
 */
public class AnalysisArray {

    /**
     * Minimum of the Array
     * @param data input array
     * @return the minimum of data
     */
    public static int getMinimum(int[] data) {
        int minimum = data[0];
        for (int zahl : data) {
            if (zahl < minimum) {
                minimum = zahl;
            }
        }
        return minimum;
    }

    /**
     * Maximum of the Array
     * @param data input array
     * @return the maximum of data
     */
    public static int getMaximum(int[] data) {
        int maximum = data[0];
        for (int zahl : data) {
            if (zahl > maximum) {
                maximum = zahl;
            }
        }
        return maximum;
    }

    /**
     * Calculates the sum of all value of the array
     * @param data input Array
     * @return the sum of the value of data
     */
    public static int getSum(int[] data) {
        int sum = 0;
        for (int zahl : data) {
            sum = sum + zahl;
        }
        return sum;
    }

    /**
     * calculates the average of all the values of an array
     * @param data input array
     * @return the average of all the values of data
     */
    public static double getAverage(int[] data) {
        return (double) getSum(data) / data.length;
    }

    /**
     * counts the negative value of an array
     * @param data input array
     * @return a number for how many negative value are in data
     */
    public static int getNumberNegative(int[] data) {
        int numberNegatives = 0;
        for (int zahl : data) {
            if (zahl < 0) {
                numberNegatives++;
            }
        }
        return numberNegatives;
    }

    /**
     * calculates the fibonacci numbers until a given a number
     * @param n length of fibonacci numbers
     * @return the fibonacci numbers until number n
     */
    public static int[] fibonacci(int n) {
        int[] fibonacciArray = new int[n + 1];
        int number1 = 0;
        int number2 = 1;
        for (int i = 0; i <= n; i++) {
            fibonacciArray[i] = number1;
            int temp = number2;
            number2 = number1 + number2;
            number1 = temp;
        }
        return fibonacciArray;
    }

    /**
     * tests
     * @param args argument
     */
    public static void main(String[] args) {
        for (int zahl : fibonacci(7)) {
            System.out.println(zahl);
        }

    }
}
