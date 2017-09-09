package de.ostfalia.gdp.ss15;

import java.util.Scanner;

/**
 * Created by Henrik on 3/31/2015.
 */
public class Sinus {

    public static final int X_AXIS = 40;

    /**
     * Sinuskurven
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Eingabe: ");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        System.out.println("+----+----+----+----+----+----+----+----0----+----+----+----+----+----+----+----");
        for (int t = 0; t < 40; t++) {
            int spaceCounter = 0;
            double z = a + b * Math.sin(c * t * 2 * Math.PI / 360);
            spaceCounter = 40 + (int)z;
            for (int i = 0; i <= 80; i++) {
                if (i == spaceCounter) {
                    System.out.print("*");
                } else if (i == X_AXIS) {
                    if (t % 5 == 0) {
                        System.out.print("+");
                    } else {
                        System.out.print("|");
                    }
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
            scanner.close();
        }
    }
}
