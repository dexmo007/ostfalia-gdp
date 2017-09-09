package de.ostfalia.gdp.ss15;

import java.util.Scanner;

/**
 * @author Henrik
 * Created by Henrik on 3/5/2015.
 */
public class Uhrzeit {

    /**
     * @param args This calculates an amount of seconds into days, hours, minutes and seconds
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        long secIn = input.nextLong();

        int sec, min, h, d;

        sec = (int) (secIn % 60);
        secIn = (secIn - sec) / 60;

        min = (int) (secIn % 60);
        secIn = (secIn - min) / 60;

        h = (int) (secIn % 24);

        d = (int) (secIn / 24);

        System.out.println(d + " Tag(e), " + h + " Stunde(n) " + min + " Minute(n), " + sec + " Sekunde(n)");

    }
}
