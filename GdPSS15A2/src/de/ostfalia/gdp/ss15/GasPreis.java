package de.ostfalia.gdp.ss15;

import java.util.Scanner;

/**
 * Created by Henrik on 3/10/2015.
 * @author Henrik Drefs / Maximilian Prusch.
 *
 */
public class GasPreis {

    private static final int GRUNDPREIS_KLEINVERBRAUCHSTARIF =430900, ARBEITSPREIS_KLEINVERBRAUCHSTARIF =782;
    private static final int GRUNDPREIS_GRUNDPREISTARIF =800200, ARBEITSPREIS_GRUNDPREISTARIF =679;
    private static final int EURO_TO_CENTICENT = 10000;
    private static final int CENT_TO_CENTICENT = 100;

    /**
     * Calculation of the best price for current
     * @param args argument
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int verbrauch=0;
        verbrauch = scanner.nextInt();

        int preisGpt = 0;
        int preisKvt = 0;

        if (verbrauch < 0) {
            System.out.println("Fehler: " + verbrauch + " kWh ist nicht möglich.");
        } else {
            preisKvt = verbrauch * ARBEITSPREIS_KLEINVERBRAUCHSTARIF + GRUNDPREIS_KLEINVERBRAUCHSTARIF;
            preisGpt = verbrauch * ARBEITSPREIS_GRUNDPREISTARIF + GRUNDPREIS_GRUNDPREISTARIF;
        }

        if (preisGpt > preisKvt) {
            System.out.println(preisKvt / EURO_TO_CENTICENT + " € und "
                    + (preisKvt % EURO_TO_CENTICENT) / CENT_TO_CENTICENT + " ct, Kleinverbrauchstarif");

        } else {
            System.out.println(preisGpt / EURO_TO_CENTICENT + " € und "
                    + (preisGpt % EURO_TO_CENTICENT) / CENT_TO_CENTICENT + " ct, Grundpreistarif");
        }

        scanner.close();

    }
}
