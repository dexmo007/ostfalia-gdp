package de.ostfalia.gdp.ss15;

import java.util.Scanner;

/**
 * @author Henrik
 */
public class Wochen {
    static int variableMitSeltsamemNamen;
    static short b13;

    /**
     * @param args
     * Fixed code from the exercise sheet
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        b13 = (short) (a % 7);
        variableMitSeltsamemNamen = (int) (a / 7);
        System.out.println("Es sind " + variableMitSeltsamemNamen +
                " Wochen und " + b13 + " Tage!");
    }
}