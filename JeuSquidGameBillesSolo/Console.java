package com.company.JeuSquidGameBilles;

import java.util.Scanner;

public class Console {
    public static void showNmbBilles( Joueur j1, Joueur j2) {
        System.out.println(j1.getName() +" a " + j1.getNmbBilles() + " billes restantes.");
        System.out.println(j2.getName() +" a " + j2.getNmbBilles() + " billes restantes.");

    }

    public static int inputControl(String msg, int max, int min) {

        Scanner scanner = new Scanner(System.in);
        int value;

        System.out.println(msg);

        while (true) {

            while (!scanner.hasNextInt()) {
                scanner.next();
                System.out.print("merci dentrer une valeur numerique: ");
            }
            value = scanner.nextInt();

            if (value >= min && value <= max)
                break;
            System.out.print("merci dentrer une valeur entre " + min + " and " + max +" : ");
        }

        return value;

    }
}
