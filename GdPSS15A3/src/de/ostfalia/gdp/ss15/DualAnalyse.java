package de.ostfalia.gdp.ss15;

import java.util.Scanner;

/**
 * Created by Henrik on 3/17/2015.
 *
 * @author Henrik Drefs / Maximilian Prusch
 */
public class DualAnalyse {
    /**
     * DualAnalyse
     *
     * @param args argument
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Eingabe: ");

        int a = scanner.nextInt();
        int countOnes = 0;
        System.out.print("Ausgabe: ");

        for (int i = 31; i >= 0; i--) {
            int bit = (a >> i) & 1;
            System.out.print(bit);
            if (bit == 1) {
                countOnes++;
            }
        }
        System.out.println("\nEins-Bits: " + countOnes);
        scanner.close();
    }
}
