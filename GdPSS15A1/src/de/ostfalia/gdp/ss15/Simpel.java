package de.ostfalia.gdp.ss15;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Henrik
 * Created by Henrik on 3/5/2015.
 */
public class Simpel {
    /**
     * @param args This class calculates with an integer the half, double and square.
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int a = 0;
        try {
            a = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Das n\u00e4chste mal keine Kommazahl eingeben.");
            System.exit(-1);
        }
        System.out.println("Hälfte: " + (a / 2) + "\nDoppeltes: " + (a * 2) + "\nQuadrat: " + (a * a));

    }
}
