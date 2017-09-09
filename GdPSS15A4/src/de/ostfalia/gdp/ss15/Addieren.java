package de.ostfalia.gdp.ss15;

import java.util.Scanner;

/**
 * Created by Henrik on 3/24/2015.
 * @author Henrik Drefs / Maximilian Prusch
 */
public class Addieren {
    /**
     * Fließkommazahlen addieren
     *
     * @param args argument
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        double d, x = 1.0, result, difference;
        System.out.print("Eingabe: ");
        n = scanner.nextInt();
        d = scanner.nextDouble();

        // result = x + (n * d);
        result = x;
        for (int i = 1; i <= n; i++) {
            result = result + d;
        }
        difference = result - (1 + (n * d));
        System.out.println("Ausgabe: " + result + " Differenz: " + difference);
    }
}
