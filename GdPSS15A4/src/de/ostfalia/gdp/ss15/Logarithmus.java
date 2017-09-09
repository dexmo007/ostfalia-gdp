package de.ostfalia.gdp.ss15;

import java.util.Scanner;

/**
 * Created by Henrik on 3/24/2015.
 * @author Henrik Drefs / Maximilian Prusch
 */
public class Logarithmus {

    private static final double TERM_MIN = (Math.pow(10, -6));

    /**
     * Logarithmus
     *
     * @param args argument
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double z = scanner.nextDouble();
        double lnZ = 0.0, term, power = 1.0;
        int counter = 1;

        term = (z - 1) / (z + 1);
        while (Math.abs(term) > TERM_MIN) {
            lnZ = lnZ + term;
            counter++;
            power = power + 2;
            term = ((1 / power) * (Math.pow(((z - 1) / (z + 1)), power)));
        }
        lnZ = lnZ * 2;

        System.out.println(lnZ);
        System.out.println(Math.log(z));
        System.out.println(counter);
    }
}
