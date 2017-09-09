package de.ostfalia.gdp.ss15;

import java.util.Scanner;

/**
 * Created by Henrik on 4/21/2015.
 */
public class Analysis {
    /**
     * zaehler
     */
    public static int count = 0;
    /**
     * minimum
     */
    public static int minimum = 0;
    public static int maximum = 0;
    public static int summe = 0;
    public static int countNegative = 0;
    public static int countPositive = 0;

    public static void readAnalyzeNumbers() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            add(scanner.nextInt());
        }
    }
    public static void reset() {
        count = 0;
        minimum = 0;
        maximum = 0;
        summe = 0;
        countNegative = 0;
        countPositive = 0;
    }

    public static void add(int value) {
        if (count == 0) {
            minimum = value;
            maximum = value;
        }
        count++;
        summe = summe + value;
        if (value < minimum) {
            minimum = value;
        } else if (value > maximum) {
            maximum = value;
        }
        if (value < 0) {
            countNegative++;
        } else {
            countPositive++;
        }
    }
    public static int getCount() {
        return count;
    }

    public static int getMinimum() {
        return minimum;
    }

    public static int getMaximum() {
        return maximum;
    }

    public static double getAverage() {
        return (double) summe / count;
    }

    public static int getNumberNegative() {
        return countNegative;
    }

    public static int getNumberPositive() {
        return countPositive;
    }

    public static void analyzeFibonacci(int n) {
        int number1 = 0;
        int number2 = 1;
        for (int i = 0; i <= n; i++) {
            add(number1);
            int temp = number2;
            number2 = number1 + number2;
            number1 = temp;
        }
    }

    public static void main(String[] args) {

    }
}
