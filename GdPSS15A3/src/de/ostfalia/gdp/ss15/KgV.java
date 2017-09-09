package de.ostfalia.gdp.ss15;

import java.util.Scanner;

/**
 * Created by Henrik on 3/17/2015.
 *
 * @author Henrik Drefs / Maximilian Prusch
 */
public class KgV {
    /**
     * Kleinstes Gemeinsames Vielfaches
     *
     * @param args argument
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Eingabe: ");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int kgV = (x / ggT(x, y)) * y;
        System.out.println("Ausgabe: " + kgV);
    }

    private static int ggT(int x, int y) {
        int r = 0;
        while (x % y != 0) {
            r = x % y;
            x = y;
            y = r;
        }
        return y;
    }


}
