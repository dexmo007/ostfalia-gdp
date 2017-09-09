package de.ostfalia.gdp.ss15;

import java.util.Scanner;

/**
 * Created by Henrik on 3/17/2015.
 * @author Henrik Drefs / Maximilian Prusch
 */
public class Logik {
    /**
     * Logikbaustein
     * @param args argument
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Eingänge: ");
        boolean a = in.nextBoolean();
        boolean b = in.nextBoolean();
        boolean c = in.nextBoolean();
        boolean d = in.nextBoolean();
        boolean ausgang;
        ausgang = a && b || a && c || a && d || b && c || b && d || c && d;

        System.out.println("Ausgang: " + ausgang);
        in.close();

    }


}
