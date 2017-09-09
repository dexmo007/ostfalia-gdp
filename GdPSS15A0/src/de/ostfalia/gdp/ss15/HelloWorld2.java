package de.ostfalia.gdp.ss15;

import java.util.Scanner;

/**
 * Created by Henrik on 3/10/2015.
 */
public class HelloWorld2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wer bist du?");
        String name = scanner.next();
        System.out.println("Hallo, "+name);

    }
}
