package de.ostfalia.gdp.ss15;

import java.util.Scanner;

/**
 * Created by Henrik on 3/17/2015.
 *
 * @author Henrik Drefs
 */
public class Schleifen {
    /**
     * Schleifen
     *
     * @param args argument
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m, k;
        System.out.print("Eingabe: ");

        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextInt();
        int summe = 0;
        int a = 0, b = 0, c = 0;

        for (a = 0; a <= n; a++) {
            summe = summe + ((a | b) & c);

            for (b = 0; b <= m; b++) {
                summe = summe + ((a | b) & c);

                for (; c <= k; c++) {
                    summe = summe + ((a | b) & c);
                }
                c = 0;
            }
            b = 0;
        }

        System.out.println("Ausgabe: " + summe);
        scanner.close();
    }
}
