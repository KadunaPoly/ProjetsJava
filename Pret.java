package com.company;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Pret {
    final static byte MONTHS_YEAR = 12;
    final static byte PERCENT = 100;

    public static void main(String[] args) {

        // MONTANT
        int amount = (int) inputControl("Montant de l'emprunt", 1_000_000, 1_000);
        // Taux d'intérêts annuel
        float annualInterest = (float) inputControl("Taux annuel d'intérêt", 30, 1);
        // Nombre de mensualités en terme d'année
        int years = (int) inputControl("Nombre d'années", 30, 1);

        double mortgage = calculateMortgage(amount, annualInterest, years);

        showMortgage(mortgage);
        showPaymentSchedule(amount, annualInterest, years);

    }

    private static void showMortgage(double mortgage) {
        String formattedMortgage = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Votre remboursement mensuel est de : " + formattedMortgage);
    }

    private static void showPaymentSchedule(int amount, float annualInterest, int years) {
        // Afficher le calendrier de paiement
        System.out.println("Calendrien de paiement : ");
        System.out.println("--------------");

        for(short month = 1; month <= years * MONTHS_YEAR; month++) {
            // double balance = calculateBalance(amount, annualInterest, years, month);
            System.out.println(
                    NumberFormat
                            .getCurrencyInstance()
                            .format(
                                    calculateBalance(amount, annualInterest, years, month)
                            ));
        }
    }

    public static double calculateMortgage(int amount, float annualInterest, int years) {

        float monthlyInterest = annualInterest / PERCENT / MONTHS_YEAR;
        int nbrPayments = years * MONTHS_YEAR;

        double mortgage = amount
                * (monthlyInterest * Math.pow(1 + monthlyInterest,nbrPayments ))
                / (Math.pow(1 + monthlyInterest, nbrPayments ) - 1);

        return mortgage;
    }

    public static double inputControl(String msg, double max, double min) {

        Scanner scanner = new Scanner(System.in);
        double value;

        System.out.println(msg);
        System.out.println("--------");

        while (true) {

            while (!scanner.hasNextDouble())
            {
                scanner.next();
                System.out.print("Please enter an integer or numerical value: ");
            }
            value = scanner.nextDouble();

            if(value >= min && value <= max)
                break;
            System.out.print("Please enter a value between " + min + " and " + max);
        }

        return value;

    }

    public static double calculateBalance(int amount, float annualInterest, int years, short nbrPaymentMade) {

        // B = L [(1 + c)n - (1 + c)p] / [(1 + c)n - 1]

        float monthlyInterest = annualInterest / PERCENT / MONTHS_YEAR;
        int nbrPayments = years * MONTHS_YEAR;

        // c : interet mensuel
        // l : montant emprunté
        // P : le nombre de paiement effectué
        // n : le nombre total de paiment

        double balance = amount
                * (Math.pow(1 + monthlyInterest, nbrPayments) - Math.pow(1 + monthlyInterest,nbrPaymentMade ))
                / ( Math.pow(1 + monthlyInterest, nbrPayments) - 1 );

        return balance;

    }
}

